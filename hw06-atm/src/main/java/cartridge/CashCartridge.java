package cartridge;

import exception.NotEnoughBanknotesException;

import java.util.UUID;

/**
 * @author V. Zinchenko
 */
public class CashCartridge implements Cartridge {
    private static final String NOT_ENOUGH_MSG = "Not enough %d banknotes";
    private final Banknote banknote;
    private int amount;
    private String uuid;

    public CashCartridge(Banknote banknote, int amount) {
        this.banknote = banknote;
        this.amount = amount;
        this.uuid = UUID.randomUUID().toString();
    }

    public Banknote getBanknote() {
        return banknote;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Cartridge other) {
        if (this.banknote.getValue() < other.getBanknote().getValue()) return 1;
        else return (this.banknote.getValue() > other.getBanknote().getValue()) ? -1 : 0;
    }

    @Override
    public void fill(int amount) {
        this.amount += amount;
    }

    @Override
    public void retrieve(int amount) {
        if (amount > this.amount) {
            throw new NotEnoughBanknotesException(String.format(NOT_ENOUGH_MSG, banknote.getValue()));
        }
        this.amount -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CashCartridge that = (CashCartridge) o;

        if (banknote != that.banknote) return false;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        int result = banknote.hashCode();
        result = 31 * result + uuid.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "banknote=" + banknote.getValue() +
                ", amount=" + amount +
                '}';
    }

}
