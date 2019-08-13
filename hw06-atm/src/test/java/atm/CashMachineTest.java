package atm;

import cartridge.Banknote;
import cartridge.Cartridge;
import cartridge.CashCartridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class CashMachineTest {
    private Atm atm;

    @BeforeEach
    void setUp() {
        Set<Cartridge> cashCartridges = new TreeSet<>();
        cashCartridges.add(new CashCartridge(Banknote.ONE_HUNDRED, 100));
        cashCartridges.add(new CashCartridge(Banknote.ONE_THOUSAND, 100));
        cashCartridges.add(new CashCartridge(Banknote.FIVE_THOUSAND, 100));

        atm = new CashMachine(cashCartridges);
    }

    @Test
    void checkBalance() {
        assertEquals(610_000, atm.checkBalance());
    }

    @Test
    void loadCashCartridge() {
        CashCartridge cartridge = new CashCartridge(Banknote.FIVE_HUNDRED, 10);
        atm.loadCashCartridge(cartridge);
        assertEquals(615_000, atm.checkBalance());
    }

    @Test
    void removeCartridge() {
        assertTrue(atm.removeCartridge(Banknote.ONE_HUNDRED));
        assertEquals(600_000, atm.checkBalance());
    }

    @Test
    void deposit() {
        atm.deposit(Banknote.ONE_THOUSAND, 1);
        assertEquals(611_000, atm.checkBalance());
    }

    @Test
    void withdraw() {
        atm.withdraw(7500);
        assertEquals(602_500, atm.checkBalance());
    }
}