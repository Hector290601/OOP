/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
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
    private JComboBox<String> people;
    private JMenuBar menu;
    public ChatClient(){
        outputMessages = new JTextArea(10, 50);
        inputMessage = new JTextField(50);
        send = new JButton ("Send");
        quit = new JButton ("Quit");
        menu = new JMenuBar();
    }
    public void launchFrame(){
        Socket s1;
        InputStream is;
        InputStreamReader isR;
        OutputStream os;
        BufferedReader bfr;
        PrintStream ps;
        try{
            s1 = new Socket("192.168.1.75", 2000);
            is = s1.getInputStream();
            os = s1.getOutputStream();
            isR = InputStreamReader(is);
        }catch (ConnectException e) {
            System.err.println("Could not connect to the server.");
            e.printStackTrace();
        }catch (IOException e1) {
            e1.printStackTrace();
        }
        JFrame frame = new JFrame ("Chat App");
        frame.setLocationRelativeTo(null);
        frame.add(outputMessages, BorderLayout.WEST);
        frame.add(inputMessage, BorderLayout.SOUTH);
        JPanel panel1 = new JPanel();
        panel1.add(send);
        panel1.add(quit);
        people = new JComboBox<String> ();
        people.setBounds(10, 10, 80, 20);
        people.addItem("Omar");
        people.addItem("Hector");
        people.addItem("Diana");
        people.addItem("Nico");
        panel1.add(people);
        JMenuItem file = new JMenu("Files");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem itemQuit = new JMenuItem("Quit");
        file.add(itemQuit);
        itemQuit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        menu.add(file);
        menu.add(helpMenu);
        frame.setJMenuBar(menu);
        Action action = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                String stringToSend = inputMessage.getText();
                inputMessage.setText("");
                String history = outputMessages.getText();
                history += stringToSend + "\n";
                outputMessages.setText(history);
            }
        };
        inputMessage.addActionListener(action);
        send.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String stringToSend = inputMessage.getText();
                if (!stringToSend.isBlank()){
                    inputMessage.setText("");
                    String history = outputMessages.getText();
                    String to;
                    to = (String) people.getSelectedItem();
                    history += "Me -> " + to + ":\n" + stringToSend + "\n";
                    outputMessages.setText(history);
                }
            }
        });
        quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
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
