package services;

/* unused import (ctrl+alt+o) */
import database.CartItemDatabase;
import database.ItemDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class ListShopItemsService {
    private final ItemDatabase itemDatabase;

    public ListShopItemsService(ItemDatabase itemDatabase) {
        this.itemDatabase = itemDatabase;
    }

    /* is there a reason for returning those as strings and not items? */
    /* what if we will ditch the console ui? */
    public List<String> execute(){
        /* i is a very bad name */
        return itemDatabase.getAllItems().stream().map(i->i.toString()).collect(Collectors.toList());
    }
}
