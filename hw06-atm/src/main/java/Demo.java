import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author V. Zinchenko
 */
public class Demo {

    public static void main(String[] args) {

        List<Cassette> cassettes = new ArrayList<>();
        cassettes.add(new Cassette(Banknote.ONE_HUNDRED, 100));
        cassettes.add(new Cassette(Banknote.ONE_THOUSAND, 100));
        cassettes.add(new Cassette(Banknote.FIVE_THOUSAND, 100));

        Atm atm = new Atm(cassettes);
        System.out.println(atm.getBalance());
    }
}
