package ObjectPoolPattern;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Has a queue of objects of class <T>
 * T can be a Cashier, a Director or a Supervisor all of them are BusyAgent
 * Lets to remove an object of the queue, use it and finally add it again to the queue
 * @param <T> Interface
 */
public abstract class ObjectPool<T> {

    private ConcurrentLinkedQueue<T> pool;
    private int numOfObjectsInPool;

    /**
     * Constructor of the Pool, initialize the queue
     * @param numofAgents
     * @see #initialize(int)
     */
    public ObjectPool(int numofAgents) {
        numOfObjectsInPool =0;
        initialize(numofAgents);
    }

    /**
     * Creates the objects of class <T> and add them to the queue
     * Objects are created in method createObject(int)
     * @param numofAgents indicates the number of object that has to be created
     * @see #createObject(int)
     */
    private void initialize(int numofAgents) {
        pool = new ConcurrentLinkedQueue<T>();
        for (int i = 0; i < numofAgents; i++) {
            pool.add(createObject(numOfObjectsInPool));
            numOfObjectsInPool++;
        }
    }

    /**
     * Creates an object, classes which extends from this class implements the method
     * @param numdeObjectsinPool is the ID of the last object created
     * @return the object
     */
    protected abstract T createObject(int numdeObjectsinPool);

    /**
     * Extracts an object from the queue
     * Reduces the attribute numObObjectsInPool
     * @return the extracted object
     */
    public T removeFromDispatcher() {
        T object;
        object = pool.remove();
        numOfObjectsInPool--;
        return object;
    }

    /**
     *Returns the used objetc to the Pool
     * @param object
     */
    public void returnObjectToPool(T object) {
        pool.add(object);
        numOfObjectsInPool++;
    }

    /**
     *If the pool is empty returns false
     * @return true if there is an object in the pool
     */
    public boolean isAvailable() {
        if (numOfObjectsInPool == 0) {
            return false;
        }
        return true;
    }

}
