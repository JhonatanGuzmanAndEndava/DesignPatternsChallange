package com.bank.operation;

import java.time.LocalDateTime;

public abstract class BankOperation {
    protected final LocalDateTime operationDate;
    protected final int operationValue;

    public BankOperation(int operationValue) {
        this.operationDate = LocalDateTime.now();
        this.operationValue = operationValue;
    }

    public final String performOperation(){
        operationProcess();
        return operationMessage();
    }

    public final String type(){
        return this.getOperationType();
    }

    protected final String operationMessage(){
        return "Performed a "+this.getOperationType()+" with value "+this.getOperationValue()+" on "+this.getOperationDate();
    }

    protected final LocalDateTime getOperationDate() {
        return operationDate;
    }

    protected final int getOperationValue() {
        return operationValue;
    }

    protected abstract void operationProcess();
    protected abstract String getOperationType();
}
