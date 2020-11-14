import java.util.Map;
import java.util.TreeMap;

public class UserProfiles {
    private Integer pin;
    private Map<String, Users> listOfUsers;

    UserProfiles userProfiles = new UserProfiles();

    public UserProfiles() {
        pin = 10;
        listOfUsers = new TreeMap<String, Users>();
    }


    public void removeUser(Users user) {
//        if (any of the accounts dont equal zero)
//        then "Funds are still present in your accounts. Please withdrawal before closing your profile."
//        else remove the user
    }

    public void addNewUsers(Users user) {
//        method to add new users
    }



}
