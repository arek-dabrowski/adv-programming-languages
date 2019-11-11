package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends SpecializedItem {
    public AgedBrie(Item item){
        super(item);
    }

    @Override
    public void update() {
        increaseQuality();
        decreaseSellIn();
        if(isSellInBelowZero()) increaseQuality();
    }
}
