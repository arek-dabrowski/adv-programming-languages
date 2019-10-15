package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass implements SpecializedItem {
    private Item item;

    public BackstagePass(Item item){
        this.item = item;
    }

    @Override
    public void update() {
        if(item.quality < 50) {
            item.quality++;
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality++;
            }
            if (item.sellIn < 6 && item.quality < 50) {
                item.quality++;
            }
        }
        item.sellIn--;
        if(item.sellIn < 0) item.quality = 0;
    }
}
