package services;

import cart_item.CartItem;
import database.CartItemDatabase;

import java.util.List;

public class ListCartItemsService {
    private final CartItemDatabase cartItemDatabase;

    public ListCartItemsService(CartItemDatabase cartItemDatabase) {
        this.cartItemDatabase = cartItemDatabase;
    }

    /* why are those strings? */
    public List<CartItem> execute(){
        /* i is still a very bad name */
        return cartItemDatabase.getAllCartItems();
    }
}
