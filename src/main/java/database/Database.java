package database;

import cart.Cart;
import data.Item;
import shop.Shop;

import java.util.List;

public interface Database {

    void addToCart(Item item, Cart cart, Integer quantity, Shop shop);

    void removeFromCart(String itemName);

    List<Item> getAllItems();
}
