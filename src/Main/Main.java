package Main;

import executor.Dispatcher;

import javax.swing.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import static Main.WelcomeToClient.welcome;
import static Main.Messages.*;

/**
 * Class responsible for initializing the bank process
 * and to collect the clients's information
 */
public class Main {

    private static ConcurrentLinkedQueue<Client> bankLine;

    /**
     * This method sends a dialogue box with a welcome message.
     * With the method readNumberOfClients, reads the number of clients to be attended.
     * Creates the clients and let the user to select the operation of each client. Create a Queue with the clients
     * Finally makes the request to Dispatcher to attend the clients of the Queue with the method attend()
     *
     * @see WelcomeToClient#welcome()
     * @see #readNumberOfClients()
     * @see #createLineofClients(int)
     */
    public static void main(String[] args) {
        bankLine = new ConcurrentLinkedQueue<>();
        Dispatcher asesor = new Dispatcher();
        int numberofClients;

        welcome();

        numberofClients = readNumberOfClients();

        createLineofClients(numberofClients);

        asesor.attend(bankLine);
    }

    /**
     * Reads the number of clients with a pane-showInputDialog
     * If the input is invalid (if input is not a number) displays an error message with a pane-showMessageDialog until the user enters a correct input
     * If the user selects the option "cancel" of the pane, the program ends
     *
     * @return the number of clients entered by the user
     */
    private static int readNumberOfClients() {
        try {
            String numOfClient = JOptionPane.showInputDialog(numberOfClients);
            if (numOfClient.matches("[0-9]*")) {
                return Integer.parseInt(numOfClient);
            } else {
                JOptionPane.showMessageDialog(null, invOption, "Error", JOptionPane.ERROR_MESSAGE);
                int number = readNumberOfClients();
                return number;
            }
        } catch (NullPointerException e) {
            System.exit(0);
        }
        return 0;
    }

    /**
     * With the method createClient creates the number of clients specified
     * Inserts the clients created to the Queue
     *
     * @param numberOfClients indicates the number of clients to be created
     * @see #createClient(int)
     */
    private static void createLineofClients(int numberOfClients) {
        int clientsInLine = 0;
        for (int i = 0; i < numberOfClients; i++) {
            bankLine.add((createClient(clientsInLine)));
            clientsInLine++;
        }
    }

    /**
     * Reads with the method readOperation(int) the operation that the client being created wants to perform
     * Creates a client and gives to each client a turn and the operation
     *
     * @param antTurn is the turn of the last client created
     * @return the client created
     * @see #readOperation(int)
     */
    private static Client createClient(int antTurn) {
        Operation operationClient = readOperation(antTurn);
        return new Client(antTurn, operationClient);
    }

    /**
     * With the pane-showOptionDialog lets the user to select the operation to be perform for each client
     * If the user closes the frame, the program ends
     *
     * @param turn is the turn of the client which is going to perform the operation
     * @return the operation of the client of turn turn
     */
    private static Operation readOperation(int turn) {
        turn++;
        Operation[] options = {Operation.Deposits, Operation.Withdrawals, Operation.Resolving_customer_issues};
        int seleccion = JOptionPane.showOptionDialog(null, readOpClient + turn, "Operation", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        switch (seleccion) {
            case 0:
                return Operation.Deposits;
            case 1:
                return Operation.Withdrawals;
            case 2:
                return Operation.Resolving_customer_issues;
            case -1:
                System.exit(0);
        }
        return Operation.invalid;
    }


}


