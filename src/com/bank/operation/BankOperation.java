package com.bank.operation;

public abstract class BankOperation {
    public final void performOperation{
        operationProcess();
        operationMessage();
    }

    protected abstract void operationProcess();
    protected abstract String operationMessage();
}
