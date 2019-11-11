package com.gildedrose;

class GildedRose {
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items){
            modifyQualityWhenSellInAboveZero(item);
            decreaseSellIn(item);
            modifyQualityWhenSellInDropsToZero(item);
        }
    }

    private void modifyQualityWhenSellInAboveZero(Item item) {
        if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES)) {
            decreaseQuality(item);
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.sellIn < 11 && item.quality < 50) {
                            item.quality += 1;
                    }

                    if (item.sellIn < 6 && item.quality < 50) {
                            item.quality += 1;
                    }
                }
            }
        }
    }

    private void modifyQualityWhenSellInDropsToZero(Item item) {
        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE_PASSES)) {
                    decreaseQuality(item);
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality += 1;
                }
            }
        }
    }

    private void decreaseSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn -= 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0 && !item.name.equals(SULFURAS)) {
            item.quality -= 1;
            if (item.name.equals(CONJURED) && item.quality != 0) {
                item.quality -= 1;
            }
        }
    }
}