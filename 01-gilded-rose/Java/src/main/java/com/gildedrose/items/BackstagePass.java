package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends SpecializedItem {
    public BackstagePass(Item item){
        super(item);
    }

    @Override
    public void update() {
        increaseQuality();

        if(isSellInBelow11()) increaseQuality();
        if(isSellInBelow6()) increaseQuality();

        decreaseSellIn();

        if(isSellInBelowZero()) item.quality = 0;
    }

    private boolean isSellInBelow11(){
        return item.sellIn < 11;
    }

    private boolean isSellInBelow6(){
        return item.sellIn < 6;
    }
}
