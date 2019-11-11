package com.gildedrose.items;

import com.gildedrose.Item;

public class SpecializedItemFactory {
    public static SpecializedItem getSpecializedItem(Item item){
        switch(item.name){
            case "Aged Brie":
                return new AgedBrie(item);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(item);
            case "Conjured Mana Cake":
                return new ConjuredItem(item);
            default:
                return new DefaultItem(item);
        }
    }
}
