package cartridge;

public interface Cartridge {

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
