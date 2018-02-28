package com.bank.operation;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public abstract class BankOperation {
    protected final LocalDateTime operationDate;
    protected final int operationValue;
    protected final int operationDuration;

    public BankOperation(int operationValue) {
        this.operationDate = LocalDateTime.now();
        this.operationValue = operationValue;
        this.operationDuration = ThreadLocalRandom.current().nextInt(10000,15000);
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

    public final LocalDateTime getOperationDate() {
        return operationDate;
    }

    public final int getOperationValue() {
        return operationValue;
    }

    protected abstract void operationProcess();
    protected abstract String getOperationType();
}
