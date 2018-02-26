package com.bank.dispatcher;

public class AttendObserver extends BankListObserver {

    public AttendObserver(BankFile bankFile) {
        this.bankFile = bankFile;
    }

    @Override
    public synchronized void update() {
        Dispatcher dispatcher = Dispatcher.getInstance();
        dispatcher.attend(bankFile.removeClient());
        bankFile.attendClient();
    }
}
