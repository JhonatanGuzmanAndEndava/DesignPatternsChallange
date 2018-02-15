package Main;

/**
 * Class to be attended by the bank
 * Has a turn and the operation given by the user
 */
public class Client {
    int bankTurn;
    Operation operationClient;

    /**
     * Constructor method of the client
     */
    public Client(int bankTurn, Operation operationClient) {
        this.bankTurn = ++bankTurn;
        this.operationClient = operationClient;
    }

    /**
     * Returns the turn of the client
     */
    public int getBankTurn() {
        return bankTurn;
    }

    /**
     * Returns the Operation performed by the client
     */
    public Operation getOperationClient() {
        return operationClient;
    }
}
