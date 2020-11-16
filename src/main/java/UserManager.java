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

    public Users createNewUser() {
        System.out.println("\nPlease provide a username you would like to use:");
        String username = scanner.next();
        System.out.println("\nPlease provide a password for your profile:");
        String password = scanner.next();

        Users currentActiveUser = new Users(username, password);
        this.userList.add(currentActiveUser);
        return currentActiveUser;
    }

    public Users loginUser() {
        Users currentActiveUser = null;
        System.out.println("\n" +
                "Please enter your username.");
        String username = scanner.next();
        System.out.println("\nPlease enter your password.");
        String password = scanner.next();
        for (Users user : userList) {
            String currentName = user.getUsername();
            String currentPassword = user.getPassword();
            boolean isCorrectName = currentName.equals(username);
            boolean isCorrectPassword = currentPassword.equals(password);
            boolean isValid = isCorrectName && isCorrectPassword;
            if (isValid) {
                currentActiveUser = user;
            } else {
                System.out.println("\nIncorrect user or password, please try again.");
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
}
