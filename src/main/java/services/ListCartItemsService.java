package services;

import database.CartItemDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class ListCartItemsService {
    private final CartItemDatabase cartItemDatabase;

    public ListCartItemsService(CartItemDatabase cartItemDatabase) {
        this.cartItemDatabase = cartItemDatabase;
    }

    public List<String> execute(){
        return cartItemDatabase.getAllCartItems().stream().map(i->i.toString()).collect(Collectors.toList());
    }
}
