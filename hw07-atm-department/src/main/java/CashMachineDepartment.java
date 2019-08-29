import atm.Atm;

import java.util.HashSet;
import java.util.Set;

public class CashMachineDepartment implements AtmDepartment {
    private final Set<Atm> atms = new HashSet<>();

    @Override
    public void addAtm(Atm atm) {

    }

    @Override
    public void deleteAtm(Atm atm) {

    }

    @Override
    public int acquireBalance() {
        return 0;
    }

    @Override
    public void restore() {

    }
}
