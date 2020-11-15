import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private List<Users> userList;
    private IOConsole console;
    private Users currentActiveUser;

    Scanner scanner = new Scanner(System.in);
    Users users = new Users();

    public UserManager() {
        this.userList = new ArrayList<>();
        this.console = new IOConsole(System.in, System.out);
        this.currentActiveUser = null;
    }

    public void setCurrentActiveUser(Users currentActiveUser) {

        this.currentActiveUser = currentActiveUser;
    }

    public Users getCurrentActiveUser() {

        return currentActiveUser;
    }

    public void addUsername(Users currentActiveUser) {
        System.out.println("Please provide a username you would like to use:");
        users.setUsername(scanner.nextLine());
    }

    public void addPassword(Users currentActiveUser) {
        System.out.println("Please provide a password for your profile:");
        users.setPassword(scanner.nextLine());
    }

    public void addPinNumber(Users currentActiveUser) {
        System.out.println("Please provide a pin for any accounts you open with C3's ATM");
        users.setPinNumber(scanner.nextInt());
    }

    public void createNewUser() {
        userList.add(new Users(scanner.nextLine()));
        System.out.println("Thank you for choosing to create a new User Profile with C3's ATM.\n" +
                "Please provide a username you would like to use:");
        System.out.println("\nPlease provide a password for your profile:");
        addPassword(userList.get(userList.size() - 1));
        System.out.println("\nPlease provide a pin for any accounts you open with C3's ATM");
        addPinNumber(userList.get(userList.size() - 1));
    }

    public void switchUser() {
        console.println("Welcome to the User-Selection-Menu.");
        String username = console.getStringInput("Please enter your username.");
        String password = console.getStringInput("Please enter your password.");
        for (Users user : userList) {
            String currentName = user.getUsername();
            String currentPassword = user.getPassword();
            boolean isCorrectName = currentName.equals(username);
            boolean isCorrectPassword = currentPassword.equals(password);
            boolean isValid = isCorrectName && isCorrectPassword;
            if (isValid) {
                this.currentActiveUser = user;
            } else {
                createNewUser();
            }
        }
    }





    public void deleteUser(Users currentActiveUser) {
        System.out.println("Please confirm deletion with providing your password:");
        String deletionPassword = scanner.nextLine();
        if (currentActiveUser.getPassword().equals(deletionPassword)) {
            userList.remove(currentActiveUser);
        }
    }

//    public void accessAccountMenu() {
//        console.println("Welcome to the Account-Menu.");
//        console.println("From here, you can select any of the following:");
//        String userInput = console.getStringInput("[ create account, select account ]");
//        if ("select account".equalsIgnoreCase(userInput)) {
//            selectPreexistingAccount();
//        } else {
//            Integer id = currentActiveUser.getProfileList().size();
//            Profile profile = new Profile(null, null, null, null);
//        }
//    }
//
//    public void selectPreexistingAccount() {
//        String accountIdList = "";
//        for (Profile profile : currentActiveUser.getProfileList()) {
//            Long accountId = profile.getId();
//            accountIdList += "," + accountId;
//        }
//        Long enteredId = console.getLongInput(accountIdList);
//        Profile profileToModify = currentActiveUser.getAccount(enteredId);
//        if (profileToModify == null) {
//            this.accessAccountMenu();
//        } else {
//            accessModifyAccountMenu();
//        }
//    }
//
//    public void accessModifyAccountMenu() {
//        console.println("Welcome to the Account-Modification-Menu.");
//        console.println("From here, you can select any of the following options:");
//        String userInput = console.getStringInput("[ deposit, withdrawal, delete]");
//    }

    public void accessUsersMenu() {
        console.println("Welcome to the User-Menu.");
        console.println("From here, you can select any of the following options:");
        String menuSelection = console.getStringInput("[ switch user, update account ]");
        if ("switch-user".equalsIgnoreCase(menuSelection)) {
            switchUser();
        } else if ("update-account".equalsIgnoreCase(menuSelection)) {
            updateAccount(currentActiveUser);
        }
    }

    public void updateAccount(Users currentActiveUser) {
        addUsername(currentActiveUser);
        addPassword(currentActiveUser);
        addPinNumber(currentActiveUser);
    }
}
