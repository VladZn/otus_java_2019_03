import java.math.BigDecimal;

/**
 * @author V. Zinchenko
 */
public interface AtmService {

    boolean loadCashCartridge(CashCartridge cartridge);

    boolean removeCartridge(Banknote banknote);

    BigDecimal checkBalance();

    void withdraw(int sum);

    void deposit(Banknote banknote, int amount);
}
