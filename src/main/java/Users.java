import java.util.ArrayList;
import java.util.List;

public class Users {
    private String username;
    private String password;
    private List<Profile> profileList;


    public Users(String name, String password) {
        this.username = name;
        this.password = password;
        this.profileList = new ArrayList<>();
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void removeAccount(Profile profile) {
        profileList.remove(profile);
    }

    public void addAccount(Profile profile) {
        profileList.add(profile);
    }

    public Profile getAccount(Long enteredId) {
        for (Profile profile : getProfileList()) {
            Long currentId = profile.getId();
            if (currentId.equals(enteredId)) {
                return profile;
            }
        }
        return null;
    }
}