package menu;

import cart.Cart;
import item_generator.RandomItemGeneratorImpl;
import menu.actions.*;
import shop.Shop;

public class ShopController extends MenuHandler {

    private final Shop shop = new Shop(new RandomItemGeneratorImpl());
    private final Cart cart = new Cart();

    @MenuHandleInfo(desc = "1. List items", num = 1)
    public void listItems() {
        new ListItemsAction().run(shop.getItems());
    }

    @MenuHandleInfo(desc = "2. Add item to the cart", num = 2)
    public void addToCart() {
        new AddItemToCartAction().run(shop, cart);
    }

    @MenuHandleInfo(desc = "3. Remove item from the cart", num = 3)
    public void removeFromCart() {
        new RemoveFromCartAction().run(shop, cart);
    }

    @MenuHandleInfo(desc = "4. List of items in the cart", num = 4)
    public void showOrderedItem() {
        new ListOrderedItemAction().run(cart.getOrders());
    }

    @MenuHandleInfo(desc = "5. Buy items from the cart", num = 5)
    public void buyItem() {
        new BuyAction().run(cart, shop);
    }


    @MenuHandleInfo(desc = "9. Exit", num = 9)
    public void exit() {
        this.isWorking = false;
        System.out.println("Bye");
    }

}
