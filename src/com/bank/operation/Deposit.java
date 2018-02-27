package com.bank.operation;

public class Deposit extends BankOperation {
    @Override
    protected void operationProcess() {
        // Do transaction specific code
    }

    @Override
    protected String operationMessage() {
        return "Deposit";
    }
}
