import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimaryUserOptionsMenu {
    private Users currentLoggedInUser;
    private Profile listOfUsers;

    public void runMainUserOptionsMenu(Scanner scanner) {
        boolean powerOn = true;
        System.out.println("\nYou have successfully logged into <Username>'s profile.\n");
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
                        System.out.println("account menu");
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
