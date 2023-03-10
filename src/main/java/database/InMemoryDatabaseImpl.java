package database;

import cart.Cart;
import data.Item;
import data.OrderedItem;
import shop.Shop;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseImpl implements Database {

    List<OrderedItem> orderedItems = new ArrayList<>();
    List<Item> items = new ArrayList<>();

    @Override
    public void addToCart(Item item, Cart cart, Integer quantity, Shop shop) {
        cart.addItem(item, quantity, shop);
    }

    @Override
    public void removeFromCart(String itemName) {
        orderedItems.stream()
                .filter(orderedItem -> orderedItem.getItem().getName().equalsIgnoreCase(itemName))
                .findFirst()
                .ifPresent(orderedItem -> orderedItems.remove(orderedItem));
    }

    @Override
    public List<Item> getAllItems() {
        return items;
    }
}
