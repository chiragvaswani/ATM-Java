import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Bank bank = new Bank();
        Account a1 = new Account("Yehia", 40, 22, "2021-08-16", "1422");
        Account a2 = new Account("Moe", 40, 11, "2011-08-16", "1322");
        Account b1 = new Account("Yehia", 40, 23, "2021-08-16", "5522");
        Account b2 = new Account("Johnny", 40, 21, "2020-08-16", "1412");
        Account b3 = new Account("Yehia", 40, 31, "2014-08-16", "1722");
        bank.addBankA(a1);
        bank.addBankA(a2);
        bank.addBankB(b1);
        bank.addBankB(b2);
        bank.addBankB(b3);
        bank.showAccounts();
        showMenu(bank);
    }

    public static void showMenu(Bank bank) {
        System.out.println(
                "\tATM System\nPlease enter your choice: \n\tBank A\nA1.Withdraw\nA2.Deposit\nA3.View Balance\n\tBank B\nB1.Withdraw\nB2.Deposit\nB3.View Balance");
        String choice = sc.nextLine();
        executeChoice(choice, bank);
    }

    public static void executeChoice(String choice, Bank bank) {
        if (choice.equals("A1") || choice.equals("B1")) {
            Account acc = validateCard(choice, bank);
            if (acc != null) {
                System.out.println("Well now you're validated!");
                System.out.println("Enter amount: ");
                double amount = sc.nextDouble();
                bank.withdrawAmount(acc, amount);

            } else {
                System.out.println("Error in processing the card. Please ensure your credentials are correct.");
            }
        } else if (choice.equals("A2") || choice.equals("B2")) {
            Account acc = validateCard(choice, bank);
            if (acc != null) {
                System.out.println("Enter the amount: ");
                double amount = sc.nextDouble();
                bank.depositAmount(acc, amount);
            } else {
                System.out.println("Error in processing the card. Please ensure your credentials are correct.");
            }
        } else if (choice.equals("A3") || choice.equals("B3")) {
            Account acc = validateCard(choice, bank);
            if (acc != null) {
                System.out.println("Current Balance: " + acc.getBalance());
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
        showMenu(bank);
    }

    public static Account validateCard(String choice, Bank bank) {
        Account acc = null;
        if (choice.equals("A1") || choice.equals("A2") || choice.equals("A3")) {
            // Get the valid card number
            acc = checkCardA(bank);
            String password;
            System.out.println(acc.toString());
            boolean pValid = false;
            do {
                System.out.println("Enter password");
                password = sc.next();
                if (bank.checkPasswordA(acc, password)) {
                    pValid = true;
                    break;
                } else {
                    System.out.println("Wrong password, try again");
                }
            } while (pValid == false);
            // Now, the card is validated.
        } else {
            acc = checkCardB(bank);
            String password;
            System.out.println(acc.toString());
            boolean pValid = false;
            do {
                System.out.println("Enter password");
                password = sc.next();
                if (bank.checkPasswordB(acc, password)) {
                    pValid = true;
                    break;
                } else {
                    System.out.println("Wrong password, try again");
                }
            } while (pValid == false);
        }
        // Here, the card will be validated if it exists.
        return acc;
    }

    public static Account checkCardA(Bank bank) {
        boolean valid;
        Account acc = null;
        do {
            System.out.println("Enter card number: ");
            int card = sc.nextInt();
            valid = bank.authoriseATMA(card);
            if (!valid)
                System.out.println("Please try again.");
            else
                acc = bank.getAccountA(card);
        } while (!valid);
        System.out.println("Card found.");
        return acc;
    }

    public static Account checkCardB(Bank bank) {
        boolean valid;
        Account acc = null;
        do {
            System.out.println("Enter card number: ");
            int card = sc.nextInt();
            valid = bank.authoriseATMB(card);
            if (!valid)
                System.out.println("Please try again.");
            else
                acc = bank.getAccountA(card);
        } while (!valid);
        System.out.println("Card found.");
        return acc;
    }

}