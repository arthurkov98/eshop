package menu.actions;

import cart.Cart;
import data.Item;
/* ctrl + alt + o magic required */
import shop.Shop;
import user_input.UserCommunication;

public class RemoveFromCartAction {
    private static final String PROMPT_TOPIC_ITEM = "an item you wish to remove: ";
    private static final String PROMPT_TOPIC_QUANTITY = "quantity to be removed: ";
    private static final String MESSAGE_ITEM_REMOVED = "Item removed from your cart";
    private static final String MESSAGE_NO_SUCH_ITEM = "Error: No such item.";
    private static final String MESSAGE_NOT_ENOUGH_QUANTITY = "Error: removing quantity lower than ordered amount.";
                                                                /* this has nothing to do with available quantity */

    private final UserCommunication userCommunication = new UserCommunication();

    /* this straight up does not work */
    public void run(Shop shop, Cart cart) {
        userCommunication.requestInput(PROMPT_TOPIC_ITEM);
        String userInputItem = userCommunication.getItem();
        if (cart.itemAvailable(userInputItem)) {
            /* I would not ask for quantity and just remove all */
            /* but that's because I am lazy */
            Item item = cart.findByName(userInputItem).get().getItem();
            userCommunication.requestInput(PROMPT_TOPIC_QUANTITY);
            /* why is it called orderedQuantity, it is quantityToBeRemoved or something */
            Integer quantityToRemoved = userCommunication.getQuantity();
            /* this one checks available quantity, not the one in the cart */
            if (orderQuantityValid(quantityToRemoved, item)) {
                cart.removeItem(item, quantityToRemoved, shop);
                userCommunication.informUser(MESSAGE_ITEM_REMOVED);
            } else {
                userCommunication.informUser(MESSAGE_NOT_ENOUGH_QUANTITY);
            }
        } else {
            userCommunication.informUser(MESSAGE_NO_SUCH_ITEM);
        }
    }

    /* again, it is not quantityOrdered */
    private boolean orderQuantityValid(Integer quantityToRemoved, Item item) {
        return quantityToRemoved > 0 &&
                /* wrong quantity */
                quantityToRemoved <= item.getQuantityAvailable();
    }
}
