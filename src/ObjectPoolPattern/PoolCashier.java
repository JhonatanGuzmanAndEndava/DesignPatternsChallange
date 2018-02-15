package ObjectPoolPattern;

import Agentes.Cashier;

/**
 * Pool of cashiers
 */
public class PoolCashier extends ObjectPool<Cashier> {

    public PoolCashier(int numofAgents) {

        super(numofAgents);
    }

    @Override
    /**
     *Creates a cashier with ID = usedID+1
     * @param usedID is the ID of the last object created
     * @return the created cashier
     */
    protected Cashier createObject(int usedId) {
        return new Cashier(++usedId);
    }

}
