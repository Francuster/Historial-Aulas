package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.FileWriter;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final String FILE_PATH = "historial.txt";

    public static void main(String[] args) {
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.setClientID("ListenerApp1"); // Unique client ID for durable subscription
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("courseComparisonTopic");

            // Durable subscription to receive messages even if offline
            MessageConsumer consumer = session.createDurableSubscriber(topic, "SubscriptionName");

            System.out.println("Listening to courseComparisonTopic...");

            while (true) {
                TextMessage message = (TextMessage) consumer.receive();
                if (message != null) {
                    String differences = message.getText();
                    System.out.println("Received: " + differences);
                    // Save to file or process as needed
                    // Append the received message to "cambios.txt"
                    appendToFile(FILE_PATH, differences);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void appendToFile(String filePath, String text) {
        try (FileWriter writer = new FileWriter(filePath, true)) { // 'true' enables append mode
            writer.write(text + System.lineSeparator()); // Adds a newline after each message
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}