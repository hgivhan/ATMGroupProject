import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Users {
    private String firstName;
    private String lastName;
    private Integer debitCardNumber;
    private Integer pin;
    private java.util.List<String> transactionHistory;
    private java.util.TreeMap<String, Users> listOfUsers;

    public Users(String firstName, String lastName, Integer debitCardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.debitCardNumber = debitCardNumber;
        this.pin = 0;
        this.transactionHistory = new ArrayList<>();
        this.listOfUsers = new TreeMap<String, Users>();
    }

    public void getUserInfo() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(Integer debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public TreeMap<String, Users> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(TreeMap<String, Users> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }
}
