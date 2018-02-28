package com.observer;

import com.messages.Message;

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

            String msg = transactionMessage.getInformation();
            String nameFile = "DEPOSITSTOREVIEW" + format + ".txt";
            FileWriter fw = new FileWriter(nameFile,true);
            fw.write(msg + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
