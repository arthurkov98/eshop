package services;

import database.CartItemDatabase;
import database.ItemDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class ListShopItemsService {
    private final ItemDatabase itemDatabase;

    public ListShopItemsService(ItemDatabase itemDatabase) {
        this.itemDatabase = itemDatabase;
    }

    public List<String> execute(){
        return itemDatabase.getAllItems().stream().map(i->i.toString()).collect(Collectors.toList());
    }
}
