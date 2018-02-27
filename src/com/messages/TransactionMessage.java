package com.messages;
import com.bank.operation.BankOperation;

public class TransactionMessage implements Message{

    private int customerID;
    private String customerEmail;
    private int agentID;
    private String agentType;
    private int accountID;
    private String transactionDate;
    private double transactionValue;
    private BankOperation transactionType;

    public TransactionMessage(int customerID, String customerEmail, int agentID, String agentType, int accountID, String transactionDate, double transactionValue, BankOperation transactionType) {
        this.customerID = customerID;
        this.customerEmail = customerEmail;
        this.agentID = agentID;
        this.agentType = agentType;
        this.accountID = accountID;
        this.transactionDate = transactionDate;
        this.transactionValue = transactionValue;
        this.transactionType = transactionType;
    }

    @Override
    public String getInformation() {
        return customerID+","+customerEmail+","+agentID+","+agentType+","+accountID+","+ transactionDate +","+transactionValue+","+transactionType.type();
    }
}
