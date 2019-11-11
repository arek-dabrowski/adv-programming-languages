package com.gildedrose;

import com.gildedrose.items.SpecializedItem;
import com.gildedrose.items.SpecializedItemFactory;

import java.util.ArrayList;

class GildedRose {
    Item[] items;
    private ArrayList<SpecializedItem> specializedItems;

    public GildedRose(Item[] items) {
        specializedItems = new ArrayList<>();
        this.items = items;
        for(Item item : items){
            specializedItems.add(SpecializedItemFactory.getSpecializedItem(item));
        }
    }

    public void updateQuality(){
        for(SpecializedItem item : specializedItems){
            item.update();
        }
    }
}