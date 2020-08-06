package generalstore;

import java.util.ArrayList;

public class GeneralStore {

    ArrayList<Product> products = new ArrayList<>();
    BankAccount bankAccount = new BankAccount();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void sellProduct(Product product) {
        double moneyMade = product.getPrice();
        bankAccount.setMoney(bankAccount.getMoney() + moneyMade);
    }
}