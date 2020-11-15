

import java.util.Scanner;
public class UsersAccountInfo {
    private String name;
    private Integer debitCardNumber;
    private Integer pinNumber;
    private java.util.List<String> transactionHistory;
    private java.util.LinkedHashMap<String, Users> listOfUsers;
    public UsersAccountInfo(String name, Integer debitCardNumber, Integer pinNumber) {
        super();
        this.name = name;
        this.debitCardNumber = debitCardNumber;
        this.pinNumber = pinNumber;
    }
    public void createNewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username");
        String userName = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        Users newUser = new Users(userName, password);
        listOfUsers.put(userName, newUser);
    }
    public void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username");
        String userName = scanner.nextLine();
        Users user = listOfUsers.get(userName);
        String userPassword = user.getPassword();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        if(password.equals(userPassword)) {
            listOfUsers.remove(user);
        }
    }
    public String[] getUserInfo() {
        return new String[]{name, debitCardNumber.toString(), pinNumber.toString()};
    }
    public String getName() {
        return name;
    }
    public Integer getCardNumber() {
        return debitCardNumber;
    }
    public Integer getPin() {
        return pinNumber;
    }
}