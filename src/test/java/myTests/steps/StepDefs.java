package myTests.steps;

import common.Money;
import common.MoneyTransformer;
import common.ObjectHelper;
import common.Teller;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class StepDefs {
    private ObjectHelper helper;

    public StepDefs() {
        helper = new ObjectHelper();
    }

    @Given("^user ATM account with \\$(\\d+\\.?\\d{0,2})\\s?$")
    public void userATMAccountWith$(@Transform(MoneyTransformer.class) Money money) throws Throwable {
        helper.getMyAccount().deposit(money);
    }

    @When("^user sends \\$(\\d+\\.?\\d{0,2})\\s?$")
    public void userSends$(@Transform(MoneyTransformer.class) Money money) throws Throwable {
        Teller teller = new Teller(helper.getCashSlot());
        teller.withdrawFrom(helper.getMyAccount(), money);
        teller.withdrawTo(money);
    }

    @Then("^user will have \\$(\\d+\\.?\\d{0,2}) on account$")
    public void userWillHave$OnAccount(@Transform(MoneyTransformer.class) Money money) throws Throwable {
        helper.getMyAccount().availableBalance();
        assertTrue(helper.getMyAccount().getBalance().equals(money));
        helper.getCashSlot().getContent().currentBalance();
    }
}
