package menu.actions;

import data.OrderedItem;
import user_input.UserCommunication;

import java.util.List;

public class ListOrderedItemAction {

    private final UserCommunication userCommunication = new UserCommunication();

    public void run(List<OrderedItem> orderedItems) {
        orderedItems.forEach(System.out::println);
        if (orderedItems.isEmpty()) {
            String MESSAGE_CART_IS_EMPTY = "Your cart is empty";
            userCommunication.informUser(MESSAGE_CART_IS_EMPTY);
        }
    }
}
