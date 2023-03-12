package console_ui;

import database.ItemDatabase;
import services.ListShopItemsService;
import user_input.UserCommunication;

import java.util.List;

public class ListShopItemsUIAction implements UIAction {

    private static final String ACTION_NAME = "List items";

    private static final String HEADER_TEXT = "Shop items:";

    private final ListShopItemsService listShopItemsService;
    private final UserCommunication userCommunication;

    public ListShopItemsUIAction(ListShopItemsService listShopItemsService, UserCommunication userCommunication) {
        this.listShopItemsService = listShopItemsService;
        this.userCommunication = userCommunication;
    }

    @Override
    public void execute() {
        userCommunication.informUser(HEADER_TEXT);
        List<String> items= listShopItemsService.execute();
        items.forEach(userCommunication::informUser);
    }

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

}
