package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends SpecializedItem {
    public BackstagePass(Item item){
        super(item);
    }

    @Override
    public void update() {
        if(!hasReachedMaxQuality()) {
            item.quality++;
            if (item.sellIn < 11 && !hasReachedMaxQuality()) {
                item.quality++;
            }
            if (item.sellIn < 6 && !hasReachedMaxQuality()) {
                item.quality++;
            }
        }
        item.sellIn--;
        if(item.sellIn < 0) item.quality = 0;
    }
}
