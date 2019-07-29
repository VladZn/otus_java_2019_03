/**
 * @author V. Zinchenko
 */
public class CashCartridge implements Comparable<CashCartridge> {
    private Banknote banknote;
    private int amount;

    public CashCartridge(Banknote banknote, int amount) {
        this.banknote = banknote;
        this.amount = amount;
    }

    public Banknote getBanknote() {
        return banknote;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(CashCartridge other) {
        if (this.banknote.getValue() > other.getBanknote().getValue()) return 1;
        else return (this.banknote.getValue() < other.getBanknote().getValue()) ? -1 : 0;
    }
}
