/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Laveko2;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Laveko2 {

   public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

       login  login = new login();

        System.out.println("===== QUICKCHAT LOGIN =====");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();
         if (login.loginUser(username, password)) {

            System.out.println("Welcome to QuickChat.");

            System.out.print("How many messages would you like to send? ");
            int totalMessages = input.nextInt();
            input.nextLine();

            int option = 0;
            int sentCounter = 0;

            while (option != 3) {
                System.out.println("\n===== MENU =====");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.print("Choose an option: ");

                option = input.nextInt();
                input.nextLine();

                switch (option) {

                    case 1:
                         for (int i = sentCounter; i < totalMessages; i++) {

                            Message message = new Message();

                            System.out.print("Enter recipient number: ");
                            String recipient = input.nextLine();

                            System.out.print("Enter your message: ");
                            String messageText = input.nextLine();

                            String recipientResult = message.checkRecipientCell(recipient);
                            System.out.println(recipientResult);

                            String messageResult = message.checkMessageLength(messageText);
                            System.out.println(messageResult);
                             if (recipientResult.equals("Cell phone number successfully captured.")
                                    && messageResult.equals("Message ready to send.")) {

                                message.setRecipient(recipient);
                                message.setMessage(messageText);
                                message.generateMessageID();
                                message.createMessageHash(i);

                                System.out.println("\nChoose message option:");
                                System.out.println("1) Send Message");
                                System.out.println("2) Disregard Message");
                                System.out.println("3) Store Message");

                                int sendOption = input.nextInt();
                                input.nextLine();
                                  String result = message.sentMessage(sendOption);
                                System.out.println(result);

                                if (sendOption == 1) {
                                    sentCounter++;

                                    System.out.println("\n===== MESSAGE DETAILS =====");
                                    System.out.println("Message ID: " + message.getMessageID());
                                    System.out.println("Message Hash: " + message.getMessageHash());
                                    System.out.println("Recipient: " + message.getRecipient());
                                    System.out.println("Message: " + message.getMessage());
                                }

                                if (sendOption == 3) {
                                    message.storeMessage();
                                }
                            }
                              }

                        System.out.println("Total messages sent: " + sentCounter);
                        break;

                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
                 }

        } else {
            System.out.println("Username or password incorrect, please try again.");
        }
    }
}
            