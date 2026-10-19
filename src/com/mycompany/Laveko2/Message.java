/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Laveko2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Student
 */
public class Message {
    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;

    private static int totalMessages = 0;

    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    public String checkRecipientCell(String recipientNumber) {

        if (recipientNumber.matches("^\\+27\\d{9}$")) {
            return "Cell phone number successfully captured.";
        } else {
             return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String checkMessageLength(String messageText) {

        if (messageText.length() <= 250) {
            return "Message ready to send.";
        } else {
            int extraCharacters = messageText.length() - 250;
            return "Message exceeds 250 characters by "
                    + extraCharacters
                    + "; please reduce the size.";
        }
    }
    public void generateMessageID() {

        Random random = new Random();
        long number = 1000000000L + (long) (random.nextDouble() * 8999999999L);
        messageID = String.valueOf(number);
    }

    public String createMessageHash(int messageNumber) {

        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        messageHash = messageID.substring(0, 2)
                  + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;

        return messageHash;
    }

    public String sentMessage(int option) {

        switch (option) {

            case 1:
                totalMessages++;
                return "Message successfully sent.";
                 case 2:
                return "Press 0 to delete the message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    public String printMessages() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + message;
         }

    public int returnTotalMessages() {
        return totalMessages;
    }

    // JSON Storage
    // Reference: https://www.w3schools.com/java/java_files_create.asp
    public void storeMessage() {

        try {

            FileWriter file = new FileWriter("storedMessages.json", true);

            file.write("{\n");
            file.write("\"MessageID\":\"" + messageID + "\",\n");
             file.write("\"MessageHash\":\"" + messageHash + "\",\n");
            file.write("\"Recipient\":\"" + recipient + "\",\n");
            file.write("\"Message\":\"" + message + "\"\n");
            file.write("}\n");

            file.close();

        } catch (IOException e) {
            System.out.println("Error storing message.");
        }
    }

    public String getMessageID() {
        return messageID;
    }
     public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
     public void setMessage(String message) {
        this.message = message;
    }
}
        

