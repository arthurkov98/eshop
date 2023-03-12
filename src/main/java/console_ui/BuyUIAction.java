package console_ui;

import services.BuyService;

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
            /* why is there a clearBuffer? */
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
