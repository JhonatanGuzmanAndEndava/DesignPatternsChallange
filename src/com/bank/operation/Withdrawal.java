package com.bank.operation;

public class Withdrawal extends BankOperation {
    public Withdrawal(int operationValue) {
        super(operationValue);
    }

    @Override
    protected void operationProcess() {
        try {
            Thread.sleep(this.getOperationDuration());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getOperationType() {
        return "Withdrawal";
    }
}
