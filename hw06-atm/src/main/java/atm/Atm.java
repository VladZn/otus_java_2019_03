package atm;

import cartridge.Banknote;
import cartridge.Cartridge;
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
    boolean loadCashCartridge(Cartridge cartridge);

    /**
     * Remove a cash cartridge from an ATM
     *
     * @param banknote of a cartridge to remove
     * @return {@code true} if successful
     */
    boolean removeCartridge(Banknote banknote);

    /**
     * Check an ATM's balance (cash in all cartridges)
     * @return An ATM's balance of cash
     */
    int checkBalance();

    void withdraw(int sum);

    void deposit(Banknote banknote, int amount);
}
