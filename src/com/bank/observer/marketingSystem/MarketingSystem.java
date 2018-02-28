package com.bank.observer.marketingSystem;

import com.bank.messages.Message;
import com.bank.messages.TransactionMessage;
import com.bank.observer.Observer;

public class MarketingSystem implements Observer {

    private Message transactionMessage;
    private MktServiceLegacy mkt;

    public MarketingSystem(MktServiceLegacy mkt) {
        this.mkt = mkt;
    }

    @Override
    public void update(Message transactionMessage) {
        this.transactionMessage = transactionMessage;
        adapter();
    }

    public void adapter(){
        TransactionMessage transactionMsg = (TransactionMessage)transactionMessage;
        mkt.updateInformation(String.valueOf(transactionMsg.getCustomerID()), transactionMsg.getTransactionValue(), transactionMsg.getCustomerEmail());
    }


}
