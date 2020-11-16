import org.junit.Assert;
import org.junit.Test;

public class AccountsTest {
    @Test
    public void testCheckingAccount() {
        Users expectedCurrentActiveUser = new Users("Amanda", "ILoveJUnitTesting");
        Double expectedBalance = 1213.0;
        expectedCurrentActiveUser.setChecking(new Checking(0));
        expectedCurrentActiveUser.getChecking().setBalance(expectedBalance);
        Double actualBal = expectedCurrentActiveUser.getChecking().getBalance();
        Assert.assertEquals(expectedBalance, actualBal);
    }

    @Test
    public void testSavingsAccount() {
        Users expectedCurrentActiveUser = new Users("Peter", "Kutchen3");
        Double expectedBalance = 10000.00;
        expectedCurrentActiveUser.setSavings(new Savings(0));
        expectedCurrentActiveUser.getSavings().setBalance(expectedBalance);
        Double actualBal = expectedCurrentActiveUser.getSavings().getBalance();
        Assert.assertEquals(expectedBalance, actualBal);
    }

    @Test
    public void testInvestmentAccount() {
        Users expectedCurrentActiveUser = new Users("Christian", "YouTasteLikeChicken");
        Double expectedBalance = 450.0;
        expectedCurrentActiveUser.setInvestment(new Investment(0));
        expectedCurrentActiveUser.getInvestment().setBalance(expectedBalance);
        Double actualBal = expectedCurrentActiveUser.getInvestment().getBalance();
        Assert.assertEquals(expectedBalance, actualBal);
    }

    @Test
    public void testAccountBalance() {
        Accounts newAccount = new Accounts(0);
        Double expectedBal = 11.40;
        newAccount.setBalance(expectedBal);
        Double actualBal = newAccount.getBalance();
        Assert.assertEquals(expectedBal, actualBal);
    }

    @Test
    public void testCheckingBalance() {
        Checking newAccount = new Checking(0);
        Double expectedBal = 450.0;
        newAccount.setBalance(expectedBal);
        Double actualBal = newAccount.getBalance();
        Assert.assertEquals(expectedBal, actualBal);
    }

    @Test
    public void testSavingsBalance() {
        Savings newAccount = new Savings(0);
        Double expectedBal = 2040.00;
        newAccount.setBalance(expectedBal);
        Double actualBal = newAccount.getBalance();
        Assert.assertEquals(expectedBal, actualBal);
    }

    @Test
    public void testInvestmentBalance() {
        Investment newAccount = new Investment(0);
        Double expectedBal = 230.0;
        newAccount.setBalance(expectedBal);
        Double actualBal = newAccount.getBalance();
        Assert.assertEquals(expectedBal, actualBal);
    }
}
