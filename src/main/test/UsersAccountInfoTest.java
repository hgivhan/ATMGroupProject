import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;

public class UsersAccountInfoTest {
    private String name;
    private Integer debitCardNumber;
    private Integer pinNumber;
    private java.util.List<String> transactionHistory;
    private java.util.LinkedHashMap<String, Users> listOfUsers;

    @Test
    public void accountInfoConstructorTest(){
        // Given
        String expectedName = "Amanda Williams";
        Integer expectedCardNumber = 9876;
        Integer expectedPin = 1234;
        UsersAccountInfo amandasInfo = new UsersAccountInfo(expectedName, expectedCardNumber, expectedPin);

        // When
        String actualName = amandasInfo.getName();
        Integer actualCardNumber = amandasInfo.getCardNumber();
        Integer actualPin = amandasInfo.getPin();

        // Then
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedCardNumber, actualCardNumber);
        Assert.assertEquals(expectedPin, actualPin);
    }

    @Test
    public void createNewUserTest(){
        // Given

        // When
        // Then
    }

    @Test
    public void changePINTest(){
        // Given
        // When
        // Then
    }
    @Test
    public void deleteUserTest(){
        // Given
        UsersAccountInfo hillarysInfo = new UsersAccountInfo("Hillary", 2468, 9753);
        Object[] preDeleteExpected = new Object[]{hillarysInfo};
        Object[] postDeleteExpected = new Object[]{};

        // When
        Object preDeleteActual = hillarysInfo.getUserInfo();
        hillarysInfo.deleteUser();
        Object[] postDeleteActual = hillarysInfo.getUserInfo();

        // Then
        Assert.assertEquals(preDeleteExpected, preDeleteActual);
        Assert.assertEquals(postDeleteExpected, postDeleteActual);
    }

    @Test
    public void getUserInfoTest(){
        // Given
        // When
        // Then
    }

}
