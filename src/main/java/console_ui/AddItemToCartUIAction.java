package console_ui;

import data.CartItem;
import data.Item;
import user_input.UserCommunication;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

// TODO really needs a functioning DB
public class AddItemToCartUIAction implements UIAction {

    private static final String PROMPT_TOPIC_ITEM = "an item you wish to order: ";
    private static final String PROMPT_TOPIC_QUANTITY = " quantity to be ordered: ";
    private static final String MESSAGE_ITEM_ADDED = "Item added to your cart.";
    private static final String MESSAGE_NO_SUCH_ITEM = "Error: No such item.";
    private static final String ERROR_NOT_A_NUMBER = "Error: Quantity should be a number.";
    private static final String MESSAGE_NOT_ENOUGH_QUANTITY = "Error: Available quantity lower than ordered amount.";

    private final List<Item> shopItems;
    private final List<CartItem> cartItems;
    private final UserCommunication userCommunication;

    public AddItemToCartUIAction(List<Item> shopItems, List<CartItem> cartItems, UserCommunication userCommunication) {
        this.shopItems = shopItems;
        this.cartItems = cartItems;
        this.userCommunication = userCommunication;
    }

    @Override
    public void execute() {
        userCommunication.requestInput(PROMPT_TOPIC_ITEM);
        String userInputItem = userCommunication.getItem();
        if (itemAvailable(userInputItem)) {
            Item item = findByName(userInputItem).get();
            userCommunication.requestInput(PROMPT_TOPIC_QUANTITY);
            try {
                Integer orderedQuantity = userCommunication.getQuantity();
                if (orderQuantityValid(orderedQuantity, item)) {
                    cartItems.add(new CartItem(item, orderedQuantity));
                    decreaseItemQuantity(item, orderedQuantity);
                    userCommunication.informUser(MESSAGE_ITEM_ADDED);
                } else {
                    userCommunication.informUser(MESSAGE_NOT_ENOUGH_QUANTITY);
                }
            } catch (InputMismatchException e) {
                userCommunication.informUser(ERROR_NOT_A_NUMBER);
            }
        } else {
            userCommunication.informUser(MESSAGE_NO_SUCH_ITEM);
        }
    }

    private boolean itemAvailable(String itemName) {
        return itemExists(itemName) &&
                findByName(itemName).get().getQuantityAvailable() > 0;
    }

    private Optional<Item> findByName(String itemName) {
        return shopItems.stream().filter(item -> item.getName().equals(itemName)).findFirst();
    }

    private boolean itemExists(String itemName) {
        return findByName(itemName).isPresent();
    }

    private boolean orderQuantityValid(Integer quantityOrdered, Item item) {
        return quantityOrdered > 0 &&
                quantityOrdered <= item.getQuantityAvailable();
    }

    private void decreaseItemQuantity(Item item, Integer amount) {
        if (itemAvailable(item.getName())) {
            item.decreaseQuantityAvailable(amount);
        }
    }

}
