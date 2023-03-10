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

    public void removeItem(Item item, Integer removedQuantity, Shop shop) {
        /* this does not work */
        /* we need to remove an existing item, not "new" */
        /* if we want to partially remove orders,
           then we have to either decrease quantityOrdered or yeet the whole thing out */
        /* you can assign orders.remove() to a boolean to see, that it does not remove anything */
        /* you could also write tests.. */
        orders.remove(new OrderedItem(item, removedQuantity));
        /* this actually decreases available quantity */
        shop.increaseItemQuantity(item, removedQuantity);
    }

    public Optional<OrderedItem> findByName(String itemName) {
        return orders.stream().filter(orderedItem -> (orderedItem.getItem().getName()).equals(itemName)).findFirst();
    }

    public boolean itemAvailable(String userInputItem) {
        return findByName(userInputItem).isPresent();
    }

}
