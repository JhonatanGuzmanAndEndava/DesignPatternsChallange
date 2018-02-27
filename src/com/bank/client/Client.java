package com.bank.client;

import com.bank.operation.BankOperation;

/**
 * Class to be attended by the bank
 * Has a turn and the operation given by the user
 */
public class Client {
    int bankTurn;
    BankOperation operation;

    /**
     * Constructor method of the client
     */
    public Client(int bankTurn, BankOperation operation) {
        this.bankTurn = ++bankTurn;
        this.operation = operation;
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
    public BankOperation getOperation() {
        return operation;
    }
}
