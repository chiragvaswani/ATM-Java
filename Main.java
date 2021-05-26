import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main() {
        Bank bank = new Bank();
        Account a1 = new Account("Yehia", 40, 22, "2017-08-16", "1422");
        Account a2 = new Account("Moe", 40, 11, "2011-08-16", "1322");
        Account b1 = new Account("Yehia", 40, 23, "2017-08-16", "5522");
        Account b2 = new Account("Johnny", 40, 21, "2020-08-16", "1412");
        Account b3 = new Account("Yehia", 40, 31, "2014-08-16", "1722");
        bank.addBankA(a1);
        bank.addBankA(a2);
        bank.addBankB(b1);
        bank.addBankB(b2);
        bank.addBankB(b3);
        bank.showAccounts();
        System.out.println("\tATM System\nPlease enter your choice: \n\tBank A\nA1.Withdraw\n\tBank B\nB1.Withdraw");
        String choice = sc.nextLine();
        executeChoice(choice, bank);
    }

    public static void executeChoice(String choice, Bank bank) {
        if (choice.equals("A1") || choice.equals("B1")) {
            validateAndWithdraw(choice, bank);
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void validateAndWithdraw(String choice, Bank bank) {
        if (choice.equals("A1")) {
            // Get the valid card number
            boolean valid;
            do {
                System.out.println("Enter card number: ");
                int card = sc.nextInt();
                valid = bank.authoriseATMA(card);
                if (!valid)
                    System.out.println("Please try again.");
            } while (!valid);
        } else {

        }
    }
}