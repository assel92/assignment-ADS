import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
public class BankAccount{
    private int accountNumber;
    private String username;
    private int balance;
    private Stack<String> transactionHistory;
    private Queue<String> queueBill;
    private static Queue<String> RequestUsernames = new LinkedList<>();
    private static Queue<Integer> RequestDeposits = new LinkedList<>();
    private static Queue<Integer> RequestNumbers = new LinkedList<>();

    public BankAccount(int accountNumber, String username, int balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
        this.transactionHistory = new Stack<>();
        this.queueBill = new LinkedList<>();
    }
    public String getUsername() { return username; }
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
    public void addBillToQueue(String billType) {
        queueBill.add(billType);
        System.out.println("Added: " + billType + " Bill");
        addTransaction("Added to queue: " + billType + " bill");
    }
    public void processNextBill() {
        if (!queueBill.isEmpty()) {
            String bill = queueBill.poll();
            System.out.println("Processing: " + bill + " Bill");
        }
    }
    public void displayBillQueue() {
        if (queueBill.isEmpty()) {
            System.out.println("Bill queue is empty");
        } else {
            System.out.println("Remaining: " + queueBill);
        }
    }
    public static void submitRequest(String username, int accNumber, int balance) {
        RequestUsernames.add(username);
        RequestDeposits.add(balance);
        RequestNumbers.add(accNumber);
        System.out.println("Account request submitted!");
    }

    public static void processNextRequest(LinkedList<BankAccount> accounts) {
        if (!RequestUsernames.isEmpty()) {
            String username = RequestUsernames.poll();
            int deposit = RequestDeposits.poll();
            int accNumber = RequestNumbers.poll();
            System.out.println("Processing request for: " + username + " ");
            BankAccount newAccount = new BankAccount(accNumber, username, deposit);
            accounts.add(newAccount);
            System.out.println("Account created!");
            if (!RequestUsernames.isEmpty()) {
                System.out.println("Next: " + RequestUsernames.peek());
            }
        } else {
            System.out.println("No pending requests.");
        }
    }
    public static void displayPendingRequests() {
        if (RequestUsernames.isEmpty()) {
            System.out.println("No pending requests.");
        } else {
            System.out.println("Pending requests: ");
            Queue<String> tempNames = new LinkedList<>(RequestUsernames);
            Queue<Integer> tempDeposits = new LinkedList<>(RequestDeposits);
            Queue<Integer> tempNumbers = new LinkedList<>(RequestNumbers);
            while (!tempNames.isEmpty()) {
                System.out.println(tempNames.poll() + " | Acc #: " + tempNumbers.poll() + " | Deposit: $" + tempDeposits.poll());
            }
        }
    }
    public static class BankAccountTask6 {
        private static Scanner sc = new Scanner(System.in);  // ← MAKE SURE THIS IS STATIC
        private static LinkedList<BankAccount> accounts = new LinkedList<>();

    public static void main (String [] args) {
        accounts.add(new BankAccount (1,"Ali", 150000));
        accounts.add(new BankAccount (2,"Sara", 220000));
        accounts.add(new BankAccount (3,"Mark", 300000));
            int mainChoice;
            do {
                System.out.println("MINI BANKING SYSTEM");
                System.out.println("1. Enter Bank");
                System.out.println("2. Enter ATM");
                System.out.println("3. Admin Area");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                mainChoice = sc.nextInt();
                switch (mainChoice) {
                    case 1:
                        bankMenu();
                        break;
                    case 2:
                        atmMenu();
                        break;
                    case 3:
                        adminMenu();
                        break;
                    case 4:
                        System.out.println("Thank you for using Mini Banking System!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (mainChoice != 4);

        sc.close();
    }
        public static void bankMenu() {
            int bankchoice;
            do {
                System.out.println("BANK MENU");
                System.out.println("1. Submit Account Request");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. View Transaction History");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter your choice: ");
                bankchoice = sc.nextInt();
                switch (bankchoice) {
                    case 1:
                        System.out.println("SUBMIT ACCOUNT REQUEST");
                        System.out.print("Enter username: ");
                        String username = sc.next();
                        System.out.print("Enter account number: ");
                        int accNumber = sc.nextInt();
                        System.out.print("Enter initial balance: ");
                        int balance = sc.nextInt();
                        BankAccount.submitRequest(username, accNumber, balance);
                        break;
                    case 2:
                        System.out.print("Enter name: ");
                        String name1 = sc.next();
                        BankAccount account1 = BankAccount.findAccount(accounts, name1);
                        if (account1 != null) {
                            System.out.print("Enter amount to deposit: ");
                            int amount = sc.nextInt();
                            account1.deposit(amount);
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter name: ");
                        String name2 = sc.next();
                        BankAccount account2 = BankAccount.findAccount(accounts, name2);
                        if (account2 != null) {
                            System.out.print("Enter amount to withdraw: ");
                            int amount = sc.nextInt();
                            account2.withdraw(amount);
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;
                    case 4:
                        System.out.print("Enter name: ");
                        String name3 = sc.next();
                        BankAccount account3 = BankAccount.findAccount(accounts, name3);
                        if (account3 != null) {
                            account3.displayTransactionHistory();
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;
                    case 5:
                        System.out.println("Returning to main menu...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (bankchoice != 5);
    }
        public static void atmMenu() {
            int atmchoice;
            do {;
                System.out.println("ATM MENU");
                System.out.println("1. Balance Enquiry");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Last Transaction");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter your choice: ");
                atmchoice = sc.nextInt();

                switch (atmchoice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name1 = sc.next();
                        BankAccount account1 = BankAccount.findAccount(accounts, name1);
                        if (account1 != null) {
                            System.out.println("Balance enquiry");
                            account1.displayAccount();
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;
                    case 2:
                        System.out.print("Enter name: ");
                        String name2 = sc.next();
                        BankAccount account2 = BankAccount.findAccount(accounts, name2);
                        if (account2 != null) {
                            System.out.println("Enter amount to withdraw");
                            int amount = sc.nextInt();
                            account2.withdraw(amount);
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter name: ");
                        String name3 = sc.next();
                        BankAccount account3 = BankAccount.findAccount(accounts, name3);
                        if (account3 != null) {
                            account3.getLastTransaction();
                        }
                        else {
                            System.out.println("Account not found!");
                        }
                        break;
                    case 4:
                        System.out.println("Returning to main menu...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (atmchoice != 4);
        }
        public static void adminMenu() {
            int adminchoice;
            do {
                System.out.println("ADMIN MENU");
                System.out.println("1. View Pending Requests");
                System.out.println("2. Process Next Request");
                System.out.println("3. View Bill Payment Queue");
                System.out.println("4. Process Bill Payment");
                System.out.println("5. View All Accounts");
                System.out.println("6. Back to Main Menu");
                System.out.print("Enter your choice: ");
                adminchoice = sc.nextInt();

                switch (adminchoice) {
                    case 1:
                        BankAccount.displayPendingRequests();
                        break;
                    case 2:
                        BankAccount.processNextRequest(accounts);
                        break;
                    case 3:
                        System.out.print("Enter name: ");
                        String name1 = sc.next();
                        BankAccount account1 = BankAccount.findAccount(accounts, name1);
                        if (account1 != null) {
                            account1.displayBillQueue();
                        }
                        else {
                            System.out.println("Account not found!");
                        }
                        break;
                    case 4:
                        System.out.print("Enter name: ");
                        String name2 = sc.next();
                        BankAccount account2 = BankAccount.findAccount(accounts, name2);
                        if (account2 != null) {
                            account2.processNextBill();
                        }
                        else {
                            System.out.println("Account not found!");
                        }
                        break;
                    case 5:
                        System.out.println("All accounts");
                        if (accounts.isEmpty()) {
                            System.out.println("No accounts found.");
                        } else {
                            for (BankAccount acc : accounts) {
                                acc.displayAccount();
                            };
                        }
                        break;
                    case 6:
                        System.out.println("Returning to main menu...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (adminchoice != 6);
        }

    }
}





