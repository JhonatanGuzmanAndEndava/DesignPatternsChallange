package com.messages;
import com.bank.operation.Operation;

public class TransactionMessage implements Message{

    private int customerID;
    private String customerEmail;
    private int agentID;
    private String agentType;
    private int accountID;
    private String transactionDate;
    private double transactionValue;
    private Operation transationType;

    public TransactionMessage(int customerID, String customerEmail, int agentID, String agentType, int accountID, String transationDate, double transactionValue, Operation transationType) {
        this.customerID = customerID;
        this.customerEmail = customerEmail;
        this.agentID = agentID;
        this.agentType = agentType;
        this.accountID = accountID;
        this.transactionDate = transationDate;
        this.transactionValue = transactionValue;
        this.transationType = transationType;
    }

    @Override
    public String getInformation() {
        return customerID+","+customerEmail+","+agentID+","+agentType+","+accountID+","+ transactionDate +","+transactionValue+","+transationType;
    }
}
