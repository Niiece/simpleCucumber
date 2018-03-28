package myTests.steps;

import common.Money;
import common.Teller;
import cucumber.api.Delimiter;
import cucumber.api.Format;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.MoneyTransformer;
import support.ObjectHelper;
import support.TheEnumClass;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Given("^sout delimited list '(.+)'$")
    public void delimitedString(@Delimiter(" > ")List<String> list){
        list.stream().forEach(System.out::println);
        IntStream.range(0, 6).boxed().filter(e -> e < 3).collect(Collectors.toList());
    }

    @Then("^get (selected|unselected) state from enum$")
    public void getEnumState(TheEnumClass state){

        System.out.println(state.getPhrase() + " : " + state.isTrue());
    }

    class DateRanges{
        private final String currentDate;

        public DateRanges(String date){
            this.currentDate = date;
        }
    }
    @Then("^check date (.+)$")
    public void checkDate(@Format("yyyy-MM-dd") Calendar date){
        System.out.println(date.get(Calendar.YEAR));
        System.out.println(date.get(Calendar.MONTH));
        System.out.println(date.getTime());

    }

}
