package cartridge;

import exception.NotEnoughBanknotesException;

/**
 * @author V. Zinchenko
 */
public class CashCartridge implements Cartridge, Comparable<CashCartridge> {
    private Banknote banknote;
    private int amount;

    private static final String NOT_ENOUGH_MSG = "Not enough %d banknotes";

    public CashCartridge(Banknote banknote, int amount) {
        this.banknote = banknote;
        this.amount = amount;
    }

    public Banknote getBanknote() {
        return banknote;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(CashCartridge other) {
        if (this.banknote.getValue() < other.getBanknote().getValue()) return 1;
        else return (this.banknote.getValue() > other.getBanknote().getValue()) ? -1 : 0;
    }

    @Override
    public String toString() {
        return "{" +
                "banknote=" + banknote.getValue() +
                ", amount=" + amount +
                '}';
    }

    /**
     * @param amount of banknotes
     */
    @Override
    public void fill(int amount) {
        this.amount += amount;
    }

    /**
     * @param amount of banknotes
     * @throws
     */
    @Override
    public void retrieve(int amount) {
        if (amount > this.amount) {
            throw new NotEnoughBanknotesException(String.format(NOT_ENOUGH_MSG, banknote.getValue()));
        }
        this.amount -= amount;
    }
}
