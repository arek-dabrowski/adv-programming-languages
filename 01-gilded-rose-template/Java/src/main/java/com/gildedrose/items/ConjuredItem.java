package com.gildedrose.items;

import com.gildedrose.Item;

public class ConjuredItem extends SpecializedItem {
    public ConjuredItem(Item item){
        super(item);
    }

    @Override
    public void update() {
        decreaseQuality();
        decreaseQuality();
        decreaseSellIn();
    }
}
