/**
 * @author V. Zinchenko
 */
public class Deposit implements Operation {
    private Banknote banknote;
    private int amount;

    public Deposit(Banknote banknote, int amount) {
        this.banknote = banknote;
        this.amount = amount;
    }

    @Override
    public void run() {

    }

}
