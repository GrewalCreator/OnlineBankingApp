import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BankPanel extends JPanel{

    HashMap<String, String[]> map = new HashMap<>();
    NumberFormat currencyFormat;
    //Primitive Types
    int balance;
    int increaseBalance;
    int decreaseBalance;
    String checkUser;
    String checkPass;
    String newUser;
    String newPass;

    //JPanels
    JPanel cards;
    JPanel panelOption;
    JPanel panelLogin;
    JPanel panelSignup;
    JPanel panelTable;
    JPanel panelUnlocked;
    JPanel subPanelTable;
    JPanel panelDeposit;
    JPanel panelWithdraw;
    JPanel panelBalance;

    //JButtons With Specific Functions
    JButton verifyLogin;
    JButton createAccount;
    JButton finalDepositButton;
    JButton finalWithdrawButton;

    //JButtons That Just Turn Pages
    JButton loginButton;
    JButton signUpButton;
    JButton logout;

    JButton backButtonP1;
    JButton backButtonP2;
    JButton backButtonP3;
    JButton backButtonP4;
    JButton backButtonP5;
    JButton backButtonP6;

    JButton transactionHistoryButton;
    JButton depositButton;
    JButton withdrawButton;
    JButton checkBalanceButton;

    //JLabels
    JLabel usernameSignup;
    JLabel passwordSignup;
    JLabel usernameLogin;
    JLabel passwordLogin;
    JLabel welcomeMessage;
    JLabel depositAmount;
    JLabel withdrawAmount;
    JLabel balanceLabel;
    JLabel bankName;

    //JTables
    JTable transactionHistoryTable;
    DefaultTableModel thisModel;
    DateTimeFormatter dtf;
    LocalDateTime now;

    //JScrollPane
    JScrollPane scrollPane;

    //Arrays
    String[] tableColumns;
    String[][] tableData;
    String[] accountData;
    String[] data;

    //Layouts
    GridBagLayout gridLayout;
    CardLayout cardLayout;

    //Constraints
    GridBagConstraints loginButtonConstraints;
    GridBagConstraints signupButtonConstraints;
    GridBagConstraints bankNameConstraints;

    GridBagConstraints loginConstraints;
    GridBagConstraints signUpConstraints;
    GridBagConstraints loginTextConstraints;
    GridBagConstraints PasswordConstraints;
    GridBagConstraints createAccountConstraints;
    GridBagConstraints backButtonConstraints;

    GridBagConstraints usernameLoginConstraints;
    GridBagConstraints userTextLoginConstraints;
    GridBagConstraints passwordLoginConstraints;
    GridBagConstraints passTextLoginConstraints;
    GridBagConstraints checkLoginConstraints;

    GridBagConstraints welcomeMessageConstraints;
    GridBagConstraints transactionHistoryConstraints;
    GridBagConstraints depositConstraints;
    GridBagConstraints withdrawConstraints;
    GridBagConstraints checkBalanceConstraints;
    GridBagConstraints logoutConstraints;

    GridBagConstraints depositLabelConstraints;
    GridBagConstraints depositAmountConstraints;
    GridBagConstraints finalDepositButtonConstraints;
    GridBagConstraints back4Constraints;

    GridBagConstraints withdrawLabelConstraints;
    GridBagConstraints withdrawAmountConstraints;
    GridBagConstraints finalWithdrawButtonConstraints;
    GridBagConstraints back5Constraints;

    //JText
    JTextField createUserLogin;
    JTextField userTextLogin;
    JTextField enterDepositAmount;
    JTextField enterWithdrawAmount;

    //JPass
    JPasswordField createUserPass;
    JPasswordField passTextLogin;

    //Pages Text
    final static String OPTION_PANEL = "Card with Options";
    final static String LOGIN_PANEL = "Card with Login";
    final static String SIGN_UP_PANEL = "Card with Sign Up";
    final static String TABLE_PANEL = "Card with Table";
    final static String UNLOCKED_PANEL = "Card with Unlocked Options";
    final static String DEPOSIT_PANEL = "Card with Deposit";
    final static String WITHDRAW_PANEL = "Card with Withdraw";
    final static String BALANCE_PANEL = "Card with Balance";

    BankPanel() {
        Color blue = new Color(0x123456);
        this.setBackground(blue);
        //Initialize Cards
        cards = new JPanel();
        cards.setLayout(cardLayout = new CardLayout());
        gridLayout = new GridBagLayout();
        //Page 1
        panelOption = new JPanel(gridLayout);
        panelOption.setBackground(blue);
        //Page 2
        panelSignup = new JPanel(gridLayout);
        panelSignup.setBackground(blue);
        //Page 3
        panelLogin = new JPanel(gridLayout);
        panelLogin.setBackground(blue);
        //Page 4
        panelUnlocked = new JPanel(gridLayout);
        panelUnlocked.setBackground(blue);
        //Page 5
        subPanelTable = new JPanel();
        subPanelTable.setBackground(blue);
        panelTable = new JPanel();
        panelTable.setBackground(blue);
        panelTable.add(subPanelTable, BorderLayout.SOUTH);

        //Page 6
        panelDeposit = new JPanel(gridLayout);
        panelDeposit.setBackground(blue);
        //Page 7
        panelWithdraw = new JPanel(gridLayout);
        panelWithdraw.setBackground(blue);
        //Page 8
        panelBalance = new JPanel();
        panelBalance.setBackground(blue);

        //Time
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        now = LocalDateTime.now();

        constraints();
        addComponents();
        addActionListener();
    }
    void constraints() {
        //Initialize Constraints
        loginButtonConstraints = new GridBagConstraints();
        loginConstraints = new GridBagConstraints();
        loginConstraints.gridx = 0;
        loginConstraints.gridy = 0;

        signUpConstraints = new GridBagConstraints();
        signUpConstraints.gridx = 0;
        signUpConstraints.gridy = 1;

        loginTextConstraints = new GridBagConstraints();
        loginTextConstraints.gridx = 2;
        loginTextConstraints.gridy = 0;

        PasswordConstraints = new GridBagConstraints();
        PasswordConstraints.gridx = 2;
        PasswordConstraints.gridy = 1;

        createAccountConstraints = new GridBagConstraints();
        createAccountConstraints.gridx = 1;
        createAccountConstraints.gridy = 2;

        backButtonConstraints = new GridBagConstraints();
        backButtonConstraints.gridx = 0;
        backButtonConstraints.gridy = 2;

        usernameLoginConstraints = new GridBagConstraints();
        usernameLoginConstraints.gridx = 0;
        usernameLoginConstraints.gridy = 0;

        userTextLoginConstraints = new GridBagConstraints();
        userTextLoginConstraints.gridx = 2;
        userTextLoginConstraints.gridy = 0;

        passwordLoginConstraints = new GridBagConstraints();
        passwordLoginConstraints.gridx = 0;
        passwordLoginConstraints.gridy = 1;

        passTextLoginConstraints = new GridBagConstraints();
        passTextLoginConstraints.gridx = 2;
        passTextLoginConstraints.gridy = 1;

        checkLoginConstraints = new GridBagConstraints();
        checkLoginConstraints.gridx = 1;
        checkLoginConstraints.gridy = 2;

        welcomeMessageConstraints = new GridBagConstraints();
        welcomeMessageConstraints.gridx = 4;
        welcomeMessageConstraints.gridy = 0;

        transactionHistoryConstraints = new GridBagConstraints();
        transactionHistoryConstraints.gridx = 1;
        transactionHistoryConstraints.gridy = 8;

        depositConstraints = new GridBagConstraints();
        depositConstraints.gridx = 3;
        depositConstraints.gridy = 8;

        withdrawConstraints = new GridBagConstraints();
        withdrawConstraints.gridx = 5;
        withdrawConstraints.gridy = 8;

        checkBalanceConstraints = new GridBagConstraints();
        checkBalanceConstraints.gridx = 7;
        checkBalanceConstraints.gridy = 8;

        depositLabelConstraints = new GridBagConstraints();
        depositLabelConstraints.gridx = 0;
        depositLabelConstraints.gridy = 0;

        depositAmountConstraints = new GridBagConstraints();
        depositAmountConstraints.gridx = 0;
        depositAmountConstraints.gridy = 1;

        finalDepositButtonConstraints = new GridBagConstraints();
        finalDepositButtonConstraints.gridx = 1;
        finalDepositButtonConstraints.gridy = 1;

        back4Constraints = new GridBagConstraints();
        back4Constraints.gridx = 0;
        back4Constraints.gridy = 2;

        withdrawLabelConstraints  = new GridBagConstraints();
        withdrawLabelConstraints.gridx = 0;
        withdrawLabelConstraints.gridy = 0;

        withdrawAmountConstraints = new GridBagConstraints();
        withdrawAmountConstraints.gridx = 0;
        withdrawAmountConstraints.gridy = 1;

        finalWithdrawButtonConstraints = new GridBagConstraints();
        finalWithdrawButtonConstraints.gridx = 1;
        finalWithdrawButtonConstraints.gridy = 1;

        back5Constraints = new GridBagConstraints();
        back5Constraints.gridx = 0;
        back5Constraints.gridy = 2;

        logoutConstraints = new GridBagConstraints();
        logoutConstraints.gridx = 7;
        logoutConstraints.gridy = 9;

        bankNameConstraints = new GridBagConstraints();
        bankNameConstraints.gridx = 1;
        bankNameConstraints.gridy = 0;

        loginButtonConstraints = new GridBagConstraints();
        loginButtonConstraints.gridx = 0;
        loginButtonConstraints.gridy = 1;

        signupButtonConstraints = new GridBagConstraints();
        signupButtonConstraints.gridx = 2;
        signupButtonConstraints.gridy = 1;


    }

    void addComponents(){
        //Add Page1 Components
        bankName = new JLabel("G-Bank");
        bankName.setFont(new Font("SansSerif Bold", Font.PLAIN, 25));
        panelOption.add(bankName, bankNameConstraints);
        loginButton = new JButton("Login");
        panelOption.add(loginButton, loginButtonConstraints);

        signUpButton = new JButton("Sign Up");
        panelOption.add(signUpButton, signupButtonConstraints);

        //Add page 2 components
        usernameSignup = new JLabel("Enter Your Full Name:");
        usernameSignup.setForeground(Color.white);
        panelSignup.add(usernameSignup, loginConstraints);
        createUserLogin = new JTextField(15);
        panelSignup.add(createUserLogin, loginTextConstraints);

        passwordSignup = new JLabel("Enter New Password:");
        passwordSignup.setForeground(Color.white);
        panelSignup.add(passwordSignup, signUpConstraints);
        createUserPass = new JPasswordField(15);
        panelSignup.add(createUserPass, PasswordConstraints);

        createAccount = new JButton("Create Account");
        panelSignup.add(createAccount, createAccountConstraints);

        backButtonP1 = new JButton("Back");
        panelSignup.add(backButtonP1, backButtonConstraints);

        //Add page 3 components
        usernameLogin = new JLabel("Username:");
        usernameLogin.setForeground(Color.white);
        panelLogin.add(usernameLogin, usernameLoginConstraints);
        userTextLogin = new JTextField(15);
        panelLogin.add(userTextLogin, userTextLoginConstraints);

        passwordLogin = new JLabel("Password:");
        passwordLogin.setForeground(Color.white);
        panelLogin.add(passwordLogin, passwordLoginConstraints);
        passTextLogin = new JPasswordField(15);
        panelLogin.add(passTextLogin, passTextLoginConstraints);

        verifyLogin = new JButton("Login");
        panelLogin.add(verifyLogin, checkLoginConstraints);

        backButtonP2 = new JButton("Back");
        panelLogin.add(backButtonP2, backButtonConstraints);

        //Page 4 components
        welcomeMessage = new JLabel("Welcome!");
        welcomeMessage.setForeground(Color.white);
        welcomeMessage.setFont(new Font("SansSerif Bold", Font.PLAIN, 18));
        panelUnlocked.add(welcomeMessage, welcomeMessageConstraints);

        transactionHistoryButton = new JButton("Transaction History");
        panelUnlocked.add(transactionHistoryButton, transactionHistoryConstraints);
        depositButton = new JButton("Deposit");
        panelUnlocked.add(depositButton, depositConstraints);
        withdrawButton = new JButton("Withdraw");
        panelUnlocked.add(withdrawButton, withdrawConstraints);
        checkBalanceButton = new JButton("Check Balance");
        panelUnlocked.add(checkBalanceButton, checkBalanceConstraints);
        logout = new JButton("Logout");
        panelUnlocked.add(logout, logoutConstraints);


        //Page 5 components
        tableColumns = new String[]{"Name", "Type", "Amount", "Date-Time"};
        tableData = new String[0][];
        transactionHistoryTable = new JTable(new DefaultTableModel(tableData, tableColumns));

        transactionHistoryTable.setBackground(Color.WHITE);
        transactionHistoryTable.setForeground(Color.BLACK);
        transactionHistoryTable.setSelectionBackground(Color.red);
        transactionHistoryTable.setGridColor(Color.red);
        transactionHistoryTable.setSelectionForeground(Color.white);
        transactionHistoryTable.setFont(new Font("Tahoma", Font.PLAIN, 17));
        transactionHistoryTable.setRowHeight(30);
        transactionHistoryTable.setAutoCreateRowSorter(true);

        scrollPane = new JScrollPane(transactionHistoryTable);
        transactionHistoryTable.setFillsViewportHeight(true);
        scrollPane.setBackground(Color.white);
        scrollPane.setForeground(Color.red);

        backButtonP3 = new JButton("Back");
        subPanelTable.add(backButtonP3, BorderLayout.LINE_START);

        panelTable.add(scrollPane);

        //Page 6
        depositAmount = new JLabel("How Much Would You Like To Deposit Today?: ");
        depositAmount.setForeground(Color.white);
        depositAmount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        enterDepositAmount = new JTextField(15);
        panelDeposit.add(depositAmount, depositLabelConstraints);
        panelDeposit.add(enterDepositAmount, depositAmountConstraints);
        finalDepositButton = new JButton("Deposit Money");
        panelDeposit.add(finalDepositButton, finalDepositButtonConstraints);
        backButtonP4 = new JButton("Back");
        panelDeposit.add(backButtonP4, back4Constraints);

        //Page 7
        withdrawAmount = new JLabel("How Much Would You Like To Withdraw Today?: ");
        withdrawAmount.setForeground(Color.white);
        withdrawAmount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        enterWithdrawAmount = new JTextField(15);
        panelWithdraw.add(withdrawAmount, withdrawLabelConstraints);
        panelWithdraw.add(enterWithdrawAmount, withdrawAmountConstraints);
        finalWithdrawButton = new JButton("Withdraw Money");
        panelWithdraw.add(finalWithdrawButton, finalWithdrawButtonConstraints);
        backButtonP5 = new JButton("Back");
        panelWithdraw.add(backButtonP5, back5Constraints);

        //Page 8
        balanceLabel = new JLabel("Your Current Balance Is: " + balance);
        balanceLabel.setForeground(Color.white);
        panelBalance.add(balanceLabel);
        backButtonP6 = new JButton("Back");
        panelBalance.add(backButtonP6);

        //add pages to cards
        cards.add(panelOption, OPTION_PANEL);
        cards.add(panelLogin, LOGIN_PANEL);
        cards.add(panelSignup,SIGN_UP_PANEL);
        cards.add(panelTable, TABLE_PANEL);
        cards.add(panelUnlocked, UNLOCKED_PANEL);
        cards.add(panelDeposit, DEPOSIT_PANEL);
        cards.add(panelWithdraw, WITHDRAW_PANEL);
        cards.add(panelBalance, BALANCE_PANEL);
        cardLayout.show(cards, OPTION_PANEL);
        this.add(cards);

    }
    void addActionListener(){
        //Switch to page 2
        signUpButton.addActionListener(e -> cardLayout.show(cards, SIGN_UP_PANEL));

        //Switch to Page 3
        loginButton.addActionListener(e -> cardLayout.show(cards, LOGIN_PANEL));

        //Return to Option Screen
        backButtonP1.addActionListener(e -> cardLayout.show(cards, OPTION_PANEL));
        backButtonP2.addActionListener(e -> cardLayout.show(cards, OPTION_PANEL));
        logout.addActionListener(e -> cardLayout.show(cards, OPTION_PANEL));

        //Open Bank Screen Page 4
        verifyLogin.addActionListener(e -> checkAccounts());
        createAccount.addActionListener(e -> addAccount());
        backButtonP3.addActionListener(e -> cardLayout.show(cards, UNLOCKED_PANEL));
        backButtonP4.addActionListener(e -> cardLayout.show(cards, UNLOCKED_PANEL));
        backButtonP5.addActionListener(e -> cardLayout.show(cards, UNLOCKED_PANEL));
        backButtonP6.addActionListener(e -> cardLayout.show(cards, UNLOCKED_PANEL));

        //Open Transaction History Page 5
        transactionHistoryButton.addActionListener(e -> cardLayout.show(cards,TABLE_PANEL));

        //Open Deposit Page
        depositButton.addActionListener(e -> cardLayout.show(cards, DEPOSIT_PANEL));
        //Open Withdraw Page
        withdrawButton.addActionListener(e -> cardLayout.show(cards, WITHDRAW_PANEL));
        //Open Check Balance Page
        checkBalanceButton.addActionListener(e -> cardLayout.show(cards,BALANCE_PANEL));
        //add money to balance
        finalDepositButton.addActionListener(e -> depositBalance());
        //remove money from balance
        finalWithdrawButton.addActionListener(e -> withdrawBalance());
    }

    void addAccount(){
        newUser = createUserLogin.getText();
        newPass = String.valueOf(createUserPass.getPassword());

        accountData = new String[]{newPass, String.valueOf(balance)};
        map.put(newUser, accountData);

        if(newUser.isEmpty() || newPass.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Both A Username And Password");

        }else {
            cardLayout.show(cards, UNLOCKED_PANEL);
        }
        createUserLogin.setText("");
        createUserPass.setText("");
    }

    void checkAccounts(){
        Set<Map.Entry<String,String[]>> entrySet = map.entrySet();

        checkUser = userTextLogin.getText();
        checkPass = String.valueOf(passTextLogin.getPassword());
        if(map.isEmpty()){
            JOptionPane.showMessageDialog(this, "Account Does Not Exist");
        }
        for(Map.Entry<String, String[]> ignore : entrySet){
            if(map.containsKey(checkUser)){
                for (String accountDatum : accountData) {
                    if (accountDatum.equals(checkPass)) {
                        cardLayout.show(cards, UNLOCKED_PANEL);
                    }
                }
            }else {
                JOptionPane.showMessageDialog(this, "Account Does Not Exist Here");
            }
        }
        userTextLogin.setText("");
        passTextLogin.setText("");
    }

    void depositBalance(){
        currencyFormat = NumberFormat.getCurrencyInstance();
        try {
            increaseBalance = Integer.parseInt(enterDepositAmount.getText().trim().strip());
            if(increaseBalance > 0) {
                balance += increaseBalance;
                balanceLabel.setText("Your Current Balance Is: " + currencyFormat.format(balance));
                data = new String[]{newUser, "Deposit", String.valueOf(increaseBalance), dtf.format(now)};
                thisModel = (DefaultTableModel) transactionHistoryTable.getModel();
                thisModel.addRow(data);
                JOptionPane.showMessageDialog(this, "Deposit Successful of " + currencyFormat.format(increaseBalance));
            }else{
                JOptionPane.showMessageDialog(this, "Please Enter An Amount Greater Than 0");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Please Enter A Valid Number");
        }
        enterDepositAmount.setText("");
    }

    void withdrawBalance() {
        currencyFormat = NumberFormat.getCurrencyInstance();
        try {
            decreaseBalance = Integer.parseInt(enterWithdrawAmount.getText().trim().strip());
            if (decreaseBalance > 0) {
                if (balance < decreaseBalance) {
                    JOptionPane.showMessageDialog(this, "You Don't Have Enough Money");
                } else {
                    balance -= decreaseBalance;
                    balanceLabel.setText("Your Current Balance Is: " + currencyFormat.format(balance));
                    data = new String[]{newUser, "Withdraw", String.valueOf(decreaseBalance), dtf.format(now)};
                    thisModel = (DefaultTableModel) transactionHistoryTable.getModel();
                    thisModel.addRow(data);
                    JOptionPane.showMessageDialog(this, "Withdraw Successful of $" + currencyFormat.format(decreaseBalance));
                }
            }else{
                JOptionPane.showMessageDialog(this, "Please Enter An Amount Greater Than 0");
            }

        }catch(NumberFormatException n){
            JOptionPane.showMessageDialog(this, "Please Enter A Valid Number");
        }enterWithdrawAmount.setText("");

    }

}