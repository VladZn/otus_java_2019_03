/**
 * @author V. Zinchenko
 */
public class Cassette {
    private Banknote banknote;
    private int amount;

    public Cassette(Banknote banknote, int amount) {
        this.banknote = banknote;
        this.amount = amount;
    }

    public Banknote getBanknote() {
        return banknote;
    }

    public int getAmount() {
        return amount;
    }
}
