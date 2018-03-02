package com.bank.observer.auditModule;

import com.bank.messages.Message;
import com.bank.messages.TransactionMessage;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static void writeLog(Message transactionMessage, String regExpDate) {
        try {

            LocalDateTime ls = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(regExpDate);
            String format = ls.format(formatter);

            TransactionMessage transactionMsg = (TransactionMessage)transactionMessage;
            String msg = transactionMsg.getCustomerID()+","+transactionMsg.getAccountID()+","+transactionMsg.getCustomerEmail();
            String nameFile = "DEPOSITSTOREVIEW" + format + ".txt";
            FileWriter fw = new FileWriter(nameFile,true);
            fw.write(msg + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
