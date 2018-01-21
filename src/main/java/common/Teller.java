package common;

public class Teller {

    private CashSlot drawTo;

    public Teller(CashSlot cashSlot){
        this.drawTo = cashSlot;
    }

    public void withdrawFrom(Account account, Money money){
        account.take(money);
    }

    public void withdrawTo(Money money){
        drawTo.deposit(money);
    }
}
