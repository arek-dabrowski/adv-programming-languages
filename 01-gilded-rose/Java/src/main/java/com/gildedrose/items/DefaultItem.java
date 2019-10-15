package com.gildedrose.items;

import com.gildedrose.Item;

public class DefaultItem extends SpecializedItem {
    public DefaultItem(Item item){
        super(item);
    }

    @Override
    public void update() {
        if(isQualityNotMin()) item.quality--;
        item.sellIn--;
    }
}
