import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMConsole {
    private static boolean atmPowerOn = true;
    private Scanner scanner;
    private PrimaryUserOptionsMenu primaryUserOptionsMenu;
    private UserManager userManager;

    public ATMConsole(Scanner scanner) {
        this.scanner = scanner;
        this.userManager = new UserManager(scanner);
        this.primaryUserOptionsMenu = new PrimaryUserOptionsMenu(scanner);
    }

    public static boolean isAtmPowerOn() {
        return atmPowerOn;
    }

    public static void setAtmPowerOn(boolean atmPowerOn) {
        ATMConsole.atmPowerOn = atmPowerOn;
    }

    public void runCLIMenu() {
        Users currentActiveUser;
        Ascii.printAscii();
        System.out.println("\nPlease select from an option below.");
        while (atmPowerOn) {
            System.out.println("\n" +
                    "Please choose from the following options:\n" +
                    "1 - Login to your Personal Profile\n" +
                    "2 - Create a New Personal Profile\n" +
                    "3 - Cancel Transaction\n" +
                    "---------------------------------\n" +
                    "Enter choice here: -> ");

            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        currentActiveUser = userManager.loginUser();
                        primaryUserOptionsMenu.runMainUserOptionsMenu(currentActiveUser);
                        break;
                    case 2:
                        userManager.createNewUser();
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
            } catch (NullPointerException e) {
                System.out.println(("\n" + "You do not have an account of that type with C3, please open an account of that nature."));
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("\n" + "Incorrect option chosen, please choose one of the menu options below.");
            }
        }
    }
}
