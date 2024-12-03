import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Main {

    public static void main(String[] args) {
        System.out.println("System is starting");
        LetsGetItStarting();
    }

    public static void LetsGetItStarting() {
        //Scanner scnn = new Scanner(System.in);

        ArrayList<String> code = new ArrayList<>(List.of(""));
        ArrayList<Integer> documentNo = new ArrayList<>(List.of(0));
        ArrayList<Integer> lineNo = new ArrayList<>(List.of(0));
        ArrayList<String> expensesCode = new ArrayList<>(List.of(""));
        ArrayList<String> type = new ArrayList<>(List.of(""));
        ArrayList<String> paymentType = new ArrayList<>(List.of(""));
        ArrayList<Integer> bankAccount = new ArrayList<>(List.of(0));
        ArrayList<String> postingDate = new ArrayList<>(List.of(""));
        ArrayList<Double> amount = new ArrayList<>(List.of(0.0));
        ArrayList<String> description = new ArrayList<>(List.of(""));
        ArrayList<Double> balance = new ArrayList<>(List.of(0.0));

        /*while(true){
            System.out.println("""
                    Choose an action:
                    1 - Display Expenses
                    2 - Display Ledger
                    3 - Add New Expense Data
                    4 - Add Ledger Entry
                    0 - Quit
                    """);

            int choice = scnn.nextInt();
            switch (choice) {
                case 1 -> showExpenses(code, description, balance);
                case 2 -> showLedger(documentNo, lineNo, expensesCode, type, paymentType, bankAccount, postingDate, amount);
                case 3 -> addExpenseData(code, description, balance);
                case 4 -> addLedgerEntry(documentNo, lineNo, expensesCode, type, paymentType, bankAccount, postingDate, amount);
                case 0 -> {
                    System.out.println("System is closing...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again!");
            }}*/

        buttonNest(code,documentNo,lineNo,expensesCode,type,paymentType,bankAccount,postingDate,amount,description,balance);


    }

    public static void buttonNest(ArrayList<String> code,ArrayList<Integer> documentNo,ArrayList<Integer> lineNo,
                                  ArrayList<String> expensesCode,ArrayList<String> type,ArrayList<String> paymentType,
                                  ArrayList<Integer> bankAccount,ArrayList<String> postingDate,ArrayList<Double> amount,
                                  ArrayList<String> description,ArrayList<Double> balance){
        JFrame frame = new JFrame("ERP System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnExpenses = new JButton("Display Expenses");
        JButton btnLedger = new JButton("Display Ledger");
        JButton btnAddExpense = new JButton("Add New Expense Data");
        JButton btnAddLedger = new JButton("Add Ledger Entry");
        JButton btnQuit = new JButton("Quit");

        btnExpenses.addActionListener(e -> showExpenses(code, description, balance));
        btnLedger.addActionListener(e -> showLedger(documentNo, lineNo, expensesCode, type, paymentType, bankAccount, postingDate, amount));
        btnAddExpense.addActionListener(e -> addExpenseData(code, description, balance));
        btnAddLedger.addActionListener(e -> addLedgerEntry(documentNo, lineNo, expensesCode, type, paymentType, bankAccount, postingDate, amount));
        btnQuit.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "System is closing...");
            frame.dispose();
        });

        frame.add(btnExpenses);
        frame.add(btnLedger);
        frame.add(btnAddExpense);
        frame.add(btnAddLedger);
        frame.add(btnQuit);

        frame.setVisible(true);

    }

    public static void showExpenses(ArrayList<String> code, ArrayList<String> description, ArrayList<Double> balance) {
        String[] columns = {"Code", "Description", "Balance"};
        Object[][] data = new Object[code.size()][3];

        for (int i = 0; i < code.size(); i++) {
            data[i][0] = code.get(i);
            data[i][1] = description.get(i);
            data[i][2] = balance.get(i);
        }

        JTable table = new JTable(data, columns);
        displayTableInFrame("Expenses List", table);
    }

    public static void showLedger(ArrayList<Integer> documentNo, ArrayList<Integer> lineNo, ArrayList<String> expensesCode,
                                  ArrayList<String> type, ArrayList<String> paymentType, ArrayList<Integer> bankAccount,
                                  ArrayList<String> postingDate, ArrayList<Double> amount) {
        String[] columns = {"Document No", "Line No", "Expenses Code", "Type", "Payment Type", "Bank Account", "Posting Date", "Amount"};
        Object[][] data = new Object[documentNo.size()][8];

        for (int i = 0; i < documentNo.size(); i++) {
            data[i][0] = documentNo.get(i);
            data[i][1] = lineNo.get(i);
            data[i][2] = expensesCode.get(i);
            data[i][3] = type.get(i);
            data[i][4] = paymentType.get(i);
            data[i][5] = bankAccount.get(i);
            data[i][6] = postingDate.get(i);
            data[i][7] = amount.get(i);
        }

        JTable table = new JTable(data, columns);
        displayTableInFrame("Ledger", table);
    }

    public static void addExpenseData(ArrayList<String> code, ArrayList<String> description, ArrayList<Double> balance) {
        String[] columns = {"Code", "Description", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        model.addRow(new Object[]{"", "", ""});
        JButton saveButton = new JButton("Save");

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

        saveButton.addActionListener(e -> {
            int row = 0; // Always working with the first row
            try {
                String newCode = table.getValueAt(row, 0).toString();
                String newDescription = table.getValueAt(row, 1).toString();
                double newBalance = Double.parseDouble(table.getValueAt(row, 2).toString());

                code.add(newCode);
                description.add(newDescription);
                balance.add(newBalance);

                frame.dispose();
                JOptionPane.showMessageDialog(null, "Expense added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid data. Please try again.");
            }
        });
    }

    public static void addLedgerEntry(ArrayList<Integer> documentNo, ArrayList<Integer> lineNo, ArrayList<String> expensesCode,
                                      ArrayList<String> type, ArrayList<String> paymentType, ArrayList<Integer> bankAccount,
                                      ArrayList<String> postingDate, ArrayList<Double> amount) {
        String[] columns = {"Document No", "Line No", "Expenses Code", "Type", "Payment Type", "Bank Account", "Posting Date", "Amount"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        model.addRow(new Object[]{"", "", "", "", "", "", "", ""});
        JButton saveButton = new JButton("Save");

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

        saveButton.addActionListener(e -> {
            int row = 0;
            try {
                int newDocNo = Integer.parseInt(table.getValueAt(row, 0).toString());
                int newLineNo = Integer.parseInt(table.getValueAt(row, 1).toString());
                String newExpensesCode = table.getValueAt(row, 2).toString();
                String newType = table.getValueAt(row, 3).toString();
                String newPaymentType = table.getValueAt(row, 4).toString();
                int newBankAccount = Integer.parseInt(table.getValueAt(row, 5).toString());
                String newPostingDate = table.getValueAt(row, 6).toString();
                double newAmount = Double.parseDouble(table.getValueAt(row, 7).toString());

                documentNo.add(newDocNo);
                lineNo.add(newLineNo);
                expensesCode.add(newExpensesCode);
                type.add(newType);
                paymentType.add(newPaymentType);
                bankAccount.add(newBankAccount);
                postingDate.add(newPostingDate);
                amount.add(newAmount);

                frame.dispose();
                JOptionPane.showMessageDialog(null, "Ledger entry added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid data. Please try again.");
            }
        });
    }
    private static void displayTableInFrame(String title, JTable table) {
        JFrame frame = new JFrame(title);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }
}

//TODO add a kill switch like method cause this doesnt end itself on demand
//TODO add AutoFlush so the tables updatest themself without reloading
//TODO add documentation
//TODO add records
//TODO add login system