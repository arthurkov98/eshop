package cart;

import data.Item;
import data.OrderedItem;
import shop.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {

    List<OrderedItem> orders = new ArrayList<>();

    public List<OrderedItem> getOrders() {
        return orders;
    }

    public void addItem(Item item, Integer orderedQuantity, Shop shop) {
        orders.add(new OrderedItem(item, orderedQuantity));
        shop.decreaseItemQuantity(item, orderedQuantity);
    }

    public void removeItem(Item item, Integer orderedQuantity, Shop shop) {
        orders.remove(new OrderedItem(item, orderedQuantity));
        shop.increaseItemQuantity(item, orderedQuantity);
    }

    public Optional<OrderedItem> findByName(String itemName) {
        return orders.stream().filter(orderedItem -> (orderedItem.getItem().getName()).equals(itemName)).findFirst();
    }

    private boolean itemExists(String itemName) {
        return findByName(itemName).isPresent();
    }

    public boolean itemAvailable(String userInputItem) {
        if (findByName(userInputItem).isPresent() ) {
            return true;
        }
        return false;
    }


}
