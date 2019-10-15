package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends SpecializedItem {
    public AgedBrie(Item item){
        super(item);
    }

    @Override
    public void update() {
        if(!hasReachedMaxQuality()) {
            item.quality++;
        }
        item.sellIn--;
        if(item.sellIn < 0 && !hasReachedMaxQuality()) item.quality++;
    }
}
