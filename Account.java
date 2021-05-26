public class Account extends Bank {
    private String name;
    private double balance;
    private int card;
    private String exp;
    private String pass;

    Account() {
        super();
        this.name = "";
        this.balance = 40;
        this.card = 0;
        this.exp = "";
        this.exp = "";
        this.pass = "";
    }

    Account(String name, double balance, int card, String exp, String pass) {
        this.name = name;
        this.balance = balance;
        this.card = card;
        this.exp = exp;
        this.pass = pass;

    }

}
