package services;

/* unused import (ctrl+alt+o) */

import database.ItemDatabase;
import item.Item;

import java.util.List;

public class ListShopItemsService {
    private final ItemDatabase itemDatabase;

    public ListShopItemsService(ItemDatabase itemDatabase) {
        this.itemDatabase = itemDatabase;
    }

    /* is there a reason for returning those as strings and not items? */
    /* what if we will ditch the console ui? */
    public List<Item> execute(){
        /* i is a very bad name */
        return itemDatabase.getAllItems();
    }
}
