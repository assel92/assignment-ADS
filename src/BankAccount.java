import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BankAccount{
    private int accountNumber;
    private String username;
    private int balance;
    private Stack<String> transactionHistory;
    public BankAccount(int accountNumber, String username, int balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
        this.transactionHistory = new Stack<>();
    }
    public int getAccountNumber() { return accountNumber; }
    public String getUsername() { return username; }
    public int getBalance() { return balance; }
    public void displayAccount() {
        System.out.println(accountNumber +". "+ username +" - "+ "Balance: " + balance);
    }
    public void displayTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transaction history available.");
        } else {
            System.out.println("TRANSACTION HISTORY:");
            for (int i = transactionHistory.size() - 1; i >= 0; i--) {
                System.out.println(transactionHistory.get(i));
            }
        }
    }
    private void recordTransaction(String type, int amount, String details) {
        String transaction = String.format("%s | %s | Amount: %d | Balance: %d",
                type, details, amount, balance);
        transactionHistory.push(transaction);
        System.out.println("Transaction recorded: " + transaction);
    }
    public void addTransaction(String transaction) {
        transactionHistory.push(transaction);
        System.out.println("Transaction recorded: " + transaction);
    }
    public String getLastTransaction() {
        if (transactionHistory.isEmpty()) {
            return "No transactions yet";
        }
        return transactionHistory.peek();

    }
    public String undoLastTransaction() {
        if (!transactionHistory.isEmpty()) {
            String removed = transactionHistory.pop();
            System.out.println("Undo successful!");
            return removed;
        }
        return null;
    }
    public boolean payBill( int amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            String transaction = "Bill Payment: "+ " -" + amount + "  New balance: " + balance;
            addTransaction(transaction);
            System.out.println("Paid" + amount + " successfully!");
            return true;}
    return false;
    }
    public int deposit(int amount) {
        balance += amount;
        String transaction = String.format("Deposit: +%d to %s", amount, username);
        transactionHistory.push(transaction);
        return balance;
    }
    public void updateBalance(int newBalance) {
        this.balance = newBalance;
    }
    public int withdraw(int amount) {
        balance -= amount;
        String transaction = String.format("Withdraw: -%d from %s", amount, username);
        transactionHistory.push(transaction);
        return balance;
    }
    public static BankAccount findAccount(LinkedList<BankAccount> accounts, String username) {
        for(BankAccount acc : accounts) {
            if(acc.getUsername().equalsIgnoreCase(username)) {
                return acc;
            }
        }
        return null;
    }

    public static void main (String [] args){
        Scanner sc=new Scanner(System.in);
        LinkedList<BankAccount> accounts = new LinkedList<>();
        int choice;
        do {
            System.out.println("BANKING SYSTEM");
            System.out.println("1. Add a new account");
            System.out.println("2. View all accounts");
            System.out.println("3. Search account by name");
            System.out.println("4. Deposit money");
            System.out.println("5. Withdraw money");
            System.out.println("6. Pay bill");
            System.out.println("7. View transaction history");
            System.out.println("8. View last transaction");
            System.out.println("9. Undo last transaction");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("ADD NEW ACCOUNT");
                    System.out.print("Account number: ");
                    int accNum = sc.nextInt();
                    System.out.print("User name: ");
                    String name = sc.next();
                    System.out.print("Account balance: ");
                    int bal = sc.nextInt();
                    BankAccount newAccount = new BankAccount(accNum, name, bal);
                    accounts.add(newAccount);
                    System.out.println("Account added successfully!");
                    break;
                case 2:
                    System.out.println("Accounts List: ");
                    for (BankAccount acc : accounts) {
                        acc.displayAccount();
                    }
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.next();
                    boolean found = false;
                    for(BankAccount acc : accounts) {
                        if(acc.getUsername().equalsIgnoreCase(searchName) ){
                            System.out.println("Account found:");
                            acc.displayAccount();
                            found = true;
                            break;
                        }
                    }
                    if(found==false) {
                        System.out.println("Account not found!");
                    }
                    break;
                case 4:
                    System.out.println("Enter name: ");
                    String name1 = sc.next();
                    BankAccount account = findAccount(accounts, name1);
                    System.out.println("Enter amount you want to deposit: ");
                    int amount = sc.nextInt();
                    int newBalance = account.deposit(amount);
                    account.updateBalance(newBalance);
                    System.out.println("New balance: " + newBalance);
                    break;
                case 5:
                    System.out.println("Enter name: ");
                    String name2 = sc.next();
                    BankAccount account2 = findAccount(accounts, name2);
                    System.out.println("Enter amount you want to withdraw: ");
                    int amount2 = sc.nextInt();
                    account2.withdraw(amount2);
                    int newBalance2 = account2.deposit(amount2);
                    account2.updateBalance(newBalance2);
                    System.out.println("New balance: " + newBalance2);
                    break;
                case 6:
                    System.out.println("Enter name: ");
                    String name3= sc.next();
                    BankAccount account3 = findAccount(accounts, name3);
                    System.out.print("Enter amount to pay: ");
                    int amount3 = sc.nextInt();
                    account3.payBill(amount3);
                    break;
                case 7:
                    System.out.println("Enter name: ");
                    String name4 = sc.next();
                    BankAccount account4 = findAccount(accounts, name4);
                    if(account4 != null) {
                        account4.displayTransactionHistory();}
                    break;
                case 8:
                    System.out.println("Enter name: ");
                    String name5 = sc.next();
                    BankAccount account5 = findAccount(accounts, name5);
                    if(account5 != null) {
                        String lastTransaction = account5.getLastTransaction();
                        System.out.println("Last Transaction:");
                        System.out.println(lastTransaction);
                    }
                    break;
                case 9:
                    System.out.println("Enter name: ");
                    String name6 = sc.next();
                    BankAccount account6 = findAccount(accounts, name6);
                    if(account6 != null) {
                        String transaction = account6.undoLastTransaction();
                        if(transaction != null) {
                            System.out.println("Successfully removed transaction" );
                        }
                    }
                    break;
                case 10:
                    System.out.println("Thank you for using the banking system!");
                    break;
            }
        } while (choice != 10);
        sc.close();
    }
}

