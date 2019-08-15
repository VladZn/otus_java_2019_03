package cartridge;

public interface Cartridge extends Comparable<Cartridge> {

    /**
     * Get amount of banknotes
     * @return amount of banknotes
     */
    int getAmount();

    /**
     * Get the banknote
     * @return the banknote
     */
    Banknote getBanknote();

    /**
     *
     * @param amount of banknotes
     */
    void fill(int amount);

    /**
     *
     * @param amount of banknotes
     * @throws
     */
    void retrieve(int amount);

}
