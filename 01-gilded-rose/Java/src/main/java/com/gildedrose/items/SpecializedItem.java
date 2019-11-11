package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class SpecializedItem {
    private static final int MAX_VALUE = 50;
    private static final int MIN_VALUE = 0;
    protected Item item;

    public SpecializedItem(Item item){
        this.item = item;
    }

    public abstract void update();

    private boolean isQualityNotMax(){
        return item.quality < MAX_VALUE;
    }

    private boolean isQualityNotMin(){
        return item.quality > MIN_VALUE;
    }

    protected void increaseQuality(){
        if(isQualityNotMax()) item.quality++;
    }

    protected void increaseQualityBy(int n){
        for(int i = 0; i < n; i++) if(isQualityNotMax()) item.quality++;
    }

    protected void decreaseQuality(){
        if(isQualityNotMin()) item.quality--;
        if(isSellInBelowZero()) item.quality--;
    }

    protected void decreaseSellIn(){
        item.sellIn--;
    }

    protected boolean isSellInBelowZero(){
        return item.sellIn < MIN_VALUE;
    }
}
