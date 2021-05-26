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

    public boolean authoriseATMA(int card) {
        boolean cardExists = false;
        boolean isValid = false;
        for (Account acc : A) {
            if (card == acc.getCardNum()) {
                cardExists = true;
                if (cardExp(acc.getExp())) {
                    System.out.println("Card authorised.");
                    isValid = true;
                    break;
                }
                if (isValid == false) {
                    System.out.println("Card is expired");
                }
            }
        }
        if (cardExists == false)
            System.out.println("Card does not exist");
        ;
        System.out.println(cardExists && isValid);
        return (cardExists && isValid);
    }

    // Can use the same function for both banks by accpeting the bank as an argument
    public boolean authoriseATMB(int card) {
        boolean cardExists = false;
        boolean isValid = false;
        for (Account acc : B) {
            if (card == acc.getCardNum()) {
                cardExists = true;
                if (cardExp(acc.getExpDate())) {
                    System.out.println("Card authorised.");
                    isValid = true;
                    break;
                }
                if (isValid == false)
                    System.out.println("Card expired.");
            }
        }
        if (isValid == false)
            System.out.println("Card does not exist.");
        System.out.println(cardExists && isValid);
        return (cardExists && isValid);
    }
}
