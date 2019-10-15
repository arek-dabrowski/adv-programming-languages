package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class SpecializedItem {
    protected Item item;

    public SpecializedItem(Item item){
        this.item = item;
    }

    public abstract void update();

    public boolean hasReachedMaxQuality(){
        return item.quality > 50;
    }
}
