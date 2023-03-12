package services;

import database.CartItemDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class ListCartItemsService {
    private final CartItemDatabase cartItemDatabase;

    public ListCartItemsService(CartItemDatabase cartItemDatabase) {
        this.cartItemDatabase = cartItemDatabase;
    }

    /* why are those strings? */
    public List<String> execute(){
        /* i is still a very bad name */
        return cartItemDatabase.getAllCartItems().stream().map(i->i.toString()).collect(Collectors.toList());
    }
}
