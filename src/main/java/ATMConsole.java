import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMConsole {
    private static boolean atmPowerOn = true;

    public static boolean isAtmPowerOn() {
        return atmPowerOn;
    }

    public static void setAtmPowerOn(boolean atmPowerOn) {
        ATMConsole.atmPowerOn = atmPowerOn;
    }

    public void runCLIMenu(Scanner scanner) {
        PrimaryUserOptionsMenu primaryUserOptionsMenu = new PrimaryUserOptionsMenu();

        System.out.println("Welcome to C3's ATM.\n" +
                "Please select from an option below.");
        while(atmPowerOn) {
            System.out.println("\n" +
                    "Please choose from the following options:\n" +
                    "1 - Login to your Personal Profile\n" +
                    "2 - Create a New Personal Profile\n" +
                    "3 - Cancel Transaction\n" +
                    "---------------------------------\n" +
                    "Enter choice here: -> ");

            try {
                int input = scanner.nextInt();
                switch(input) {
                    case 1:
                        primaryUserOptionsMenu.runMainUserOptionsMenu(scanner);
                        break;
                    case 2:
                        System.out.println("You created a new profile");
                        break;
                    case 3:
                        System.out.println("You have canceled the transaction.\n" +
                                "Enjoy the rest of your day.");
                        atmPowerOn = false;
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

    public void userLogin() {
    }

    public void createNewUser() {
    }
}
