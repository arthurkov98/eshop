package console_ui;

import database.CartItemDatabase;
import services.ListCartItemsService;
import user_input.UserCommunication;

import java.util.List;
import java.util.Optional;

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
        List<String> items= listCartItemsService.execute();
        if (items.isEmpty()) {
            userCommunication.informUser(MESSAGE_CART_IS_EMPTY);
        } else {
            items.forEach(userCommunication::informUser);
        }
    }

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

}
