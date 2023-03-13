package console_ui;

import exception.InvalidQuantityException;
import exception.NotOpenCartException;
import services.AddItemToCartService;

import java.util.InputMismatchException;

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
            /* can't item_added message be here? */
            /* with no return in catch and single clearBuffer at the end? */
            userCommunication.informUser(MESSAGE_ITEM_ADDED);
        } catch (InputMismatchException e) {
            /* two nearly identical code blocks */
            /* I would do something like getting quantity as a string, moving number check into service and returning an exception from there */
            /* uiAction probably should not perform any logic anyway */
            userCommunication.informUser(ERROR_NOT_A_NUMBER);
        }catch (InvalidQuantityException | NotOpenCartException e) {
            userCommunication.informUser(e.getMessage());
        }
        userCommunication.clearBuffer();

    }

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }



}
