import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private Scanner scanner;
    private List<Users> userList;

    public UserManager(Scanner scanner) {
        this.scanner = scanner;
        this.userList = new ArrayList<>();
    }

    public void addUsername(Users currentActiveUser) {
        System.out.println("Please provide a username you would like to use:");
        currentActiveUser.setUsername(scanner.nextLine());
    }

    public void addPassword(Users currentActiveUser) {
        System.out.println("Please provide a password for your profile:");
        currentActiveUser.setPassword(scanner.nextLine());
    }

    public void addPinNumber(Users currentActiveUser) {
        System.out.println("Please provide a pin for any accounts you open with C3's ATM");
        currentActiveUser.setPinNumber(scanner.nextInt());
    }

    public Users createNewUser() {
        System.out.println("Please provide a username you would like to use:");
        String username = scanner.next();
        System.out.println("Please provide a password for your profile:");
        String password = scanner.next();
        System.out.println("Please provide a pin for any accounts you open with C3's ATM");
        Integer pinNumber = scanner.nextInt();

        Users currentActiveUser = new Users(username, password, pinNumber);
        this.userList.add(currentActiveUser);
        return currentActiveUser;
    }

    public Users switchUser() {
        Users currentActiveUser = null;
        System.out.println("Welcome to the User-Selection-Menu.\n" +
                "Please enter your username.");
        String username = scanner.next();
        System.out.println("Please enter your password.");
        String password = scanner.next();
        for (Users user : userList) {
            String currentName = user.getUsername();
            String currentPassword = user.getPassword();
            boolean isCorrectName = currentName.equals(username);
            boolean isCorrectPassword = currentPassword.equals(password);
            boolean isValid = isCorrectName && isCorrectPassword;
            if (isValid) {
                currentActiveUser = user;
            }
        }
        if (currentActiveUser == null) {
            currentActiveUser = createNewUser();
        }
        return currentActiveUser;
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

//    public void accessUsersMenu() {
//        System.out.println("Welcome to the User-Menu.");
//        System.out.println("From here, you can select any of the following options:");
//        System.out.println("[ switch user, update account ]");
//        String menuSelection = scanner.nextLine();
//        if (menuSelection.equalsIgnoreCase("switch user")) {
//            switchUser();
//        } else if (menuSelection.equalsIgnoreCase("update account")) {
//            updateAccount(currentActiveUser);
//        }
//    }

    public void updateAccount(Users currentActiveUser) {
        addUsername(currentActiveUser);
        addPassword(currentActiveUser);
        addPinNumber(currentActiveUser);
    }
}
