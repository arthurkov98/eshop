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
        for (int i = 1; i < orders.size(); i++) {
            if (orders.get(i).getItem().equals(item) && orders.get(i).getQuantityOrdered() >= removedQuantity) {
                orders.remove(orders.get(i));
  //              orders.add(new OrderedItem(orders.get(i).getItem(), orders.get(i).getQuantityOrdered()-removedQuantity));
                } shop.increaseItemQuantity(item, removedQuantity);
            }
        }
//    }

    public Optional<OrderedItem> findByName(String itemName) {
        return orders.stream().filter(orderedItem -> (orderedItem.getItem().getName()).equals(itemName)).findFirst();
    }

    public boolean itemAvailable(String userInputItem) {
        return findByName(userInputItem).isPresent();
    }

}
