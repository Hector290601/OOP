package banking.gui;
import banking.data.*;
import banking.domain.*;
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
      if (args.length != 1) {
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
   // variables de instancia
   private JFrame frame;
   private JPanel pLeftHalf;
   private JPanel pRightHalf;
   private JTextField entryField;
   private JTextField messageField;
   private JTextArea outputArea;
   private JButton enterButton;
   private String numCliente;
   private Bank bank;

   // Constructor
   public ATMClient() {
      frame = new JFrame("Bank Ltd");
      bank = Bank.getBank();
      construyeGUI();
   }
   private void depositar() {
      Customer cliente = bank.getCustomer(Integer.parseInt(numCliente));
      Account cuenta = cliente.getAccount(0);
      cuenta.deposit(Double.parseDouble(entryField.getText()));
      outputArea.setText("Su depósito por:  " + entryField.getText()
            + "  fue aceptado."
            + "\n Escoja la función que desea realizar  "
            + "\n usando el botón correspondiente");      
   }
   private void retirar()  throws OverdraftException{
      Customer cliente = bank.getCustomer(Integer.parseInt(numCliente));
      Account cuenta = cliente.getAccount(0);
      cuenta.withdraw(Double.parseDouble(entryField.getText()));
      outputArea.setText("Su retiro de:  " + entryField.getText()
            + "  fue aceptado."
            + "\n Escoja la función que desea realizar  "
            + "\n usando el botón correspondiente");      
   }
   private void consultar() {
      Customer cliente = bank.getCustomer(Integer.parseInt(numCliente));
      Account cuenta = cliente.getAccount(0);
      outputArea.setText("Su saldo actual es:  "  +  cuenta.getBalance()
            + "\n Escoja la función que desea realizar  "
            + "\n usando el botón correspondiente");      
   }
   private void construyeGUI() {
      // Mitad izquierda
      pLeftHalf = new JPanel();
      pLeftHalf.setLayout(new GridLayout(2, 1));
      // Izquierda arriba
      JPanel topLeftPanel = new JPanel();
      topLeftPanel.setLayout(new GridLayout(3, 1));
      JButton[] menuButtons = new JButton[] {
         new JButton("Saldo"),
         new JButton("Depósito"),
         new JButton("Retiro")};
      for (int i = 0; i < 3; i++) {
         topLeftPanel.add(menuButtons[i]);
      }
      // menuButtons[0] es consultar saldo
      menuButtons[0].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            consultar();
         }
      });
      // menuButtons[1] es Depósito
      menuButtons[1].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            enterButton.setActionCommand("deposito");
            outputArea.append("\nTeclee la cantidad a depositar"
                  + "\n en el teclado numérico y oprima el botón ENTER");
         }
      });
      // menuButtons[2] es Retiro
      menuButtons[2].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            enterButton.setActionCommand("retiro");
            outputArea.append("\nTeclee la cantidad a retirar"
                  + "\n en el teclado numérico y oprima el botón ENTER");
         }
      });
      pLeftHalf.add(topLeftPanel);
      // Izquierda abajo
      JPanel entryKeyPadPanel = new JPanel();
      entryKeyPadPanel.setLayout(new BorderLayout());
      entryField = new JTextField(10);
      entryKeyPadPanel.add(entryField, BorderLayout.NORTH);
      JPanel keyPadGrid = new JPanel();
      keyPadGrid.setLayout(new GridLayout(4, 3));
      JButton[] keyPadButtons = new JButton[]{
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
         new JButton(".")};
      for (JButton b : keyPadButtons) {
         b.addActionListener(new KeyPadHandler());
         keyPadGrid.add(b);
      }
      enterButton = new JButton("ENTER");
      enterButton.addActionListener(new EnterButtonHandler());
      enterButton.setActionCommand("cliente");
      keyPadGrid.add(enterButton);
      entryKeyPadPanel.add(keyPadGrid, BorderLayout.SOUTH);
      pLeftHalf.add(entryKeyPadPanel);
      frame.add(pLeftHalf, BorderLayout.WEST);
      // Mitad derecha
      pRightHalf = new JPanel();
      pRightHalf.setLayout(new BorderLayout());
      outputArea = new JTextArea(10, 25);
      outputArea.setText("   Introduzca su número de cliente en "
            + " \n  el teclado numérico y oprima el botón ENTER");
      enterButton.setActionCommand("cliente");
      pRightHalf.add(outputArea, BorderLayout.CENTER);
      messageField = new JTextField(25);
      pRightHalf.add(messageField, BorderLayout.SOUTH);
      pRightHalf.setEnabled(false);
      frame.add(pRightHalf, BorderLayout.EAST);
   }
   public void launchFrame() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);      
      frame.pack();
      frame.setResizable(false);
      frame.setVisible(true);
   }
   private class EnterButtonHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent event) {
         String funcion = enterButton.getActionCommand();
         switch (funcion) {
            case "cliente": {
               outputArea.setText("Bienvenido cliente " + entryField.getText()
                     + "\n Escoja la función que desea realizar  "
                     + "\n usando el botón correspondiente");
               numCliente = entryField.getText();
               entryField.setText("");
               break;
            }
            case "deposito": {
               depositar();
               entryField.setText("");
               break;
            }
            case "retiro": {
            try {
               retirar();
            } catch (OverdraftException ex) {
               outputArea.setText("Su retiro de:  " + entryField.getText()
                     + "  NO fue aceptado por falta de fondos."
                     + "\n Escoja la función que desea realizar  "
                     + "\n usando el botón correspondiente");
               entryField.setText("");
            }
               outputArea.setText("Su retiro de:  " + entryField.getText()
                     + "  fue aceptado."
                     + "\n Escoja la función que desea realizar  "
                     + "\n usando el botón correspondiente");
               entryField.setText("");
               break;
            }
         }
      }
   }
   private class KeyPadHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent event) {
         JButton b = (JButton) event.getSource();
         entryField.setText(entryField.getText() + b.getText());
      }
   }
}