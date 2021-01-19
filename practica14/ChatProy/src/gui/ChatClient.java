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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author hector
 */
class ChatClient {
    private JTextArea outputMessages;
    private JTextField inputMessage;
    private JButton send;
    private JButton quit;
    private JComboBox<String> people;
    private JMenuBar menu;
    protected Socket s1;
    protected InputStream is;
    protected InputStreamReader isR;
    protected OutputStream os;
    protected BufferedReader bfr;
    protected PrintStream ps;
    protected Thread th;
    public ChatClient(){
        outputMessages = new JTextArea(10, 50);
        inputMessage = new JTextField(50);
        send = new JButton ("Send");
        quit = new JButton ("Quit");
        menu = new JMenuBar();
    }
    public void launchFrame(){
        try{
            s1 = new Socket("189.130.219.5", 2000);
            is = s1.getInputStream();
            os = s1.getOutputStream();
            isR = new InputStreamReader(is);
            bfr = new BufferedReader(isR);
            ps = new PrintStream(os);
            Runnable rs = new thrd(bfr);
            th = new Thread(rs);
            th.start();
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
                    ps.println("Me -> " + to + ":\n" + stringToSend + "\n");
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
    class thrd implements Runnable{
        BufferedReader bfrThrd;
        public thrd (BufferedReader bfr){
            this.bfrThrd = bfr;
        }
        @Override 
        public void run() {
            String aviable = "", putted = outputMessages.getText();
            while(true){
                try {
                    aviable = bfrThrd.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(!aviable.isBlank()){
                    putted += "\n"+aviable;
                }
                outputMessages.setText(putted);
            }
        }
    }
}
