import org.junit.Assert;
import org.junit.Test;

public class UserManagerTest {
    @Test
    public void testAdd() {
        // given
        UserManager userManager = new UserManager();
        Users userToBeCreated = new Users(null, null);
        boolean hasUser = userManager.contains(userToBeCreated);
        Assert.assertFalse(hasUser);
        // when
        userManager.addUser(userToBeCreated);
        // then
        Assert.assertTrue(userManager.contains(userToBeCreated));
    }

    @Test
    public void testRemove() {
        // given
        UserManager userManager = new UserManager();
        Users userToBeCreated = new Users(null, null);
        userManager.addUser(userToBeCreated);
        boolean hasUser = userManager.contains(userToBeCreated);
        Assert.assertTrue(hasUser);

        // when
        userManager.deleteUser(userToBeCreated);

        // then
        Assert.assertFalse(userManager.contains(userToBeCreated));
    }
}
