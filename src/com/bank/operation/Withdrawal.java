package com.bank.operation;

public class Withdrawal extends BankOperation {
    @Override
    protected void operationProcess() {
        // Do transaction specific code
    }

    @Override
    protected String operationMessage() {
        return "Withdrawal";
    }
}
