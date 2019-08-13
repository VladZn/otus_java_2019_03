package cartridge;

import exception.NotEnoughBanknotesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author V. Zinchenko
 */
class CashCartridgeTest {
    private Cartridge cartridge;

    @BeforeEach
    public void setUp() {
        cartridge = new CashCartridge(Banknote.FIVE_HUNDRED, 10);
    }

    @Test
    void fill() {
        cartridge.fill(10);
        assertEquals(20, cartridge.getAmount());
    }

    @Test
    void retrieve() {
        cartridge.retrieve(7);
        assertEquals(3, cartridge.getAmount());
    }

    @Test
    void retrieveExpectedNotEnoughBanknotesException() {
        assertThrows(NotEnoughBanknotesException.class, () -> cartridge.retrieve(20));
    }
}