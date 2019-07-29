import java.util.ArrayList;
import java.util.List;

/**
 * @author V. Zinchenko
 */
public class AtmDemo {

    public static void main(String[] args) {


        List<CashCartridge> cashCartridges = new ArrayList<>();
        cashCartridges.add(new CashCartridge(Banknote.ONE_HUNDRED, 100));
        cashCartridges.add(new CashCartridge(Banknote.ONE_THOUSAND, 100));
        cashCartridges.add(new CashCartridge(Banknote.FIVE_THOUSAND, 100));

        Atm atm = new Atm(cashCartridges);
//        atm.execute(new Deposit(Banknote.ONE_THOUSAND, 2).run());
        System.out.println("Balance: " + atm.getBalance());

        System.out.println("Deposit 1000");
        atm.deposit(Banknote.ONE_THOUSAND, 1);
        System.out.println("Balance: " + atm.getBalance());
        System.out.println("-----------------------------");

        System.out.println("Withdraw 7500");
        atm.withdraw(7500);
        System.out.println("Balance: " + atm.getBalance());
        System.out.println("-----------------------------");

        System.out.println("Load a cash cartridge");
        atm.loadCashCartridge(new CashCartridge(Banknote.FIVE_HUNDRED, 10));
        System.out.println("Balance: " + atm.getBalance());
        System.out.println("-----------------------------");

        System.out.println("Withdraw 1500");
        atm.withdraw(1500);
        System.out.println("Balance: " + atm.getBalance());
        System.out.println("-----------------------------");
    }
}
