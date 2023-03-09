package menu;

import cart.Cart;
import data.OrderedItem;
import item_generator.RandomItemGeneratorImpl;
import menu.actions.AddItemToCartAction;
import menu.actions.ListItemsAction;
import menu.actions.OrderedItemAction;
import menu.actions.RemoveFromCartAction;
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
    @MenuHandleInfo(desc = "4. Remove item from the cart", num = 4)
    public void showOrderedItem() {new OrderedItemAction().run(cart.getOrders());
    }


    @MenuHandleInfo(desc = "9. Exit", num = 9)
    public void exit() {
        this.isWorking = false;
        System.out.println("Bye");
    }

}
