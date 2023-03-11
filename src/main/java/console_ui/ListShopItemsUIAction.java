package console_ui;

import data.Item;
import user_input.UserCommunication;

import java.util.List;

// TODO WTB a DB
public class ListShopItemsUIAction implements UIAction {

    private static final String HEADER_TEXT = "Shop items:";

    private final List<Item> shopItems;
    private final UserCommunication userCommunication;

    public ListShopItemsUIAction(List<Item> shopItems, UserCommunication userCommunication) {
        this.shopItems = shopItems;
        this.userCommunication = userCommunication;
    }

    @Override
    public void execute() {
        userCommunication.informUser(HEADER_TEXT);
        shopItems.forEach(item -> userCommunication.informUser(item.toString()));
    }

}
