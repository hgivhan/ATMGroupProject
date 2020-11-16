import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Users {
    private String username;
    private String password;
    private java.util.List<String> transactionHistory = new ArrayList<>();
    private Checking checking;
    private Savings savings;
    private Investment investment;

    public void changeUserProfiles(Users currentActiveUser) {
        Scanner scanner = new Scanner(System.in);
        boolean powerOn = true;
        while (ATMConsole.isAtmPowerOn() && powerOn) {
            System.out.println("\n" +
                    "Please select from the following options:\n" +
                    "1 - Change Username\n" +
                    "2 - Change Password\n" +
                    "3 - Go Back to Primary User Options Menu\n" +
                    "4 - Cancel Transaction\n" +
                    "---------------------------------\n" +
                    "Enter choice here: -> ");

            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("Please provide your new username: ");
                        String newUsername = scanner.next();
                        currentActiveUser.setUsername(newUsername);
                        System.out.println("New username saved.");
                        break;
                    case 2:
                        System.out.println("Please provide your new password: ");
                        String newPassword = scanner.next();
                        currentActiveUser.setUsername(newPassword);
                        System.out.println("New password saved.");
                        break;
                    case 3:
                        powerOn = false;
                        break;
                    case 4:
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


    public Users(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public Checking getChecking() {
        return checking;
    }

    public void setChecking(Checking checking) {
        this.checking = checking;
    }

    public Savings getSavings() {
        return savings;
    }

    public void setSavings(Savings savings) {
        this.savings = savings;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "transactionHistory=" + transactionHistory +
                "\n" + '}';
    }
}
