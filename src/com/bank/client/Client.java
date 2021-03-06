package com.bank.client;

import com.bank.operation.BankOperation;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class to be attended by the bank
 * Has a turn and the operation given by the user
 */
public class Client {
    int bankTurn;
    BankOperation operation;
    String email;
    int accountID;

    /**
     * Constructor method of the client
     */
    public Client(int bankTurn, BankOperation operation) {
        this.bankTurn = ++bankTurn;
        this.operation = operation;
        this.email = "client"+String.valueOf(this.bankTurn)+"@hotmail.com";
        this.accountID = ThreadLocalRandom.current().nextInt(1,10000);
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
    public BankOperation getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "Client " + bankTurn;
    }
}
