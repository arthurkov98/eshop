package services;

import cart_item.CartItem;
import database.CartItemDatabase;
import database.ItemDatabase;
import item.Item;
import java.util.Optional;

public class AddItemToCartService implements Service{

    private static final String ERROR_NO_SUCH_ITEM = "Error: No such item.";
    private static final String ERROR_NOT_ENOUGH_QUANTITY = "Error: Available quantity lower than ordered amount.";
    private final ItemDatabase itemDatabase;
    private final CartItemDatabase cartItemDatabase;

    public AddItemToCartService(ItemDatabase itemDatabase, CartItemDatabase cartItemDatabase) {
        this.itemDatabase = itemDatabase;
        this.cartItemDatabase = cartItemDatabase;

    }

    public void execute(String itemName, Integer orderedQuantity) {
        if(!itemExists(itemName))
            throw new RuntimeException(ERROR_NO_SUCH_ITEM);

        if(!orderedQuantityValid(orderedQuantity, itemName))
            throw new RuntimeException(ERROR_NOT_ENOUGH_QUANTITY);

        Item item = findByName(itemName).get();
        cartItemDatabase.save(new CartItem(item, orderedQuantity));
        Integer newAvailableQuantity = item.getAvailableQuantity() - orderedQuantity;
        itemDatabase.changeAvailableQuantity(item.getId(), newAvailableQuantity);

    }


    private Optional<Item> findByName(String itemName) {
        return itemDatabase.getAllItems().stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst();
    }

    private boolean itemExists(String itemName) {
        return findByName(itemName).isPresent();
    }

    private boolean orderedQuantityValid(Integer quantityOrdered, String itemName) {
        return quantityOrdered > 0 &&
                quantityOrdered <= findByName(itemName).get().getAvailableQuantity();
    }

}