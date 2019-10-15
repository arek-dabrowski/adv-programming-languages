package com.gildedrose.items;

import com.gildedrose.Item;

public class SpecializedItemFactory {
    public static SpecializedItem getSpecializedItem(Item item){
        switch(item.name){
            case "Test Object":
                return new DefaultItem(item);
            default:
                return new DefaultItem(item);
        }
    }
}
