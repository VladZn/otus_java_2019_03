import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * @author V. Zinchenko
 */
public class Atm implements Transaction {
    private final List<CashCartridge> cashCartridges;
    private BigDecimal balance = BigDecimal.ZERO;

    public Atm(List<CashCartridge> cashCartridges) {
        this.cashCartridges = cashCartridges;
        recountBalance();
    }

    private void recountBalance() {
        balance = BigDecimal.valueOf(cashCartridges.stream()
                .mapToInt(cashCartridge -> cashCartridge.getBanknote().getValue() * cashCartridge.getAmount())
                .sum());
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void loadCashCartridge(CashCartridge cashCartridge) {
        cashCartridges.add(cashCartridge);
        recountBalance();
    }

    public void deposit(Banknote banknote, int amount) {
        CashCartridge cashCartridge = getCassetteByBanknote(banknote);
        cashCartridge.setAmount(cashCartridge.getAmount() + amount);
        recountBalance();
    }

    private CashCartridge getCassetteByBanknote(Banknote banknote) {
        return cashCartridges.stream()
                .filter(cst -> cst.getBanknote().equals(banknote))
                .findAny()
                    .orElseGet(() -> new CashCartridge(banknote, 0));
//                .orElseThrow();
    }

    public void withdraw(int sum) {
        int remainder = sum;
        int withdraw = 0;
        cashCartridges.sort(Collections.reverseOrder());
        for (CashCartridge cashCartridge : cashCartridges) {
            if ((withdraw = remainder / cashCartridge.getBanknote().getValue()) > 0) {
                System.out.println("remainder = " + remainder);
                System.out.printf("dispensing %dx%d note \n", withdraw, cashCartridge.getBanknote().getValue());
                cashCartridge.setAmount(cashCartridge.getAmount() - withdraw);
                remainder = remainder - cashCartridge.getBanknote().getValue() * withdraw;
            }
        }
        recountBalance();
    }

    @Override
    public void execute(Operation operation) {
//        operation.run();
    }

//    public void removeCassette(Cassette cassette) {
//        cassettes.remove()
//    }
}
