package console_ui;

import database.CartDatabase;
import database.CartItemDatabase;
import database.ItemDatabase;
import services.*;

import java.util.HashMap;
import java.util.Map;

public class UIActionsMap {

    private final Map<Integer, UIAction> uiActionsMap;

    public UIActionsMap(ItemDatabase itemDatabase, CartDatabase cartDatabase, CartItemDatabase cartItemDatabase, UserCommunication userCommunication) {
        Map<Integer, UIAction> uiActionsMap = new HashMap<>();
        uiActionsMap.put(1, new ListShopItemsUIAction(new ListShopItemsService(itemDatabase), userCommunication));
        uiActionsMap.put(2, new AddItemToCartUIAction(new AddItemToCartService(itemDatabase, cartItemDatabase), userCommunication));
        uiActionsMap.put(3, new RemoveItemFromCartUIAction(new RemoveItemFromCartService(itemDatabase, cartItemDatabase), userCommunication));
        uiActionsMap.put(4, new ListCartItemsUIAction(new ListCartItemsService(cartItemDatabase), userCommunication));
        uiActionsMap.put(5, new BuyUIAction(new BuyService(cartDatabase), userCommunication));
        uiActionsMap.put(9, new ExitUIAction(new ExitService(), userCommunication));
        this.uiActionsMap = uiActionsMap;
    }

    public Map<Integer, UIAction> getUiActionsMap() {
        return uiActionsMap;
    }

}
