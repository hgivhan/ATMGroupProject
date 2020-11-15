import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimaryUserOptionsMenu {
    private Scanner scanner;
    private Users currentActiveUser;
    Accounts accounts;

    public void runMainUserOptionsMenu() {
        boolean powerOn = true;
        System.out.println("\nYou have successfully logged into " + this.currentActiveUser + "'s profile.\n");
        while (ATMConsole.isAtmPowerOn() && powerOn) {
            System.out.println("\n" +
                    "Please select from the following options:\n" +
                    "1 - Access Account Menu\n" +
                    "2 - Access User Profile Info\n" +
                    "3 - Cancel Transaction\n" +
                    "---------------------------------\n" +
                    "Enter choice here: -> ");

            try {
                int input = scanner.nextInt();
                switch(input) {
                    case 1:
                        accounts.runAccountMenuOptions();
                        break;
                    case 2:
                        System.out.println("user profile");
                        break;
                    case 3:
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

    public void runAccountMenuOptions() {
    }

    public void runUserMenuOptions() {
    }

}
