package menu.actions;

import data.CartItem;
import user_input.UserCommunication;

import java.util.List;

public class ListOrderedItemAction {

    private final UserCommunication userCommunication = new UserCommunication();

    public void run(List<CartItem> cartItems) {
        cartItems.forEach(System.out::println);
        if (cartItems.isEmpty()) {
            /* this should be a class constant */
            String MESSAGE_CART_IS_EMPTY = "Your cart is empty";
            userCommunication.informUser(MESSAGE_CART_IS_EMPTY);
        }
    }
}
