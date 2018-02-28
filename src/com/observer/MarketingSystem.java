package com.observer;

import com.messages.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> messageInformation = Arrays.asList(transactionMessage.getInformation().split(","));
        String customerID = messageInformation.get(0);
        double transactionValue = Double.parseDouble(messageInformation.get(6));
        String email = messageInformation.get(1);

        mkt.updateInformation(customerID, transactionValue, email);
    }


}
