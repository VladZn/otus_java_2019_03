import atm.Atm;
import atm.CashMachine;

import java.util.Collections;

public class AtmDepartmentDemo {
    public static void main(String[] args) {
        Atm atm = new CashMachine(Collections.emptySet());
        System.out.println(atm.checkBalance());
    }
}
