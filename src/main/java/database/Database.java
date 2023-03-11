package database;

import cart.Cart;
import data.Item;
import shop.Shop;

import java.util.List;

/* IMHO this ain't what the task meant  */
/* As I see it, this "database" thing is supposed to be a weird fake and skewed database imposter */
/* I would make an interface for each table */
/* Item interface's implementation would be used in item generators and quantity changes */
/* Cart interface's implementation would be used once at the start to create the cart */
/* CartItem interface's implementation would be used in adding or removing items to or from the cart */
/* User interface's implementation would be used in the future, when we have multiple users */
public interface Database {

    void addToCart(Item item, Cart cart, Integer quantity, Shop shop);

    void removeFromCart(String itemName);

    List<Item> getAllItems();
}
