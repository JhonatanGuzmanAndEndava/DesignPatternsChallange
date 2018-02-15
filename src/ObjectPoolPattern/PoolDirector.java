package ObjectPoolPattern;

import Agentes.Director;

/**
 * Pool of directors
 */
public class PoolDirector extends ObjectPool<Director> {

    public PoolDirector(int numofAgents) {
        super(numofAgents);
    }

    @Override
    /**
     *Creates a director with ID = usedID+1
     * @param usedID is the ID of the last object created
     * @return the created director
     */
    protected Director createObject(int usedId) {
        return new Director(++usedId);
    }

}
