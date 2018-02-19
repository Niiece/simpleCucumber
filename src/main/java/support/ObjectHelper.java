package support;

import common.Account;
import common.CashSlot;

public class ObjectHelper {
    private Account myAccount;
    private CashSlot cashSlot;

    public Account getMyAccount() {
        if(myAccount == null){
            myAccount = new Account();
        }
        return myAccount;
    }

    public CashSlot getCashSlot() {
        if(cashSlot == null){
            cashSlot = new CashSlot();
        }
        return cashSlot;
    }
}
