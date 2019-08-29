package atm;

import cartridge.Banknote;
import cartridge.Cartridge;
import cartridge.CashCartridge;
import exception.CartridgeNotFoundException;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author V. Zinchenko
 */
public class CashMachine implements Atm {
    private static final String NOT_FOUND_MSG = "Could not find any cartridge for %d banknotes";
    private final Set<Cartridge> cashCartridges = new TreeSet<>();
    private int balance;

    public CashMachine(Set<Cartridge> cartridges) {
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
    public boolean loadCashCartridge(Cartridge cartridge) {
        return cashCartridges.add(cartridge);
    }

    @Override
    public boolean removeCartridge(Banknote banknote) {
        return cashCartridges.removeIf(cartridge -> cartridge.getBanknote().equals(banknote));
    }

    @Override
    public void deposit(Banknote banknote, int amount) {
        Cartridge cashCartridge = getCartridgeByBanknote(banknote);
        cashCartridge.fill(amount);
    }

    private Cartridge getCartridgeByBanknote(Banknote banknote) {
        return cashCartridges.stream()
                .filter(cst -> cst.getBanknote().equals(banknote))
                .findAny()
                .orElseThrow(() -> new CartridgeNotFoundException(String.format(NOT_FOUND_MSG, banknote)));
    }

    @Override
    public void withdraw(int sum) {
        int remainder = sum;
        int withdraw = 0;
        for (Cartridge cashCartridge : cashCartridges) {
            if ((withdraw = remainder / cashCartridge.getBanknote().getValue()) > 0) {
                System.out.println("remainder = " + remainder);
                System.out.printf("dispensing %dx%d note \n", withdraw, cashCartridge.getBanknote().getValue());
                cashCartridge.retrieve(withdraw);
                remainder = remainder - cashCartridge.getBanknote().getValue() * withdraw;
            }
        }
    }

//    @Override
//    public void execute(Operation operation) {
//        operation.run();
//    }

}
