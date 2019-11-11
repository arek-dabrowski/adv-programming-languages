package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends SpecializedItem {
    public BackstagePass(Item item){
        super(item);
    }

    @Override
    public void update() {
        if(isSellInBelowNumber(6)){
            increaseQualityBy(3);
        } else if(isSellInBelowNumber(11)){
            increaseQualityBy(2);
        } else increaseQuality();

        decreaseSellIn();

        if(isSellInBelowZero()) setQualityToZero();
    }

    private boolean isSellInBelowNumber(int number){
        return item.sellIn < number && !isSellInBelowZero();
    }

    private void setQualityToZero(){
        item.quality = 0;
    }
}
