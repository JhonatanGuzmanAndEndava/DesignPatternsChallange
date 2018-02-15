package executor;

import Agentes.BusyAgent;
import Main.Client;

import java.util.function.Supplier;

/**
 * Class responsible for attending a given client with a given agent
 * When the threadPool attends the supply, this class indicates the action to be performed with the thread
 */
public class SupplierOfAgents implements Supplier<BusyAgent> {

    BusyAgent Agentbeing;
    Client client;

    /**
     * Constructor method
     * @param Agentbeing is the Agent which is going to attend the client
     */
    public SupplierOfAgents(BusyAgent Agentbeing) {
        this.Agentbeing = Agentbeing;
    }

    @Override
    /**
     * Displays a message to tell the user which agent is attending which client
     * Calculates the attention time
     * Causes the current thread to suspend execution for that attention time
     * Assigns to the Agent the attention time
     */
    public BusyAgent get() {
        client = Agentbeing.getClientBeingAttended();
        System.out.println("!   Client with turn " + client.getBankTurn() + " assigned to " + Agentbeing.getType()+" "+ Agentbeing.getId());
        try {

            long tiempo = ((int) Math.floor(Math.random() * (6) + 10)) * 1000;
            Agentbeing.setTime(tiempo);
            Thread.sleep(tiempo);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Agentbeing;
    }

}
