package com.bank.operation;

public class Deposit extends BankOperation {
    public Deposit(int operationValue) {
        super(operationValue);
    }

    @Override
    protected void operationProcess() {
        // Do transaction specific code
    }

    @Override
    protected String getOperationType() {
        return "Deposit";
    }
}
