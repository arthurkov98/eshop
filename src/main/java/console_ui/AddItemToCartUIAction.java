package console_ui;

import cart_item.CartItem;
import database.CartItemDatabase;
import database.ItemDatabase;
import item.Item;
import services.AddItemToCartService;
import user_input.UserCommunication;

import java.util.InputMismatchException;
import java.util.Optional;

public class AddItemToCartUIAction implements UIAction {

    private static final String ACTION_NAME = "Add item to the cart";

    private static final String PROMPT_TOPIC_ITEM = "an item you wish to order: ";
    private static final String PROMPT_TOPIC_QUANTITY = "quantity to be ordered: ";
    private static final String MESSAGE_ITEM_ADDED = "Item added to your cart.";
    private static final String ERROR_NOT_A_NUMBER = "Error: Quantity should be a number.";

    private final AddItemToCartService addItemToCartService;
    private final UserCommunication userCommunication;

    public AddItemToCartUIAction(AddItemToCartService addItemToCartService, UserCommunication userCommunication) {
        this.userCommunication = userCommunication;
        this.addItemToCartService = addItemToCartService;
    }

    @Override
    public void execute() {
        userCommunication.requestInput(PROMPT_TOPIC_ITEM);
        String userInputItem = userCommunication.getItem();
        userCommunication.requestInput(PROMPT_TOPIC_QUANTITY);
        try {
            Integer orderedQuantity = userCommunication.getQuantity();
            addItemToCartService.execute(userInputItem, orderedQuantity);
        } catch (InputMismatchException e) {
            userCommunication.informUser(ERROR_NOT_A_NUMBER);
            userCommunication.clearBuffer();
            return;
        }catch (RuntimeException e) {
            userCommunication.informUser(e.getMessage());
            userCommunication.clearBuffer();
            return;
        }
        userCommunication.informUser(MESSAGE_ITEM_ADDED);
        userCommunication.clearBuffer();

    }

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }



}
