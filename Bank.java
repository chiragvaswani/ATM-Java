import java.util.*;

public class Bank {
    private ArrayList<Account> A;
    private ArrayList<Account> B;

    public Bank() {
        A = new ArrayList<>();
        B = new ArrayList<>();
    }

    public void addBankA(Account account) {
        A.add(account);
    }

    public void addBankB(Account account) {
        B.add(account);
    }

    public void showAccounts() {
        System.out.println("Accounts in Bank A: ");
        for (Account account : A)
            System.out.println(account.toString());
        System.out.println("Accounts in Bank B: ");
        for (Account account : B)
            System.out.println(account.toString());
    }
}
