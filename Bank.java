import java.text.SimpleDateFormat;
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
                if (cardExp(acc.getExpDate())) {
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

    public Account getAccountA(int card) {
        Account acc = null;
        for (Account account : A)
            if (account.getCardNum() == card)
                return account;
        return acc;
    }

    public Account getAccountB(int card) {
        Account acc = null;
        for (Account account : B)
            if (account.getCardNum() == card)
                return account;
        return acc;
    }

    public boolean checkPasswordA(Account acc, String passcode) {
        return acc.getPassword().equals(passcode);
    }

    public boolean checkPasswordB(Account acc, String passcode) {
        return acc.getPassword().equals(passcode);
    }

    public static boolean cardExp(String month) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String today = date.format(new Date());
        return (month.compareTo(today) > 0);

    }

    public boolean authoriseCardA(String passcode) {
        boolean isMatch = false;
        for (Account acc : A) {
            if (passcode.compareTo(acc.getPassword()) > 0) {
                isMatch = true;
                break;
            }
        }
        return isMatch;
    }

    public boolean authoriseCardB(String passcode) {
        boolean isMatch = false;
        for (Account acc : B) {
            if (passcode.compareTo(acc.getPassword()) > 0) {
                isMatch = true;
                break;
            }
        }
        return isMatch;
    }

    public double withdrawAmount(Account acc, double amount) {
        double resBalance = 0;
        if (amount <= acc.getBalance()) {
            System.out.println(acc.getBalance());
            resBalance = acc.getBalance() - amount;
            acc.setBalance(resBalance);
            System.out.println("Remaining balance: " + acc.getBalance()); // This could be asynchronous hence using the
                                                                          // getter method instead of the resBalance
                                                                          // variable
            return acc.getBalance();
        } else
            System.out.println("Withdrawal amount too high.");
        return resBalance;
    }

    public double depositAmount(Account acc, double amount) {
        System.out.println(acc.getBalance());
        acc.setBalance(acc.getBalance() + amount);
        System.out.println("Updated balance: " + acc.getBalance());
        return acc.getBalance();
    }

}
