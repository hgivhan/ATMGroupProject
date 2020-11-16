import java.util.InputMismatchException;
import java.util.Scanner;

public class Savings extends Accounts {
    public Savings(Scanner scanner, Double balance) {
        super(scanner, balance);
    }

    public Savings(double balance) {
        super(balance);
    }

    public void savingsAccountOptions(Users currentActiveUser) {
        Scanner scanner = new Scanner(System.in);
        boolean powerOn = true;
        while (ATMConsole.isAtmPowerOn() && powerOn) {
            System.out.println("\n" +
                    "Please select from the following options:\n" +
                    "1 - Deposit to Savings Account\n" +
                    "2 - Withdraw from Savings Account\n" +
                    "3 - Transfer from Savings Account\n" +
                    "4 - Savings Account Balance\n" +
                    "5 - Go Back to Account Options Menu\n" +
                    "6 - Cancel Transaction\n" +
                    "---------------------------------\n" +
                    "Enter choice here: -> ");
            try {
                    int input = scanner.nextInt();
                    switch (input) {
                        case 1:
                            System.out.println("Please indicate deposit amount:");
                            Double depositAmount = scanner.nextDouble();
                            currentActiveUser.getSavings().setBalance(currentActiveUser.getSavings().getBalance() + depositAmount);
                            System.out.println("Deposit processed. New balance: $" + currentActiveUser.getSavings().getBalance());
                            currentActiveUser.getTransactionHistory().add("Deposit processed. New balance: $" + currentActiveUser.getSavings().getBalance());
                            break;
                        case 2:
                            System.out.println("Please indicate withdrawal amount:");
                            Double withdrawalAmount = scanner.nextDouble();
                            if (withdrawalAmount > currentActiveUser.getSavings().getBalance()) {
                                System.out.println("You have insufficient funds.\nPlease re-enter a withdrawal amount: ");
                                withdrawalAmount = scanner.nextDouble();
                                continue;
                            } else {
                                currentActiveUser.getSavings().setBalance(currentActiveUser.getSavings().getBalance() - withdrawalAmount);
                                System.out.println("Withdrawal processed. New balance: $" + currentActiveUser.getSavings().getBalance());
                                currentActiveUser.getTransactionHistory().add("Withdrawal processed. New balance: $" + currentActiveUser.getSavings().getBalance());
                            }
                            break;
                        case 3:
                            System.out.println("Please indicate what account you would like to transfer too?\n" +
                                    "1 - Checking, 2 - Investment\n" +
                                    "Enter choice here: -> ");
                            int transferInput = scanner.nextInt();
                            System.out.println("Please indicate transfer amount:");
                            Double transferAmount = scanner.nextDouble();
                            if (transferAmount > currentActiveUser.getSavings().getBalance()) {
                                System.out.println("You have insufficient funds.\nPlease re-enter a transfer amount: ");
                                transferAmount = scanner.nextDouble();
                                continue;
                            } else {
                                currentActiveUser.getSavings().setBalance(currentActiveUser.getSavings().getBalance() - transferAmount);
                            }
                            if (transferInput == 1) {
                                currentActiveUser.getChecking().setBalance(currentActiveUser.getChecking().getBalance() + transferAmount);
                                currentActiveUser.getTransactionHistory().add("Transfer processed. New Checking balance: $" + currentActiveUser.getChecking().getBalance());
                                System.out.println("\nTransfer Complete.");
                            } else {
                                currentActiveUser.getInvestment().setBalance(currentActiveUser.getInvestment().getBalance() + transferAmount);
                                currentActiveUser.getTransactionHistory().add("Transfer processed. New Investment balance: $" + currentActiveUser.getInvestment().getBalance());
                                System.out.println("\nTransfer Complete.");
                            }
                            break;
                        case 4:
                            System.out.println("\nCurrent Checking Account Balance: $" + currentActiveUser.getSavings().getBalance());
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
                } catch (InputMismatchException e) {
                scanner.next();
                System.out.println(("\n" + "Invalid selection, please choose again."));
            }
        }
    }
}
