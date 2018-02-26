package com.bank.dispatcher;

import com.bank.agents.factory.Agent;
import com.bank.agents.pool.AgentPool;
import Main.Client;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
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

    private ExecutorService executor;
    private AgentPool pCashier;
    private AgentPool pDirector;
    private AgentPool pSupervisor;
    private ConcurrentLinkedQueue<Client> bankLine;

    /**
     * Initialize the ThreadPool, the pool of cashiers, the pool of supervisors
     * and the pool of directors
     */
    public Dispatcher() {
        executor = Executors.newFixedThreadPool(10);
        pCashier = new AgentPool(6, "CASHIER");
        pDirector = new AgentPool(1, "DIRECTOR");
        pSupervisor = new AgentPool(3, "SUPERVISOR");
    }

    /**
     * For each client, asks for availability of the agents, if there isn't an agent available waits
     * If there is an agent, assigns the client to the agent
     * With a thread, the agent perform the request of the client
     * When all the clients are attended, shuts down the ExecutorService
     *
     * @param bankLine is the queue which contains the clients to be attended
     * @see #assignToCashier()
     * @see #assignToDirector()
     * @see #assignToSupervisor()
     */
    public void attend(ConcurrentLinkedQueue<Client> bankLine) {
        this.bankLine = bankLine;

        while (!bankLine.isEmpty()) {
            if (pCashier.isAvailable()) {
                assignToCashier();
            } else if (pSupervisor.isAvailable()) {
                assignToSupervisor();
            } else if (pDirector.isAvailable()) {
                assignToDirector();
            }
        }
        executor.shutdown();
    }

    /**
     * Attends the client with the available agent
     *
     * Extracts an agent from the Pool
     * Extracts a client from the queue
     * Assigns the client to the agent
     * Creates a supply to the ThreadPool
     * Creates a CompletableFuture, when the tread perform its action returns a promise.
     * The promise is the agent who attended the client.
     * Displays a message whit the turn and the operation of the client, and with the id of the agent
     */
    private void assignToCashier() {
        Agent agentInUse = pCashier.removeFromDispatcher();
        Supplier<Agent> s1 = new SupplierOfAgents(agentInUse, bankLine.remove());
        CompletableFuture.supplyAsync(s1, executor).thenAccept(usedAgent -> {
            pCashier.returnObjectToPool(agentInUse);
            /*System.out.println("Took " + usedAgent.getTime() / 1000
                    + " seconds to attend the client with turn "
                    + usedAgent.getClientBeingAttended().getBankTurn()
                    + " to perform " + usedAgent.getClientBeingAttended().getOperationClient()
                    + " with the agent " + usedAgent.getType() + " " + usedAgent.getId());
                    */
        });
    }

    private void assignToSupervisor() {
        Agent agentInUse = pSupervisor.removeFromDispatcher();
        Supplier<Agent> s1 = new SupplierOfAgents(agentInUse, bankLine.remove());
        CompletableFuture.supplyAsync(s1, executor).thenAccept(usedAgent -> {
            pSupervisor.returnObjectToPool(agentInUse);
            /*System.out.println("Took " + usedAgent.getTime() / 1000
                    + " seconds to attend the client with turn "
                    + usedAgent.getClientBeingAttended().getBankTurn()
                    + " to perform " + usedAgent.getClientBeingAttended().getOperationClient()
                    + " with the agent " + usedAgent.getType() + " " + usedAgent.getId());
                    */
        });
    }

    private void assignToDirector() {
        Agent agentInUse = pDirector.removeFromDispatcher();
        Supplier<Agent> s1 = new SupplierOfAgents(agentInUse, bankLine.remove());
        CompletableFuture.supplyAsync(s1, executor).thenAccept(usedAgent -> {
            pDirector.returnObjectToPool(agentInUse);
            /*System.out.println("Took " + usedAgent.getTime() / 1000
                    + " seconds to attend the client with turn "
                    + usedAgent.getClientBeingAttended().getBankTurn()
                    + " to perform " + usedAgent.getClientBeingAttended().getOperationClient()
                    + " with the agent " + usedAgent.getType() + " " + usedAgent.getId());
                    */
        });
    }


}
