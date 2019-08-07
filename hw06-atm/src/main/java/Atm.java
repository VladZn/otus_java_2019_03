/**
 * @author V. Zinchenko
 */
public interface Atm {

    boolean loadCashCartridge(CashCartridge cartridge);

    boolean removeCartridge(CashCartridge cartridge);

    int checkBalance();

    void withdraw(int sum);

    void deposit(Banknote banknote, int amount);
}
