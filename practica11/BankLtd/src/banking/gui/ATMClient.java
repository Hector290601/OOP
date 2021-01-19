package banking.gui;

import banking.domain.*;
import banking.data.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ATMClient {

  private static final String USAGE
    = "USAGE: java banking.gui.ATMClient <dataFilePath>";

  public static void main(String[] args) {

    // Retrieve the dataFilePath command-line argument
    if ( args.length != 1 ) {
      System.out.println(USAGE);
    } else {
      String dataFilePath = args[0];

      try {
	System.out.println("Reading data file: " + dataFilePath);
	// Create the data source and load the Bank data
	DataSource dataSource = new DataSource(dataFilePath);
	dataSource.loadData();

	// Run the ATM GUI
	ATMClient client = new ATMClient();
	client.launchFrame();

      } catch (IOException ioe) {
	System.out.println("Could not load the data file.");
	System.out.println(ioe.getMessage());
	ioe.printStackTrace(System.err);
      }
    }
  }

  // Colocar a continuación el código de la GUI.
  private JFrame frame;
  private JPanel southPanel;
  private JPanel northPanel;
  private JTextField inputField;
  private JTextArea messages;
  private JButton enterButton;
  public ATMClient(){
      frame = new JFrame("Bank");
      buildGUI();
  }
  public void buildGUI(){
      southPanel = new JPanel();
      southPanel.setLayout(new GridLayout(2, 1));
      JPanel southLeft = new JPanel();
      southLeft.setLayout(new GridLayout(1, 3));
      JButton[] menu = new JButton[]{
          new JButton("Deposit"), 
          new JButton("Balance"), 
          new JButton("Withdraw")
      };
      for(int i = 0; i < 3; i+=1){
          southLeft.add(menu[i]);
      }
      menu[0].addActionListener(new ActionListener() {
         @Override
          public void actionPerformed(ActionEvent event){
              enterButton.setActionCommand("deposito");
              messages.append("\nTeclee la cantidad a depositar usando el teclado, posteriormente presione ENTER");
          }
      });
      menu[1].addActionListener(new ActionListener() {
         @Override
          public void actionPerformed(ActionEvent event){
              enterButton.setActionCommand("saldo");
              messages.append("\nSu salod actual es de $2000\n");
          }
      });
      menu[2].addActionListener(new ActionListener() {
         @Override
          public void actionPerformed(ActionEvent event){
              enterButton.setActionCommand("retiro");
              messages.append("\nTeclee la cantidad a depositar usando el teclado, posteriormente presione ENTER");
          }
      });
      southPanel.add(southLeft);
      JPanel numericalKeyboard = new JPanel();
      numericalKeyboard.setLayout(new BorderLayout());
      JPanel inputs = new JPanel();
      inputs.setLayout(new GridLayout(1, 2));
      inputField = new JTextField(10);
      numericalKeyboard.add(inputField, BorderLayout.NORTH);
      JPanel numericalKeyPadGrid = new JPanel();
      numericalKeyPadGrid.setLayout(new GridLayout(4, 3));
      JButton[] numericalKeyBoard = new JButton[]{
          new JButton("1"),
          new JButton("2"),
          new JButton("3"),
          new JButton("4"),
          new JButton("5"),
          new JButton("6"),
          new JButton("7"),
          new JButton("8"),
          new JButton("9"),
          new JButton("0"),
          new JButton("."),
          new JButton("000")
      };
      for(JButton b : numericalKeyBoard){
          b.addActionListener(new KeyPadHandler());
          numericalKeyPadGrid.add(b);
      }
      enterButton = new JButton("ENTER");
      enterButton.addActionListener(new EnterButtonHandler());
      enterButton.setActionCommand("cliente");
      inputs.add(inputField);
      inputs.add(numericalKeyPadGrid);
      inputs.add(enterButton);
      southPanel.add(inputs);
      frame.add(southPanel, BorderLayout.SOUTH);
      northPanel = new JPanel();
      northPanel.setLayout(new BorderLayout());
      messages = new JTextArea(10, 25);
      messages.setEnabled(false);
      northPanel.add(messages, BorderLayout.CENTER);
      frame.add(northPanel, BorderLayout.NORTH);
  }
  public void launchFrame(){
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocation(500, 400);
      frame.pack();
      frame.setResizable(false);
      frame.setVisible(true);
    }
  public class EnterButtonHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent event){
          String function = enterButton.getActionCommand();
          switch (function){
              case "cliente":{
                  messages.setText("Bienvenido cliente " + inputField.getText() +
                          "\n Escoja la función que desee utilizando los botones de acción\n");
                  inputField.setText("");
                  break;
              }
              case "deposito":{
                  messages.setText("Su deposito por " + inputField.getText() +
                          "\n Ha sido aceptado.\n Escoja la función que desee utilizando los botones de acción\n");
                  inputField.setText("");
                  break;
              }
              case "retiro":{
                  messages.setText("Su retiro de  " + inputField.getText() +
                          "ha sido aceptado.\n Escoja la función que desee utilizando los botones de acción\n");
                  inputField.setText("");
                  break;
              }
          }
      }
  }
  private class KeyPadHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent event){
          JButton b = (JButton) event.getSource();
          inputField.setText(inputField.getText() + b.getText());
      }
  }
}
