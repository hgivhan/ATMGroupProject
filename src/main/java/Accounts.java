import java.util.InputMismatchException;
import java.util.Scanner;

public class Accounts extends PrimaryUserOptionsMenu {
    private UserManager userAccount; // this will be an object of objects, each instance field will be an account type
    private IOConsole console = new IOConsole(null ,null);
    private Users currentUser;
    private Double balance;

    public Accounts(UserManager userAccount, Users currentUser, Double balance) {
        this.userAccount = userAccount;
        this.currentUser = currentUser;
        this.balance = balance;
    }



    public void runAccountMenuOptions() {
        boolean keepOn = true;
        Integer input1 = 0;
        Integer input2 = 0;
        Double depositAmount = new Double(0);
        Double withdrawAmount = new Double(0);
        Double transferAmount = new Double(0);

        Scanner scan = new Scanner(System.in);

        while(keepOn) {

            console.print("Account Menu" +
                    "\n1: Access Savings Account" +
                    "\n2: Access Checking Account" +
                    "\n3: Access Investment Account" +
                    "\n4: Create an Account" +
                    "\n5: Close an Account" +
                    "\n6: Go Back to Main Menu" +
                    "\n Please provide your selection: ");

            input1 = scan.nextInt();

            try {
                switch(input1) {
                    case 1: // Savings Account
                        try {
                            if (this.userAccount.equals("savings")) {  // ***** check user account type ******
                                console.print("Account Action Menu " +
                                        "\n1: Deposit" +
                                        "\n2: Withdraw" +
                                        "\n3: Transfer Funds" +
                                        "\n4: Check Account Balance" +
                                        "\n5: Go Back to Account Options Menu" +
                                        "\n Please make a selection: ");

                                input2 = scan.nextInt();

                                switch(input2) {
                                    case 1:
                                       depositAmount = console.getDoubleInput("\n Please enter the amount you want to deposit: ");
                                       deposit(depositAmount);
                                       break;

                                    case 2:
                                        withdrawAmount = console.getDoubleInput("\n Please enter the amount you want to withdraw: ");
                                        withdraw(withdrawAmount);
                                        break;

                                    case 3:
                                        // ***** need user input as to the account they want to transfer to ******

                                        transferAmount = console.getDoubleInput("\n Please enter the amount you want to transfer: ");
                                        transfer(transferAmount, 1);
                                        break;

                                    case 4:
                                        checkAccountBalance();
                                        break;

                                    case 5:
                                        break;

                                    default:
                                        console.println("Please make a valid selection");
                                        break;
                                }
                            }

                        } catch (NullPointerException e) {
                            console.println("\n" + "You do not have that type of account, please select again");
                            break;
                        }

                        break;

                    case 2: // Checking Account
                        break;



                }

            } catch (InputMismatchException e) {
                console.println("\n" + "Invalid selection, please choose again.");
            }
        }
    }






    public void deposit(double depositAmount) {
        this.balance += depositAmount;
        // ***** update user transaction history and balance for this user in the appropriate account *****
        console.println("Your deposit is complete. Your current balance is $%.2f", this.balance);
    }

    public void withdraw(double withdrawAmount) {
        if (withdrawAmount > this.balance) {
            console.println("You have insufficient funds. Please enter a different amount");
            // ***** how do you loop back out to have the user input a different amount?
        } else {
            this.balance -= withdrawAmount;
        }
        // ***** update user transaction history and balance for this user in the appropriate account *****
        console.println("Your withdrawal is complete. Your current balance is $%.2f", this.balance);
    }

    public void transfer(double transferAmount, int transferToAccount) {
        String transferTo = "";

        if (transferToAccount == 1) { // ***** make sure the account type names match appropriately *****
            transferTo = "savings";
        } else if (transferToAccount == 2) {
            transferTo = "checking";
        } else {
            transferTo = "investment";
        }

        if (this.balance > transferAmount) {
            console.println("You have insufficient funds for the transfer. Please enter a different amount");
        } else {
            this.balance -= transferAmount;
        }
        // ***** update user transaction history and balance for this user in the appropriate accounts *****
        console.println("Your transfer is complete. Your current balance in this account is $%.2f", this.balance);

    }

    public void createNewAccount() {
    }

    public void deleteAccount() {
    }

    public void checkAccountBalance() {
        console.println("Your account's balance is $%.2f", this.balance);
    }

    public void returnToLogin() {
    }

    public void chooseAccount() {
    }
}

