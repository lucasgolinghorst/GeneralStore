package generalstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneralStoreTest {

    private BankAccount bankAccount;
    private GeneralStore store;
    private Product chips;
    private Product drink;

    @Before
    public void Setup() {
        store = new GeneralStore();
        bankAccount = store.getBankAccount();
        chips = new Chips();
        drink = new Drink();
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
        store.addProduct(new Chips());
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
        Product hotDog = new HotDog();
        assertEquals(2.0, hotDog.getPrice(), 0);
    }

    @Test
    public void getBurgerPrice() {
        Product burger = new Burger();
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
}