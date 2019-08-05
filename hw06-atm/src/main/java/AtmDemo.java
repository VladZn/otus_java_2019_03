import java.util.Set;
import java.util.TreeSet;

/**
 * @author V. Zinchenko
 */
public class AtmDemo {

    public static void main(String[] args) {

        Set<CashCartridge> cashCartridges = new TreeSet<>();
        cashCartridges.add(new CashCartridge(Banknote.ONE_HUNDRED, 100));
        cashCartridges.add(new CashCartridge(Banknote.ONE_THOUSAND, 100));
        cashCartridges.add(new CashCartridge(Banknote.FIVE_THOUSAND, 100));

        Atm atm = new Atm(cashCartridges);
        System.out.println("Balance: " + atm.checkBalance());

        System.out.println("Deposit 1000");
        atm.deposit(Banknote.ONE_THOUSAND, 1);
        System.out.println("Balance: " + atm.checkBalance());
        System.out.println("-----------------------------");

        System.out.println("Withdraw 7500");
        atm.withdraw(7500);
        System.out.println("Balance: " + atm.checkBalance());
        System.out.println("-----------------------------");

        CashCartridge cartridge = new CashCartridge(Banknote.FIVE_HUNDRED, 10);
        atm.loadCashCartridge(cartridge);
        System.out.println("Load a cash cartridge " + cartridge);
        System.out.println("Balance: " + atm.checkBalance());
        System.out.println("-----------------------------");

        System.out.println("Withdraw 1500");
        atm.withdraw(1500);
        System.out.println("Balance: " + atm.checkBalance());
        System.out.println("-----------------------------");

//        Deposit deposit = new Deposit(atm, Banknote.ONE_THOUSAND, 3);
////        deposit.run();
//        atm.execute(deposit);
    }
}
