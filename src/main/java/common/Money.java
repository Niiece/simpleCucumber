package common;

public class Money {
    private int dollars;
    private int cents;

    public Money(){}

    public Money(int dollars, int cents){
        this.dollars = dollars;
        this.cents = cents;
    }

    public void add(Money money){
        dollars += money.dollars;
        cents += money.cents;
        if (this.cents >= 100){
            add(new Money(1, cents - 100));
        }
    }

    public void take(Money money){
        if(this.dollars - money.dollars < 0){
            throw new RuntimeException("requested amount more than available");
        }
        this.dollars -= money.dollars;

        if(this.cents - money.cents < 0){
            take(new Money(1, 0));
            this.cents = 100 + this.cents - money.cents;
        }

    }

    public Money getBalance(){
        return this;
    }

    public void currentBalance(){
        System.out.println(String.format("current ballance is: %d.%d", this.dollars, this.cents));
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(this.getClass() != obj.getClass()) return false;

        Money those = (Money) obj;

        return this.dollars == those.dollars &&
                this.cents == those.cents;

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31* result + this.hashCode();
        return result;
    }
}
