package com.bank.operation;

public class Withdrawal extends BankOperation {
    public Withdrawal(int operationValue) {
        super(operationValue);
    }

    @Override
    protected void operationProcess() {
        // Do transaction specific code
    }

    @Override
    protected String getOperationType() {
        return "Withdrawal";
    }
}
