import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<Users> userList;
    private Users currentActiveUser;
    private IOConsole console;

    public UserManager() {
        this.userList = new ArrayList<>();
        this.console = new IOConsole(System.in, System.out);
        this.currentActiveUser = null;
    }

    public void accessAccountMenu() {
        console.println("Welcome to the Account-Menu.");
        console.println("From here, you can select any of the following:");
        String userInput = console.getStringInput("[ create account, select account ]");
        if ("select account".equalsIgnoreCase(userInput)) {
            selectPreexistingAccount();
        } else {
            Integer id = currentActiveUser.getProfileList().size();
            Profile profile = new Profile(null, null, null, null);
        }
    }

    public void selectPreexistingAccount() {
        String accountIdList = "";
        for (Profile profile : currentActiveUser.getProfileList()) {
            Long accountId = profile.getId();
            accountIdList += "," + accountId;
        }
        Long enteredId = console.getLongInput(accountIdList);
        Profile profileToModify = currentActiveUser.getAccount(enteredId);
        if (profileToModify == null) {
            this.accessAccountMenu();
        } else {
            accessModifyAccountMenu();
        }
    }

    public void accessModifyAccountMenu() {
        console.println("Welcome to the Account-Modification-Menu.");
        console.println("From here, you can select any of the following options:");
        String userInput = console.getStringInput("[ deposit, withdrawal, delete]");
    }

    public void accessUsersMenu() {
        console.println("Welcome to the User-Menu.");
        console.println("From here, you can select any of the following options:");
        String menuSelection = console.getStringInput("[ switch user, update account ]");
        if ("switch-user".equalsIgnoreCase(menuSelection)) {
            switchUser();
        } else if ("update-account".equalsIgnoreCase(menuSelection)) {
            updateAccount();
        } else {
            accessAccountMenu();
        }
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
            }
        }
    }

    public void updateAccount() {

    }

    public Users getCurrentActiveUser() {
        return currentActiveUser;
    }

    public void addUser(Users userToBeAdded) {
        userList.add(userToBeAdded);
    }

    public boolean contains(Users userToBeCreated) {
        return userList.contains(userToBeCreated);
    }

    public void deleteUser(Users userToBeRemoved) {
        userList.remove(userToBeRemoved);
    }
}
