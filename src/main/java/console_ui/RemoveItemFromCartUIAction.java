package console_ui;

import cart_item.CartItem;
import database.CartItemDatabase;
import database.ItemDatabase;
import item.Item;
import services.RemoveItemFromCartService;
import user_input.UserCommunication;

import java.util.InputMismatchException;
import java.util.Optional;

public class RemoveItemFromCartUIAction implements UIAction {

    private static final String ACTION_NAME = "Remove item from the cart";

    private static final String PROMPT_TOPIC_ITEM = "an item you wish to remove: ";
    private static final String MESSAGE_ITEM_REMOVED = "Item removed from your cart.";

    private final RemoveItemFromCartService removeItemFromCartService;
    private final UserCommunication userCommunication;

    public RemoveItemFromCartUIAction(RemoveItemFromCartService removeItemFromCartService, UserCommunication userCommunication) {
        this.removeItemFromCartService = removeItemFromCartService;
        this.userCommunication = userCommunication;
    }

    @Override
    public void execute() {

        userCommunication.requestInput(PROMPT_TOPIC_ITEM);
        String userInputItem = userCommunication.getItem();
        try {
            removeItemFromCartService.execute(userInputItem);
        }catch (RuntimeException e) {
            userCommunication.informUser(e.getMessage());
            userCommunication.clearBuffer();
            return;
        }
        userCommunication.informUser(MESSAGE_ITEM_REMOVED);
        userCommunication.clearBuffer();
    }

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }



}
