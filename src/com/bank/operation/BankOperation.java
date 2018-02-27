package com.bank.operation;

import java.time.LocalDateTime;

public abstract class BankOperation {
    protected final LocalDateTime operationDate;
    protected final int operationValue;
    protected final int operationDuration;

    public BankOperation(int operationValue) {
        this.operationDate = LocalDateTime.now();
        this.operationValue = operationValue;
        this.operationDuration = ((int) Math.floor(Math.random() * (6) + 10)) * 1000;
    }

    public final String performOperation(){
        operationProcess();
        return operationMessage();
    }

    public final String type(){
        return this.getOperationType();
    }

    public final int getOperationDuration(){
        return this.operationDuration;
    }

    protected final String operationMessage(){
        return "Performed a "+this.getOperationType()+" with value "+this.getOperationValue()+" on "+this.getOperationDate()
                + " took: " + this.getOperationDuration()/1000 + "s";
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
