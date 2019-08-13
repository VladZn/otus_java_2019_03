import atm.Atm;
import atm.CashMachine;
import cartridge.Banknote;
import cartridge.Cartridge;
import cartridge.CashCartridge;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author V. Zinchenko
 */
public class AtmDemo {

    public static void main(String[] args) {

        Set<Cartridge> cashCartridges = new TreeSet<>();
        cashCartridges.add(new CashCartridge(Banknote.ONE_HUNDRED, 100));
        cashCartridges.add(new CashCartridge(Banknote.ONE_THOUSAND, 100));
        cashCartridges.add(new CashCartridge(Banknote.FIVE_THOUSAND, 100));

        Atm atm = new CashMachine(cashCartridges);
        System.out.println("Balance: " + atm.checkBalance());

        System.out.println("Deposit 1000");
        atm.deposit(Banknote.ONE_THOUSAND, 1);
        System.out.println("Balance: " + atm.checkBalance());
        System.out.println("-----------------------------");

        System.out.println("Withdraw 7500");
        atm.withdraw(7500);
        System.out.println("Balance: " + atm.checkBalance());
        System.out.println("-----------------------------");

        Cartridge cartridge = new CashCartridge(Banknote.FIVE_HUNDRED, 10);
        atm.loadCashCartridge(cartridge);
        System.out.println("Load a cash cartridge " + cartridge);
        System.out.println("Balance: " + atm.checkBalance());
        System.out.println("-----------------------------");

        System.out.println("Withdraw 1500");
        atm.withdraw(1500);
        System.out.println("Balance: " + atm.checkBalance());
        System.out.println("-----------------------------");

    }
}
