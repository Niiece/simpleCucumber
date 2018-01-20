package common;

public class Account {
    private Money balance = new Money();

    public void deposit(Money money){
        balance.add(money);
    }

    public void take(Money money){
        balance.take(money);
    }

    public void availableBalance(){
        balance.currentBalance();
    }

    public Money getBalance(){
        return balance;
    }


}
