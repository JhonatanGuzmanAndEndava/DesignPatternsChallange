package com.bank.operation;

public class CustomerIssue extends BankOperation {
    public CustomerIssue(int operationValue) {
        super(operationValue);
    }

    @Override
    protected void operationProcess() {
        // Do transaction specific code
        try {
            Thread.sleep(this.getOperationDuration());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String getOperationType() {
        return "Customer issue";
    }
}
