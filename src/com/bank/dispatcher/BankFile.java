package com.bank.dispatcher;

import Main.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BankFile {

    private ConcurrentLinkedQueue<Client> bankFile;
    private List<BankListObserver> bankListObserver = new ArrayList<>();

    private int count = 0;

    public BankFile() {
        this.bankFile = new ConcurrentLinkedQueue<>();
    }

    public BankFile(ConcurrentLinkedQueue<Client> bankFile) {
        this.bankFile = bankFile;
    }

    public void addObserver(BankListObserver observer) {
        this.bankListObserver.add(observer);
    }

    public void removeObserver(BankListObserver observer) {
        this.bankListObserver.remove(observer);
    }

    public void addClient(Client e) {
        bankFile.add(e);
    }

    public Client removeClient() {
        return bankFile.remove();
    }

    public boolean isClientInQueue() {
        return bankFile.isEmpty();
    }

    public void attendFirstClients(int numberOfClients) {
        for (int i = 0; i<numberOfClients; ++i) {
            notifyAllObservers();
            System.out.println("Clientes en cola: " + bankFile.size());
        }
    }

    public void attendClient() {
        notifyAllObservers();
        System.out.println("Clientes en cola: " + bankFile.size());
    }

    public void notifyAllObservers() {
        for (BankListObserver observer : bankListObserver) {
            observer.update();
        }
    }
}
