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

    public void sell(Product product) {
        bankAccount.setMoney(bankAccount.getMoney() + product.getPrice());
    }
}
