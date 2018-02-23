package com.bank.agents;

/**
 * Pool of supervisors
 */
public class PoolSupervisor extends ObjectPool<Supervisor> {

    public PoolSupervisor(int numofAgents) {
        super(numofAgents);
    }

    @Override
    /**
     *Creates a supervisor with ID = usedID+1
     * @param usedID is the ID of the last object created
     * @return the created supervisor
     */
    protected Supervisor createObject(int usedId) {

        return new Supervisor(++usedId);
    }
}

