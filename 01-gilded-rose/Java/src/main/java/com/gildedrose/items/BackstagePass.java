package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends SpecializedItem {
    public BackstagePass(Item item){
        super(item);
    }

    @Override
    public void update() {
        if(isSellInBelow6()){
            increaseQualityBy(3);
        } else if(isSellInBelow11()){
            increaseQualityBy(2);
        } else increaseQuality();

        decreaseSellIn();

        if(isSellInBelowZero()) setQualityToZero();
    }

    private boolean isSellInBelow11(){
        return item.sellIn < 11 && !isSellInBelowZero();
    }

    private boolean isSellInBelow6(){
        return item.sellIn < 6 && !isSellInBelowZero();
    }

    private void setQualityToZero(){
        item.quality = 0;
    }
}
