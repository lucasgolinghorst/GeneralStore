package generalstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GeneralStoreTest {

    private List<Product> products;
    private BankAccount bankAccount;
    private GeneralStore store;

    @Before
    public void Setup() {
        store = new GeneralStore();
        products = store.getProducts();
        bankAccount = store.getBankAccount();
    }

    @Test
    public void makeInventory() {
        Assert.assertNotNull(products);
    }

    @Test
    public void makeBankAccount() {
        Assert.assertNotNull(bankAccount);
    }

    @Test
    public void getBankMoney() {
        BankAccount account = new BankAccount(5.0);
        Assert.assertEquals(5.0, account.getMoney(), 0);
    }

    @Test
    public void addProduct() {
        products.add(new Product(""));
        Assert.assertEquals(1, products.size());
    }

    @Test
    public void makeProductChips() {
        Product chips = new Product("chips");
        Assert.assertEquals("chips", chips.getType());
    }

    @Test
    public void makeProductDrink() {
        Product drink = new Product("drink");
        Assert.assertEquals("drink", drink.getType());
    }

    @Test
    public void getChipsPrice() {
        Product chip = new Product("chips");
        Assert.assertEquals(1.0, chip.getPrice(), 0);
    }

    @Test
    public void getDrinkPrice() {
        Product drink = new Product("drink");
        Assert.assertEquals(1.50, drink.getPrice(), 0);
    }

    @Test
    public void getHotDogPrice() {
        Product hotDog = new Product("hot dog");
        Assert.assertEquals(2.0, hotDog.getPrice(), 0);
    }

    @Test
    public void getBurgerPrice() {
        Product burger = new Product("burger");
        Assert.assertEquals(3.0, burger.getPrice(), 0);
    }

    @Test
    public void sellAnItemAndCheckMoneyIsDeducted() {
        double money = bankAccount.getMoney();
        Product chips = new Product("chips");
        store.sellProduct(chips);
        Assert.assertEquals(money + 1.0, bankAccount.getMoney(), 0);
    }
}