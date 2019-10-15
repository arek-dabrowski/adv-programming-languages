package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class SpecializedItem {
    protected Item item;

    public SpecializedItem(Item item){
        this.item = item;
    }

    public abstract void update();

    protected boolean isQualityNotMax(){
        return item.quality < 50;
    }

    protected boolean isQualityNotMin(){
        return item.quality > 0;
    }
}
