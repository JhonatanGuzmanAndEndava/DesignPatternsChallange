package com.bank.operation;

public class CustomerIssue extends BankOperation {
    @Override
    protected void operationProcess() {
        // Do transaction specific code
    }

    @Override
    protected String operationMessage() {
        return "Customer issue";
    }
}
