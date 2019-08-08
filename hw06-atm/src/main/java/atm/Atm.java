package atm;

import cartridge.Banknote;
import cartridge.CashCartridge;

/**
 * @author V. Zinchenko
 */
public interface Atm {

    /**
     * Load a cash cartridge into an ATM
     *
     * @param cartridge to load.
     * @return {@code true} if successful.
     */
    boolean loadCashCartridge(CashCartridge cartridge);

    /**
     * Remove a cash cartridge from an ATM
     *
     * @param cartridge
     * @return {@code true} if successful
     */
    boolean removeCartridge(CashCartridge cartridge);

    /**
     * Check an ATM's balance (cash in all cartridges)
     * @return An ATM's balance of cash
     */
    int checkBalance();

    void withdraw(int sum);

    void deposit(Banknote banknote, int amount);
}
