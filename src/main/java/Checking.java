import java.util.InputMismatchException;
import java.util.Scanner;

public class Checking extends Accounts {
    private Scanner scanner;
    public Checking(Scanner scanner, Users currentActiveUser, Double balance) {
        super(scanner, currentActiveUser, balance);
    }

    public Checking(Users currentActiveUser) {
        super(currentActiveUser);

    }
    public void checkingAccountOptions(Users currentActiveUser) {
        boolean powerOn = true;
        while (ATMConsole.isAtmPowerOn() && powerOn) {
            System.out.println("\n" +
                    "Please select from the following options:\n" +
                    "1 - Deposit to Checking Account\n" +
                    "2 - Withdraw from Checking Account\n" +
                    "3 - Transfer from Checking Account\n" +
                    "4 - Checking Account Balance\n" +
                    "5 - Go Back to Account Options Menu\n" +
                    "6 - Cancel Transaction" +
                    "---------------------------------\n" +
                    "Enter choice here: -> ");
            try {
                try {
                    int input = scanner.nextInt();
                    switch (input) {
                        case 1:
                            System.out.println("Please indicate deposit amount:");
                            Double depositAmount = scanner.nextDouble();
                            currentActiveUser.getChecking().setBalance(currentActiveUser.getChecking().getBalance() + depositAmount);
                            currentActiveUser.getTransactionHistory().add("Deposit processed. New balance: $" + currentActiveUser.getChecking().getBalance());
                            break;
                        case 2:
                            System.out.println("Please indicate withdrawal amount:");
                            Double withdrawalAmount = scanner.nextDouble();
                            if (withdrawalAmount > currentActiveUser.getChecking().getBalance()) {
                                System.out.println("You have insufficient funds.\nPlease re-enter a withdrawal amount: ");
                                withdrawalAmount = scanner.nextDouble();
                                continue;
                            } else {
                                currentActiveUser.getChecking().setBalance(currentActiveUser.getChecking().getBalance() - withdrawalAmount);
                            }
                            currentActiveUser.getTransactionHistory().add("Withdrawal processed. New balance: $" + currentActiveUser.getChecking().getBalance());
                            break;
                        case 3:
                            System.out.println("Please indicate what account you would like to transfer too?\n" +
                                    "1 - Savings, 2 - Investment\n" +
                                    "Enter choice here: -> ");
                            int transferInput = scanner.nextInt();
                            System.out.println("Please indicate transfer amount:");
                            Double transferAmount = scanner.nextDouble();
                            if (transferAmount > currentActiveUser.getChecking().getBalance()) {
                                System.out.println("You have insufficient funds.\nPlease re-enter a transfer amount: ");
                                transferAmount = scanner.nextDouble();
                                continue;
                            } else {
                                currentActiveUser.getChecking().setBalance(currentActiveUser.getChecking().getBalance() - transferAmount);
                            }
                            if (transferInput == 1) {
                                currentActiveUser.getSavings().setBalance(currentActiveUser.getSavings().getBalance() + transferAmount);
                                currentActiveUser.getTransactionHistory().add("Transfer processed. New Savings balance: $" + currentActiveUser.getSavings().getBalance());
                            } else {
                                currentActiveUser.getInvestment().setBalance(currentActiveUser.getInvestment().getBalance() + transferAmount);
                                currentActiveUser.getTransactionHistory().add("Transfer processed. New Investment balance: $" + currentActiveUser.getInvestment().getBalance());
                            }
                            break;
                        case 4:
                            System.out.println("Current Checking Account Balance: $" + currentActiveUser.getChecking().getBalance());
                            break;
                        case 5:
                            System.out.println("Returning to Account Options Menu");
                            powerOn = false;
                            break;
                        case 6:
                            System.out.println("You have canceled the transaction.\n" +
                                    "Enjoy the rest of your day.");
                            powerOn = false;
                            ATMConsole.setAtmPowerOn(false);
                            break;
                        default:
                            System.out.println("\n" + "Incorrect option chosen, please choose one of the menu options below.");
                            break;
                    }
                } catch (NullPointerException e) {
                    System.out.println(("\n" + "You do not have that type of account, please open that type of account to access select again"));
                }
            } catch (InputMismatchException e) {
                System.out.println(("\n" + "Invalid selection, please choose again."));
            }
        }
    }
}
