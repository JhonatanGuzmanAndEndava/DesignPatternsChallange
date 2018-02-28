package com.bank.observer.auditModule;

import com.bank.messages.Message;
import com.bank.messages.TransactionMessage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static void writeLog(Message transactionMessage) {
        try {

            LocalDateTime ls = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
            String format = ls.format(formatter);

            TransactionMessage transactioMsg = (TransactionMessage)transactionMessage;
            String msg = transactioMsg.getCustomerID()+","+transactioMsg.getAccountID()+","+transactioMsg.getCustomerEmail();
            String nameFile = "DEPOSITSTOREVIEW" + format + ".txt";
            FileWriter fw = new FileWriter(nameFile,true);
            fw.write(msg + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
