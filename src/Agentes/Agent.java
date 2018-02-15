package Agentes;

import Main.Client;

/**
 * Agents of the bank
 * Has the time the agent use to attend the client, the Type of agent, the id of the agent and an associated client to attend
 * Has the setters and the getters to modify the attributes
 */
public class Agent implements BusyAgent {
    private long time;
    private TypeOfAgent type;
    private int id;
    private Client clientBeingAttended;

    /**
     * Constructor method
     */
    public Agent(TypeOfAgent type, int id) {
        this.type = type;
        this.id = id;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public TypeOfAgent getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public Client getClientBeingAttended() {
        return clientBeingAttended;
    }

    public void setClientBeingAttended(Client clientBeingAttended) {
        this.clientBeingAttended = clientBeingAttended;
    }
}
