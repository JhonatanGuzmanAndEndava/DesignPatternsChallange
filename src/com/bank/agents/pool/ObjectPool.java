package com.bank.agents.pool;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Has a queue of objects of class <T>
 * T can be a Cashier, a Director or a Supervisor all of them are BusyAgent
 * Lets to remove an object of the queue, use it and finally add it again to the queue
 * @param <T> Interface
 */
public abstract class ObjectPool<T> {

    private ConcurrentLinkedQueue<T> pool;

    /**
     * Constructor of the Pool, initialize the queue
     * @param numOfAgents indicates the number of object that has to be created
     * @param type indicates the type of agent that has to be created
     * @see #initialize(int, String)
     */
    public ObjectPool(int numOfAgents, String type) {
        initialize(numOfAgents, type);
    }

    /**
     * Creates the objects of class <T> and add them to the queue
     * Objects are created in method createObject(int)
     * @param numOfAgents indicates the number of object that has to be created
     * @param type indicates the type of agent that has to be created
     * @see #createObject(String)
     */
    private void initialize(int numOfAgents, String type) {
        pool = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < numOfAgents; i++) {
            pool.add(createObject(type));
        }
    }

    /**
     * Creates an object, classes which extends from this class implements the method
     * @return the object
     */
    protected abstract T createObject(String type);

    /**
     * Extracts an object from the queue
     * Reduces the attribute numObObjectsInPool
     * @return the extracted object
     */
    public T removeFromDispatcher() {
        T object;
        object = pool.remove();
        return object;
    }

    /**
     *Returns the used object to the Pool
     * @param object
     */
    public void returnObjectToPool(T object) {
        pool.add(object);
    }

    /**
     *If the pool is empty returns false
     * @return true if there is an object in the pool
     */
    public boolean isAvailable() {
        return !pool.isEmpty();
    }

}
