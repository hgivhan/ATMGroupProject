import java.util.List;

public class Users {
    private String username;
    private String password;
    private Integer pinNumber;
    private java.util.List<String> transactionHistory;
    private Checking checking;
    private Savings savings;
    private Investment investment;

    public Users(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(Integer pinNumber) {
        this.pinNumber = pinNumber;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public Checking getChecking() {
        return checking;
    }

    public void setChecking(Checking checking) {
        this.checking = checking;
    }

    public Savings getSavings() {
        return savings;
    }

    public void setSavings(Savings savings) {
        this.savings = savings;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

    public Users(String username, String password, Integer pinNumber) {
        this.username = username;
        this.password = password;
        this.pinNumber = pinNumber;
    }

    public Users() {
    }

//    public void removeAccount(Profile profile) {
//        profileList.remove(profile);
//    }
//    public void addAccount(Profile profile) {
//        profileList.add(profile);
//    }
//    public Profile getAccount(Long enteredId) {
//        for (Profile profile : getProfileList()) {
//            Long currentId = profile.getId();
//            if (currentId.equals(enteredId)) {
//                return profile;
//            }
//        }
//        return null;
//    }
}
