package generalstore;

public class BankAccount {

    private double money;

    public BankAccount(double startingMoney) {
        money = startingMoney;
    }

    public BankAccount() {
        money = 20.00;
    }

    public double getMoney() {
        return money;
    }
}
