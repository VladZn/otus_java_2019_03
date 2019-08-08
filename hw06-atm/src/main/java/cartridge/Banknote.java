package cartridge;

/**
 * @author V. Zinchenko
 */
public enum Banknote {
    ONE_HUNDRED(100),
    TWO_HUNDRER(200),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1000),
    TWO_THOUSAND(2000),
    FIVE_THOUSAND(5000);

    private int value;

    Banknote(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
