package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends SpecializedItem {
    public BackstagePass(Item item){
        super(item);
    }

    @Override
    public void update() {
        if(isQualityNotMax()) {
            item.quality++;
            if (item.sellIn < 11 && isQualityNotMax()) {
                item.quality++;
            }
            if (item.sellIn < 6 && isQualityNotMax()) {
                item.quality++;
            }
        }

        item.sellIn--;

        if(isSellInBelowZero()) item.quality = 0;
    }

    private boolean isSellInBelowZero(){
        return item.sellIn < 0;
    }
}
