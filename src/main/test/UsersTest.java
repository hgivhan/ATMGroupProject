import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class UsersTest {

    @Test
    public void userConstructorTest() {
        // Given
        String expectedPassword = "p@ssw0rd!";
        String expectedUsername = "bankmember1";
        Users amanda = new Users(expectedUsername, expectedPassword);
        // When
        String actualUsername = amanda.getUsername();
        String actualPassword = amanda.getPassword();
        // Then
        Assert.assertEquals(expectedUsername, actualUsername);
    }
    @Test
    public void setUserNameTest() {
        // Given
        String expectedUserName = "christian2";
        Users christian = new Users();
        // When
        christian.setUsername(expectedUserName);
        String actualUserName = christian.getUsername();
        // Then
        Assert.assertEquals(expectedUserName, actualUserName);
    }
    @Test
    public void setUserName2Test() {
        // Given
        String expectedUserName = "b@tman";
        Users bruce = new Users();
        // When
        bruce.setUsername(expectedUserName);
        String actualUserName = bruce.getUsername();
        // Then
        Assert.assertEquals(expectedUserName, actualUserName);
    }
    @Test
    public void setPasswordTest() {
        // Given
        String expectedPassword = "c00lg!rl7";
        Users amanda = new Users();
        // When
        amanda.setPassword(expectedPassword);
        String actualPassword = amanda.getPassword();
        // Then
        Assert.assertEquals(expectedPassword, actualPassword);
    }
    @Test
    public void setTransactionHistoryTest() {
        // Given
        List<String> expectedTH = new ArrayList<String>(Collections.singleton("Test"));
        Users peter = new Users();
        // When
        peter.setTransactionHistory(expectedTH);
        List<String> actualTH = peter.getTransactionHistory();
        // Then
        Assert.assertEquals(expectedTH, actualTH);
    }
}
