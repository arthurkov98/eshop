package menu.actions;

import data.OrderedItem;

import java.util.List;

public class ListOrderedItemAction {

    public void run(List<OrderedItem> orderedItems) {
        orderedItems.forEach(System.out::println);
        if (orderedItems.isEmpty()) {
            System.out.println("Your cart is empty");
        }
    }
}
