package Main;

import com.bank.operation.Operation;

/**
 * Class to be attended by the bank
 * Has a turn and the operation given by the user
 */
public class Client {
    int bankTurn;
    Operation operationClient;
    String email;
    int accountID;

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

    public String getEmail() {
        return email;
    }

    public int getAccountID() {
        return accountID;
    }

    /**
     * Returns the Operation performed by the client
     */
    public Operation getOperationClient() {
        return operationClient;
    }

    @Override
    public String toString() {
        return "Client " + bankTurn;
    }
}
