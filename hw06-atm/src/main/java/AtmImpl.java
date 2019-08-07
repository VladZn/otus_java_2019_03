import java.util.Set;
import java.util.TreeSet;

/**
 * @author V. Zinchenko
 */
public class AtmImpl implements Atm {
    private final Set<CashCartridge> cashCartridges = new TreeSet<>();
    private int balance;

    public AtmImpl(Set<CashCartridge> cartridges) {
        cashCartridges.addAll(cartridges);
    }

    private void recalculateBalance() {
        balance = cashCartridges.stream()
                .mapToInt(cashCartridge -> cashCartridge.getBanknote().getValue() * cashCartridge.getAmount())
                .sum();
    }

    @Override
    public int checkBalance() {
        recalculateBalance();
        return balance;
    }

    @Override
    public boolean loadCashCartridge(CashCartridge cartridge) {
        return cashCartridges.add(cartridge);
    }

    @Override
    public boolean removeCartridge(CashCartridge cashCartridge) {
        return cashCartridges.remove(cashCartridge);
    }

    @Override
    public void deposit(Banknote banknote, int amount) {
        CashCartridge cashCartridge = getCartridgeByBanknote(banknote);
        cashCartridge.setAmount(cashCartridge.getAmount() + amount);
    }

    private CashCartridge getCartridgeByBanknote(Banknote banknote) {
        return cashCartridges.stream()
                .filter(cst -> cst.getBanknote().equals(banknote))
                .findAny()
                .orElseGet(() -> new CashCartridge(banknote, 0));
//                .orElseThrow();
    }

    @Override
    public void withdraw(int sum) {
        int remainder = sum;
        int withdraw = 0;
        for (CashCartridge cashCartridge : cashCartridges) {
            if ((withdraw = remainder / cashCartridge.getBanknote().getValue()) > 0) {
                System.out.println("remainder = " + remainder);
                System.out.printf("dispensing %dx%d note \n", withdraw, cashCartridge.getBanknote().getValue());
                cashCartridge.setAmount(cashCartridge.getAmount() - withdraw);
                remainder = remainder - cashCartridge.getBanknote().getValue() * withdraw;
            }
        }
    }

//    @Override
//    public void execute(Operation operation) {
//        operation.run();
//    }

}
