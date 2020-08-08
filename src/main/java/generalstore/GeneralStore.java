package generalstore;

import java.util.ArrayList;
import java.util.List;

public class GeneralStore {

    List<Product> products;
    BankAccount bankAccount;

    public GeneralStore() {
        products = new ArrayList<>();
        bankAccount = new BankAccount();
    }

    public List<Product> getProducts() {
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

    public int numberOfType(Product product) {
        int count = 0;
        for (Product each : products) {
            if (each.equals(product)) {
                count++;
            }
        }
        return count;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}