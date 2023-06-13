package tests.entities;


import entities.Account;
import org.junit.Assert;
import org.junit.Test;
import tests.factory.AccountFactory;

public class AccountTests {

    @Test
    public void despositShouldIncreaseBalanceWhenPoositiveAmount(){
        double amount = 400.0;
        double expectedValue = 392.0;

        Account acc = AccountFactory.createEmptyAccount();

        acc.deposit(amount);

        Assert.assertEquals(expectedValue,acc.getBalance(), 0.01);
    }

    @Test
    public void despositShouldDoNothingWhenNegativeAmount(){
        double amount = -200.0;
        double expectedValue = 100.0;

        Account acc = AccountFactory.createAccount(100.0);

        acc.deposit(amount);

        Assert.assertEquals(expectedValue,acc.getBalance(), 0.01);
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenPoositiveAmount(){
        double amount = 200.0;
        double expectedValue = 100.0;

        Account acc = AccountFactory.createAccount(300.0);

        acc.withdraw(amount);

        Assert.assertEquals(expectedValue,acc.getBalance(), 0.01);
    }

    @Test
    public void withdrawShouldThrowExceptionWhenInsuffucientBallance(){
        double initialValue = 800.0;
        double expectedValue = initialValue;

        Assert.assertThrows(IllegalArgumentException.class, ()->{
            Account acc = AccountFactory.createAccount(initialValue);

            acc.withdraw(1000.00);
        });
        Assert.assertTrue(initialValue == expectedValue);
    }

    @Test
    public void fullWithdrawShouldClearBalance(){
        double expectedValue = 0.0;
        Account acc = AccountFactory.createAccount(800.0);

        double saque = acc.fullWithdraw();

        Assert.assertTrue(800.00==saque);
        Assert.assertEquals(expectedValue, acc.getBalance(), 0.01);
    }
}
