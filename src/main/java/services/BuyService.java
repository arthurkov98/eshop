package services;

/* ctrl+alt+o is your friend */
import cart.Cart;
import cart.CartStatus;
import cart_item.CartItem;
import database.CartDatabase;
import database.CartItemDatabase;
import database.ItemDatabase;
import exception.NotOpenCartException;
import item.Item;

import java.time.LocalDate;
import java.util.Optional;

public class BuyService {
    private final CartDatabase cartDatabase;
    private static final String ERROR_NO_OPEN_CART = "You do not have an open cart.";

    public BuyService(CartDatabase cartDatabase) {
        this.cartDatabase = cartDatabase;
    }

    public void execute() throws NotOpenCartException{
        Optional<Cart> userCart = cartDatabase.getAllCarts().stream()
                .filter(cart -> cart.getCartStatus().equals(CartStatus.OPEN))
                .findFirst();

        /* again, generic exceptions are not welcome here */
        if (userCart.isEmpty()) throw new NotOpenCartException(ERROR_NO_OPEN_CART);

        cartDatabase.changeCartStatus(userCart.get().getId(), CartStatus.CLOSED);
        cartDatabase.changeLastActionDate(userCart.get().getId(), LocalDate.now());


    }
}
