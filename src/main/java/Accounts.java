import java.util.InputMismatchException;
import java.util.Scanner;

public class Accounts {
    private Scanner scanner;
    private Double balance;

    public Accounts(Scanner scanner, Double balance) {
        this.scanner = scanner;
        this.balance = balance;
    }

    public Accounts(double balance) {
        this.balance = 0.00;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void runAccountMenuOptions(Users currentActiveUser) {
        boolean powerOn = true;
        while (ATMConsole.isAtmPowerOn() && powerOn) {
            System.out.println("\n" +
                    "Please select from the following options:\n" +
                    "1 - Checking Account Menu\n" +
                    "2 - Savings Account Menu\n" +
                    "3 - Investment Account Menu\n" +
                    "4 - Print Transaction History\n" +
                    "5 - Open New Account\n" +
                    "6 - Close an Account\n" +
                    "7 - Go Back to Primary User Options Menu\n" +
                    "8 - Cancel Transaction\n" +
                    "---------------------------------\n" +
                    "Enter choice here: -> ");

            try{
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        currentActiveUser.getChecking().checkingAccountOptions(currentActiveUser);
                        break;
                    case 2:
                        currentActiveUser.getSavings().savingsAccountOptions(currentActiveUser);
                        break;
                    case 3:
                        currentActiveUser.getInvestment().investmentAccountOptions(currentActiveUser);
                        break;
                    case 4:
                        System.out.println(currentActiveUser.getTransactionHistory().toString());
                        break;
                    case 5:
                        System.out.println("\nPlease indicate which type of account you would like to create?\n" +
                                "1 - Checking Account\n" +
                                "2 - Savings Account\n" +
                                "3 - Investment Account");
                        int newAccountChoice = scanner.nextInt();
                        if (newAccountChoice == 1) {
                            currentActiveUser.setChecking(new Checking(0.00));
                            System.out.println("\nThank you for opening a Checking Account with C3.");
                        } else if (newAccountChoice == 2) {
                            currentActiveUser.setSavings(new Savings(0.00));
                            System.out.println("\nThank you for opening a Savings Account with C3.");
                        } else {
                            currentActiveUser.setInvestment(new Investment(0.00));
                            System.out.println("\nThank you for opening a Investment Account with C3.");
                        }
                        break;
                    case 6:
                        System.out.println("Please indicate which type of account you would like to delete?\n" +
                                "1 - Checking Account\n" +
                                "2 - Savings Account\n" +
                                "3 - Investment Account");
                        int deleteAccountChoice = scanner.nextInt();
                        if (deleteAccountChoice == 1) {
                            currentActiveUser.setChecking(null);
                        } else if (deleteAccountChoice == 2) {
                            currentActiveUser.setSavings(null);
                        } else {
                            currentActiveUser.setInvestment(null);
                        }
                        break;
                    case 7:
                        powerOn = false;
                        break;
                    case 8:
                        System.out.println("You have canceled the transaction.\n" +
                                "Enjoy the rest of your day.");
                        powerOn = false;
                        ATMConsole.setAtmPowerOn(false);
                        break;
                    default:
                        System.out.println("\n" + "Incorrect option chosen, please choose one of the menu options below.");
                        break;
                }

            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("\n" + "Incorrect option chosen, please choose one of the menu options below.");
            }
        }

    }
}
