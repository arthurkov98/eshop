package console_ui;

import cart_item.CartItem;
import item.Item;
import services.ListCartItemsService;

import java.util.List;

public class ListCartItemsUIAction implements UIAction {

    private static final String ACTION_NAME = "List cart items";

    private static final String HEADER_TEXT = "Cart items:";
    private static final String MESSAGE_CART_IS_EMPTY = "Your cart is empty.";

    private final ListCartItemsService listCartItemsService;
    private final UserCommunication userCommunication;

    public ListCartItemsUIAction(ListCartItemsService listCartItemsService, UserCommunication userCommunication) {
        this.listCartItemsService = listCartItemsService;
        this.userCommunication = userCommunication;
    }

    @Override
    public void execute() {
        userCommunication.informUser(HEADER_TEXT);
        List<CartItem> cartItems= listCartItemsService.execute();
        if (cartItems.isEmpty()) {
            userCommunication.informUser(MESSAGE_CART_IS_EMPTY);
        } else {
            cartItems.forEach(item -> userCommunication.informUser(item.toString()));
        }
    }

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

}
