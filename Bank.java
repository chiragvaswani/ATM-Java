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
}
