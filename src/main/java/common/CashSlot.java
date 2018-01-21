package common;

public class CashSlot {
    private Money content = new Money();

    public Money getContent() {
        return content;
    }

    public void deposit(Money money){
        content.add(money);
    }
}
