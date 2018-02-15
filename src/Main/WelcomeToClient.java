package Main;

import javax.swing.*;
import java.awt.*;

import static Main.Messages.bankName;
import static Main.Messages.messageWelcome;

/**
 * This class has the method which sends the label with the welcome message to the users
 */
public class WelcomeToClient {

    /**
     * Creates a JFrame
     * Then creates a JLabel in the frame in which displays the text "messageWelcome"
     * Shows the JFrame for 2 seconds and finally disposes it
     */
    public static void welcome() {
        JFrame window = new JFrame(bankName);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 200);
        window.setVisible(true);

        JLabel messageofWelcome = new JLabel();
        messageofWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        window.getContentPane().add(messageofWelcome);

        window.setLocationRelativeTo(null);
        messageofWelcome.setText(messageWelcome);
        messageofWelcome.setFont(new Font("Serif", Font.PLAIN, 40));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        window.setVisible(false);
        window.dispose();
    }
}
