import atm.Atm;

public interface AtmDepartment {
    void addAtm(Atm atm);

    void deleteAtm(Atm atm);

    int acquireBalance();

    void restore();
}
