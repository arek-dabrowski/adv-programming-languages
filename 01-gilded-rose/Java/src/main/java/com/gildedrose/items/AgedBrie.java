package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie implements SpecializedItem {
    private Item item;

    public AgedBrie(Item item){
        this.item = item;
    }

    @Override
    public void update() {
        if(item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;
        if(item.sellIn < 0 && item.quality < 50) item.quality++;
    }
}
