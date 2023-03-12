package console_ui;

import cart.Cart;
import cart.CartStatus;
import database.CartDatabase;
import services.BuyService;
import user_input.UserCommunication;

import java.time.LocalDate;
import java.util.Optional;

public class BuyUIAction implements UIAction {

    private static final String ACTION_NAME = "Buy items in the cart";

    private static final String MESSAGE_CART_IS_CLOSED = "Your cart is closed now.";


    private final BuyService buyService;
    private final UserCommunication userCommunication;

    public BuyUIAction(BuyService buyService, UserCommunication userCommunication) {
        this.buyService = buyService;
        this.userCommunication = userCommunication;
    }

    @Override
    public void execute() {

        try{
            buyService.execute();
        }catch (RuntimeException e) {
            userCommunication.informUser(e.getMessage());
            userCommunication.clearBuffer();
            return;
        }
        userCommunication.informUser(MESSAGE_CART_IS_CLOSED);
    }

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

}
