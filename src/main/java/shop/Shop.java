package shop;

import cart.Cart;
import data.Item;
import item_generator.ItemGenerator;

import java.util.List;
import java.util.Optional;

public class Shop {

    private final List<Item> items;

    public Shop(ItemGenerator itemGenerator) {
        this.items = itemGenerator.createItems();
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean itemAvailable(String itemName) {
        if (itemExists(itemName)) {
            return findByName(itemName).get().getQuantityAvailable() > 0;
        }
        return false;
    }

    public Optional<Item> findByName(String itemName) {
        return items.stream().filter(item -> item.getName().equals(itemName)).findFirst();
    }

    public void decreaseItemQuantity(Item item, Integer amount) {
        if (itemAvailable(item.getName())) {
            item.decreaseQuantityAvailable(amount);
        }
    }

    public void increaseItemQuantity(Item item, Integer amount) {
        item.increaseQuantityAvailable(amount);
    }

    private boolean itemExists(String itemName) {
        return findByName(itemName).isPresent();
    }

    /* why is there a public method after a private one? */
    public void buy(Cart cart){
        cart.getOrders().clear();
        /* IMHO green text in the code is the source of all evil */
        System.out.println("You bought items from your cart");
    }
}
