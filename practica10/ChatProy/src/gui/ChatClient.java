/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author hector
 */
public class ChatClient {
    private JTextArea outputMessages;
    private JTextField inputMessage;
    private JButton send;
    private JButton quit;
    public ChatClient(){
        outputMessages = new JTextArea(10, 50);
        inputMessage = new JTextField(50);
        send = new JButton ("Send");
        quit = new JButton ("Quit");
    }
    public void launchFrame(){
        JFrame frame = new JFrame ("Chat App");
        frame.setLocationRelativeTo(null);
        frame.add(outputMessages, BorderLayout.WEST);
        frame.add(inputMessage, BorderLayout.SOUTH);
        JPanel panel1 = new JPanel();
        panel1.add(send);
        panel1.add(quit);
        frame.add(panel1, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String [] args){
        ChatClient chat = new ChatClient();
        chat.launchFrame();
    }
}
