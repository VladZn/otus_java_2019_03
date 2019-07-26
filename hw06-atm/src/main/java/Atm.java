import java.math.BigDecimal;
import java.util.List;

/**
 * @author V. Zinchenko
 */
public class Atm implements Transaction {
    private List<Cassette> cassettes;
    private BigDecimal balance = BigDecimal.ZERO;

    public Atm(List<Cassette> cassettes) {
        this.cassettes = cassettes;
        recountBalance();
    }

    private void recountBalance() {
        balance = BigDecimal.valueOf(cassettes.stream()
                .mapToInt(cassette -> cassette.getBanknote().getValue() * cassette.getAmount())
                .sum());
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void loadCassette(Cassette cassette) {
        cassettes.add(cassette);
        recountBalance();
    }

    @Override
    public void execute(Operation operation) {
        operation.run();
    }

//    public void removeCassette(Cassette cassette) {
//        cassettes.remove()
//    }
}
