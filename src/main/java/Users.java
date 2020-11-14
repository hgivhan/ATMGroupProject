public class Users extends UsersAccountInfo {
    private String username;
    private Console console = new Console();
    private boolean atmIsOn;
    private Users users = new Users();
    private String password;


    public Users(String name, String password, Integer debitCardNumber, Integer pinNumber) {
        super(name, debitCardNumber, pinNumber);
        this.username = name;
        this.password = password;
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

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public boolean isAtmIsOn() {
        return atmIsOn;
    }

    public void setAtmIsOn(boolean atmIsOn) {
        this.atmIsOn = atmIsOn;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
