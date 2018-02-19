package support;

import common.Money;
import cucumber.api.Transformer;

public class MoneyTransformer extends Transformer<Money> {
    private static final String AMOUNT_DELIMETER = "\\.";

    @Override
    public Money transform(String s) {
        String[] amountToParse;
        amountToParse = s.split(AMOUNT_DELIMETER);

        if (amountToParse.length > 2) {
            throw new RuntimeException("Incorrect amount");
        }

        int dollars = Integer.parseInt(amountToParse[0]);
        int cents = Integer.parseInt(amountToParse[1]);
        return new Money(dollars, cents);
    }
}
