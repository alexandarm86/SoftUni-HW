import java.util.Scanner;

public class Account {

    //Class Variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Class constructor
    Account(String cName, String cID) {
        customerName = cName;
        customerID = cID;
    }

    //Function for Depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    //Function for Withdrawing money
    void withdraw(int amount2) {
        if (amount2 != 0) {
            balance -= amount2;
            previousTransaction = -amount2;
        }
    }

    //Function showing the previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println(
                    "Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    //Function calculating interest
    void calculateInterest(int years) {
        double interestRate = 0.0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + "years, your balance will be " + newBalance);
    }

    //Function showing the main menu

    void showMenu() {
        char option = '\0';
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scan.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A':
                    //Check balance
                    System.out.println("===================");
                    System.out.println("Balance = " + balance + "lv.");
                    System.out.println("===================");
                    System.out.println();
                    break;
                case 'B':
                    //Deposit
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scan.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    //withdraw
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scan.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    //view resent transaction
                    System.out.println("===================");
                    getPreviousTransaction();
                    System.out.println("===================");
                    System.out.println();
                    break;
                case 'E':
                    //calculate interest
                    System.out.println("Enter years of accrued interest: ");
                    int years = Integer.parseInt(scan.nextLine());
                    calculateInterest(years);
                    break;
                case 'F':
                    //exit from account
                    System.out.println("===================");
                    break;
                default:
                    System.out.println("Error: invalid option." +
                            "Please enter A, B, C, D, E, F");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}
