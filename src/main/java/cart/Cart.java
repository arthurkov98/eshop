package cart;

import data.CartItem;
import data.Item;
import shop.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {

    List<CartItem> orders = new ArrayList<>();

    public List<CartItem> getOrders() {
        return orders;
    }

    public void addItem(Item item, Integer orderedQuantity, Shop shop) {
        orders.add(new CartItem(item, orderedQuantity));
        shop.decreaseItemQuantity(item, orderedQuantity);
    }

    public void removeItem(Item item, Integer removedQuantity, Shop shop) {
        /* why does i start from 1? */
        for (int i = 1; i < orders.size(); i++) {
            /* IMHO it is better to compare names or add an equals() method to Item */
            /* it feels like equals() works, only because our implementation of addItem() is bad */
            if (orders.get(i).getItem().equals(item) && orders.get(i).getQuantityOrdered() >= removedQuantity) {
                /* it removes the whole item */
                orders.remove(orders.get(i));
                //              orders.add(new CartItem(orders.get(i).getItem(), orders.get(i).getQuantityOrdered()-removedQuantity));
            } /* but only increases amount by removedQuantity */
            shop.increaseItemQuantity(item, removedQuantity);/* also, what's with that formatting? (ctrl+alt+l) */
        }
    }
//    }

    public Optional<CartItem> findByName(String itemName) {
        return orders.stream().filter(cartItem -> (cartItem.getItem().getName()).equals(itemName)).findFirst();
    }

    public boolean itemAvailable(String userInputItem) {
        return findByName(userInputItem).isPresent();
    }

}
