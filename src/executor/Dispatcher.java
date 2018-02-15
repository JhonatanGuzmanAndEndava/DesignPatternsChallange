package executor;

import Agentes.BusyAgent;
import Agentes.Cashier;
import Agentes.Director;
import Agentes.Supervisor;
import ObjectPoolPattern.PoolCashier;
import ObjectPoolPattern.PoolDirector;
import ObjectPoolPattern.PoolSupervisor;
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
    private PoolCashier pCashier;
    private PoolDirector pDirector;
    private PoolSupervisor pSupervisor;
    private ConcurrentLinkedQueue<Client> bankLine;

    /**
     * Initialize the ThreadPool, the pool of cashiers, the pool of supervisors
     * and the pool of directors
     */
    public Dispatcher() {
        executor = Executors.newFixedThreadPool(10);
        pCashier = new PoolCashier(6);
        pDirector = new PoolDirector(1);
        pSupervisor = new PoolSupervisor(3);
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
            } else {
                waitforDisponibility(300);
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
        Cashier UsingAgent = pCashier.removeFromDispatcher();
        UsingAgent.setClientBeingAttended(bankLine.remove());
        Supplier<BusyAgent> s1 = new SupplierOfAgents(UsingAgent);
        CompletableFuture.supplyAsync(s1, executor).thenAccept(usedAgent -> {
            pCashier.returnObjectToPool(UsingAgent);
            System.out.println("Took " + usedAgent.getTime() / 1000
                    + " seconds to attend the client with turn "
                    + usedAgent.getClientBeingAttended().getBankTurn()
                    + " to perform " + usedAgent.getClientBeingAttended().getOperationClient()
                    + " with the agent " + usedAgent.getType() + " " + usedAgent.getId());
        });
    }

    private void assignToSupervisor() {
        Supervisor UsingAgent = pSupervisor.removeFromDispatcher();
        UsingAgent.setClientBeingAttended(bankLine.remove());
        Supplier<BusyAgent> s1 = new SupplierOfAgents(UsingAgent);
        CompletableFuture.supplyAsync(s1, executor).thenAccept(usedAgent -> {
            pSupervisor.returnObjectToPool(UsingAgent);
            System.out.println("Took " + usedAgent.getTime() / 1000
                    + " seconds to attend the client with turn "
                    + usedAgent.getClientBeingAttended().getBankTurn()
                    + " to perform " + usedAgent.getClientBeingAttended().getOperationClient()
                    + " with the agent " + usedAgent.getType() + " " + usedAgent.getId());
        });
    }

    private void assignToDirector() {
        Director UsingAgent = pDirector.removeFromDispatcher();
        UsingAgent.setClientBeingAttended(bankLine.remove());
        Supplier<BusyAgent> s1 = new SupplierOfAgents(UsingAgent);
        CompletableFuture.supplyAsync(s1, executor).thenAccept(usedAgent -> {
            pDirector.returnObjectToPool(UsingAgent);
            System.out.println("Took " + usedAgent.getTime() / 1000
                    + " seconds to attend the client with turn "
                    + usedAgent.getClientBeingAttended().getBankTurn()
                    + " to perform " + usedAgent.getClientBeingAttended().getOperationClient()
                    + " with the agent " + usedAgent.getType() + " " + usedAgent.getId());
        });
    }

    /**
     * Causes the current thread to suspend execution for a specified period
     *
     * @param time
     */
    private void waitforDisponibility(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
