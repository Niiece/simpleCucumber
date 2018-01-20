package myTests.steps;

import common.Account;
import common.Money;
import common.MoneyTransformer;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class StepDefs {
    private Account account;

    @Given("^user ATM account with \\$(\\d+\\.?\\d{0,2})\\s?$")
    public void userATMAccountWith$(@Transform(MoneyTransformer.class)Money money) throws Throwable {
        account = new Account();
        account.deposit(money);
    }


    @When("^user sends \\$(\\d+\\.?\\d{0,2})\\s?$")
    public void userSends$(@Transform(MoneyTransformer.class)Money money) throws Throwable {
        account.take(money);
    }

    @Then("^user will have \\$(\\d+\\.?\\d{0,2}) on account$")
    public void userWillHave$OnAccount(@Transform(MoneyTransformer.class)Money money) throws Throwable {
        account.availableBalance();
        assertTrue(account.getBalance().equals(money));
    }
}
