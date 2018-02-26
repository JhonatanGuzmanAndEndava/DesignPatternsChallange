package com.bank.dispatcher;

public abstract class BankListObserver {
    protected BankFile bankFile;
    public abstract void update();
}
