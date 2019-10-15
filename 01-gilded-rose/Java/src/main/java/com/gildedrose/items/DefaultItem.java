package com.gildedrose.items;

import com.gildedrose.Item;

public class DefaultItem implements SpecializedItem {
    private Item item;
    public DefaultItem(Item item){
        this.item = item;
    }

    @Override
    public void update() {
        item.quality--;
        item.sellIn--;
    }

    public Item getItem() {
        return item;
    }
}
