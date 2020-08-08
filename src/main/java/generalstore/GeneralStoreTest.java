package generalstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GeneralStoreTest {

    private BankAccount bankAccount;
    private GeneralStore store;
    private Product chips;
    private Product drink;
    private Product hotDog;
    private Product burger;

    @Before
    public void Setup() {
        store = new GeneralStore();
        bankAccount = store.getBankAccount();
        chips = new Chips();
        drink = new Drink();
        hotDog = new HotDog();
        burger = new Burger();
    }

    @Test
    public void makeInventory() {
        Assert.assertNotNull(store.getProducts());
    }

    @Test
    public void makeBankAccount() {
        Assert.assertNotNull(bankAccount);
    }

    @Test
    public void getBankMoney() {
        assertEquals(0, bankAccount.getMoney(), 20);
    }

    @Test
    public void addProduct() {
        store.addProduct(chips);
        assertEquals(1, store.getProducts().size());
    }

    @Test
    public void getChipsPrice() {
        assertEquals(1.0, chips.getPrice(), 0);
    }

    @Test
    public void getDrinkPrice() {
        assertEquals(1.50, drink.getPrice(), 0);
    }

    @Test
    public void getHotDogPrice() {
        assertEquals(2.0, hotDog.getPrice(), 0);
    }

    @Test
    public void getBurgerPrice() {
        assertEquals(3.0, burger.getPrice(), 0);
    }

    @Test
    public void sellAnItemAndCheckMoneyIsDeducted() {
        double money = bankAccount.getMoney();
        store.addProduct(chips);
        store.sellProduct(chips);
        assertEquals(money + 1.0, bankAccount.getMoney(), 0);
    }

    @Test
    public void sellAnItemAndCheckProductRemoved() {
        store.addProduct(drink);
        int numProducts = store.getProducts().size();
        store.sellProduct(drink);
        assertEquals(numProducts - 1, store.getProducts().size());
    }

    @Test
    public void outOfStock() {
        double money = bankAccount.getMoney();
        store.sellProduct(chips);
        //money should not change, line should be printed
        assertEquals(money, bankAccount.getMoney(), 0);
    }

    @Test
    public void twoOfSameProduct() {
        store.addProduct(chips);
        store.addProduct(chips);
        store.sellProduct(chips);
        assertEquals(1, store.getProducts().size());
        assertTrue(store.getProducts().contains(chips));
    }

    @Test
    public void getNumberProductsByType() {
        store.addProduct(chips);
        store.addProduct(chips);
        store.addProduct(drink);
        store.addProduct(drink);
        store.addProduct(drink);
        assertEquals(2, store.numberOfType(chips));
        assertEquals(3, store.numberOfType(drink));
    }

    @Test
    public void makeProducts() {
        List<Product> products = new ArrayList<>();
        products.add(chips);
        products.add(drink);
        store.setProducts(products);
        assertEquals(products, store.getProducts());
    }
}