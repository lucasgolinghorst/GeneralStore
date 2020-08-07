package generalstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneralStoreTest {

    private BankAccount bankAccount;
    private GeneralStore store;

    @Before
    public void Setup() {
        store = new GeneralStore();
        bankAccount = store.getBankAccount();
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
        BankAccount account = new BankAccount(5.0);
        assertEquals(5.0, account.getMoney(), 0);
    }

    @Test
    public void addProduct() {
        store.addProduct(new Product(""));
        assertEquals(1, store.getProducts().size());
    }

    @Test
    public void makeProductChips() {
        Product chips = new Product("chips");
        assertEquals("chips", chips.getType());
    }

    @Test
    public void makeProductDrink() {
        Product drink = new Product("drink");
        assertEquals("drink", drink.getType());
    }

    @Test
    public void getChipsPrice() {
        Product chip = new Product("chips");
        assertEquals(1.0, chip.getPrice(), 0);
    }

    @Test
    public void getDrinkPrice() {
        Product drink = new Product("drink");
        assertEquals(1.50, drink.getPrice(), 0);
    }

    @Test
    public void getHotDogPrice() {
        Product hotDog = new Product("hot dog");
        assertEquals(2.0, hotDog.getPrice(), 0);
    }

    @Test
    public void getBurgerPrice() {
        Product burger = new Product("burger");
        assertEquals(3.0, burger.getPrice(), 0);
    }

    @Test
    public void sellAnItemAndCheckMoneyIsDeducted() {
        double money = bankAccount.getMoney();
        Product chips = new Product("chips");
        store.addProduct(chips);
        store.sellProduct(chips);
        assertEquals(money + 1.0, bankAccount.getMoney(), 0);
    }

    @Test
    public void sellAnItemAndCheckProductRemoved() {
        Product drink = new Product("drink");
        store.addProduct(drink);
        int numProducts = store.getProducts().size();
        store.sellProduct(drink);
        assertEquals(numProducts - 1, store.getProducts().size());
    }

    @Test
    public void outOfStock() {
        double money = bankAccount.getMoney();
        Product chips = new Product("chips");
        store.sellProduct(chips);
        //money should not change, line should be printed
        assertEquals(money, bankAccount.getMoney(), 0);
    }

    @Test
    public void addNewProduct() {
        store.addProduct(new Product("chips"));
    }
}