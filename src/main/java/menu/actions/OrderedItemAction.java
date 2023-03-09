package menu.actions;

import data.OrderedItem;

import java.util.List;

public class OrderedItemAction {

    public void run(List<OrderedItem> orderedItems) {
        orderedItems.forEach(System.out::println);
    }
}
