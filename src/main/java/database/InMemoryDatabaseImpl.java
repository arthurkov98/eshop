package database;

import cart.Cart;
import data.CartItem;
import data.Item;
import shop.Shop;

import java.util.ArrayList;
import java.util.List;

/* this whole class isn't used anywhere */
/* why does it even exist? */
public class InMemoryDatabaseImpl implements Database {

    List<CartItem> cartItems = new ArrayList<>();
    List<Item> items = new ArrayList<>();

    @Override
    public void addToCart(Item item, Cart cart, Integer quantity, Shop shop) {
        cart.addItem(item, quantity, shop);
    }

    @Override
    public void removeFromCart(String itemName) {
        cartItems.stream()
                .filter(cartItem -> cartItem.getItem().getName().equalsIgnoreCase(itemName))
                .findFirst()
                .ifPresent(cartItem -> cartItems.remove(cartItem));
    }

    @Override
    public List<Item> getAllItems() {
        return items;
    }
}
