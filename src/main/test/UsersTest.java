import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import org.junit.Assert;
import org.junit.Test;

public class UsersTest {

    @Test
    public void userConstructorTest(){
        // Given
        String expectedUsername = "bankmember1";
        String expectedPassword = "p@ssw0rd!";
        Users amanda = new Users(expectedUsername, expectedPassword);

        // When
        String actualUsername = amanda.getUsername();
        String actualPassword = amanda.getPassword();

        // Then
        Assert.assertEquals(expectedUsername, actualUsername);
        Assert.assertEquals(expectedPassword, actualPassword);
    }

    @Test
    public void goToAccountsMenuTest(){
        // Given
        // When
        // Then
    }

    @Test
    public void switchUserTest(){
        // Given
        // When
        // Then
    }
    private Users currentUser;
    private boolean atmIsOn;
//    private Users users = new Users();

}
