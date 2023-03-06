package menu.actions;

import cart.Cart;
import data.Item;
import data.OrderedItem;
import shop.Shop;
import user_input.UserCommunication;

public class RemoveFromCartAction {
    private static final String PROMPT_TOPIC_ITEM = "an item you wish to remove: ";
    private static final String PROMPT_TOPIC_QUANTITY = " quantity to be removed: ";
    private static final String MESSAGE_ITEM_REMOVED = "Item removed to your cart";
    private static final String MESSAGE_NO_SUCH_ITEM = "Error: No such item.";
    private static final String MESSAGE_NOT_ENOUGH_QUANTITY = "Error: Available quantity lower than ordered amount.";

    private final UserCommunication userCommunication = new UserCommunication();

    public void run(OrderedItem orderedItem, Cart cart, Shop shop) {
        userCommunication.requestInput(PROMPT_TOPIC_ITEM);
        String userInputItem = userCommunication.getItem();
        if (cart.itemAvailable(userInputItem)) {
            Item item = cart.findByName(userInputItem).get().getItem();
            userCommunication.requestInput(PROMPT_TOPIC_QUANTITY);
            Integer orderedQuantity = userCommunication.getQuantity();
            if (orderQuantityValid(orderedQuantity, item)) {
                cart.removeItem(item, orderedQuantity, shop);
                userCommunication.informUser(MESSAGE_ITEM_REMOVED);
            } else {
                userCommunication.informUser(MESSAGE_NOT_ENOUGH_QUANTITY);
            }
        } else {
            userCommunication.informUser(MESSAGE_NO_SUCH_ITEM);
        }
    }

    private boolean orderQuantityValid(Integer quantityOrdered, Item item) {
        return quantityOrdered > 0 &&
                quantityOrdered <= item.getQuantityAvailable();
    }
}