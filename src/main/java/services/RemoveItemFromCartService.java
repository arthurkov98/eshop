package services;

import cart_item.CartItem;
import database.CartItemDatabase;
import database.ItemDatabase;
import item.Item;

import java.util.Optional;

public class RemoveItemFromCartService {

    private final ItemDatabase itemDatabase;
    private final CartItemDatabase cartItemDatabase;
    private static final String ERROR_NO_SUCH_ITEM = "Error: No such item in your cart.";

    public RemoveItemFromCartService(ItemDatabase itemDatabase, database.CartItemDatabase cartItemDatabase) {
        this.itemDatabase = itemDatabase;
        this.cartItemDatabase = cartItemDatabase;

    }


    public void execute(String itemName) {
        if(!itemExists(itemName))
            /* generic exception bad */
            throw new RuntimeException(ERROR_NO_SUCH_ITEM);


        CartItem cartItem = findCartItemByName(itemName).get();
        Item item = findItemByName(itemName).get();
        Integer newAvailableQuantity = item.getAvailableQuantity() + cartItem.getOrderedQuantity();
        /* wut? */
        cartItemDatabase.deleteByID(cartItem.getId());
        /* a headshot, just to be sure that it is dead?  */
        cartItemDatabase.deleteByID(cartItem.getId());
        itemDatabase.changeAvailableQuantity(item.getId(), newAvailableQuantity);

    }


    private boolean itemExists(String itemName) {
        return findCartItemByName(itemName).isPresent();
    }

    private Optional<CartItem> findCartItemByName(String itemName) {
        return cartItemDatabase.getAllCartItems().stream()
                .filter(cartItem -> cartItem.getItem().getName().equals(itemName))
                .findFirst();
    }

    private Optional<Item> findItemByName(String itemName) {
        return itemDatabase.getAllItems().stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst();
    }
}
