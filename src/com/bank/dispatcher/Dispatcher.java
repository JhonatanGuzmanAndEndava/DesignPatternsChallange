package com.bank.dispatcher;

import com.bank.agents.factory.Agent;
import com.bank.agents.pool.AgentPool;
import Main.Client;
import com.messages.Message;
import com.messages.ServiceMsg;
import com.messages.TransactionMessage;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * Class responsible for attending the clients
 * Dispatcher has a threadPool of 10 threads,
 * Tree pools of agents: a pool of cashiers, a pool of director and a pool of supervisors
 * And a queue of clients to be attended
 *
 * With the method attend, searches for the availability of an agent and assign the client to this.
 * Makes a supply to the poolThread and creates a CompletableFuture
 */
public class Dispatcher {

    private final int CASHIERS = 6;
    private final int SUPERVISOR = 3;
    private final int DIRECTOR = 1;

    private ExecutorService executor;
    private AgentPool pCashier;
    private AgentPool pDirector;
    private AgentPool pSupervisor;
    private BankFile bankFile;

    private static Dispatcher instance;

    /**
     * Initialize the ThreadPool, the pool of cashiers, the pool of supervisors
     * and the pool of directors
     */
    private Dispatcher() {
        executor = Executors.newFixedThreadPool(10);
        pCashier = new AgentPool(CASHIERS, "CASHIER");
        pSupervisor = new AgentPool(SUPERVISOR, "SUPERVISOR");
        pDirector = new AgentPool(DIRECTOR, "DIRECTOR");
    }

    public static Dispatcher getInstance() {
        if(instance == null) {
            instance = new Dispatcher();
        }
        return instance;
    }

    public void attend(Client client) {
        if (pCashier.isAvailable()) {
            assignToCashier(client);
        } else if (pSupervisor.isAvailable()) {
            assignToSupervisor(client);
        } else if (pDirector.isAvailable()) {
            assignToDirector(client);
        }
    }

    private void assignToCashier(Client client) {
        Agent agentInUse = pCashier.removeFromDispatcher();
        assign(agentInUse, client,pCashier);
    }

    private void assignToSupervisor(Client client) {
        Agent agentInUse = pSupervisor.removeFromDispatcher();
        assign(agentInUse, client,pSupervisor);
    }

    private void assignToDirector(Client client) {
        Agent agentInUse = pDirector.removeFromDispatcher();
        assign(agentInUse, client,pDirector);
    }

    private void assign(Agent agentInUse,Client client,AgentPool pAgent) {
        Supplier<Agent> s1 = new SupplierOfAgents(agentInUse, client);
        CompletableFuture.supplyAsync(s1, executor).thenAccept(usedAgent -> {
            //String s = usedAgent.getJobName()+" "+usedAgent.getAgentId()+" has attended " + client.toString();
            //System.out.println(s);
            Message transactionMessage = new TransactionMessage(client.getBankTurn(),client.getEmail(),usedAgent.getAgentId(),usedAgent.getJobName(),client.getAccountID(),"Transaction date",10000,client.getOperationClient());
            ServiceMsg.sendMessagetransaction(transactionMessage);
            pAgent.returnObjectToPool(usedAgent);
            attendAnotherClient();
        });
    }

    public void setBankFile(BankFile bankFile) {
        this.bankFile = bankFile;
    }

    public void startToAttend() {
        if(bankFile.getNumberOfClients() < CASHIERS + SUPERVISOR + DIRECTOR)
            bankFile.attendFirstClients(bankFile.getNumberOfClients());
        else
            bankFile.attendFirstClients(CASHIERS + SUPERVISOR + DIRECTOR);
    }

    public void attendAnotherClient() {
        if(bankFile.isClientInQueue()) {
            executor.shutdown();
        }
        else {
            bankFile.attendClient();
        }
    }
}
