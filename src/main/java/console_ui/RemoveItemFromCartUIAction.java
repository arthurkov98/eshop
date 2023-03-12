package console_ui;

import services.RemoveItemFromCartService;

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
            /* I personally really do not like that style of repeating code*/
            userCommunication.informUser(e.getMessage());
            /* btw, why is there a clearBuffer in there to begin with? */
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
