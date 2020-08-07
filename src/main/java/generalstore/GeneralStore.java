package generalstore;

import java.util.ArrayList;

public class GeneralStore {

    ArrayList<Product> products;
    BankAccount bankAccount;

    public GeneralStore() {
        products = new ArrayList<>();
        bankAccount = new BankAccount();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void sellProduct(Product product) {
        if (products.remove(product)) {
            double moneyMade = product.getPrice();
            bankAccount.setMoney(bankAccount.getMoney() + moneyMade);
        } else
            System.out.println("No such item in stock");
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}