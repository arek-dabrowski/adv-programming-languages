package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class SpecializedItem {
    protected Item item;

    public SpecializedItem(Item item){
        this.item = item;
    }

    public abstract void update();

    private boolean isQualityNotMax(){
        return item.quality < 50;
    }

    private boolean isQualityNotMin(){
        return item.quality > 0;
    }

    protected void increaseQuality(){
        if(isQualityNotMax()) item.quality++;
    }

    protected void decreaseQuality(){
        if(isQualityNotMin()) item.quality--;
    }

    protected void decreaseSellIn(){
        item.sellIn--;
    }

    protected boolean isSellInBelowZero(){
        return item.sellIn < 0;
    }
}
