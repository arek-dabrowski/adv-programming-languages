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
        if (isNotAgedBrieAndBackstagePasses(item)) {
            decreaseQuality(item);
        } else {
            if (isQualityLessThan50(item)) {
                increaseQualityBy1(item);

                if (isBackstagePasses(item)) {
                    if (isTenDaysBeforeConcert(item)) {
                        increaseQualityBy1(item);
                    }

                    if (isFiveDaysBeforeConcert(item)) {
                        increaseQualityBy1(item);
                    }
                }
            }
        }
    }

    private void decreaseSellIn(Item item) {
        if (!isSulfuras(item)) {
            decreaseSellInBy1(item);
        }
    }

    private void modifyQualityWhenSellInDropsToZero(Item item) {
        if (isSellInLessThanZero(item)) {
            if (!isAgedBrie(item)) {
                if (!isBackstagePasses(item)) {
                    decreaseQuality(item);
                } else {
                    setQualityToZero(item);
                }
            } else {
                if (isQualityLessThan50(item)) {
                    increaseQualityBy1(item);
                }
            }
        }
    }

    private boolean isSellInLessThanZero(Item item) {
        return item.sellIn < 0;
    }

    private boolean isNotAgedBrieAndBackstagePasses(Item item) {
        return !isAgedBrie(item) && !isBackstagePasses(item);
    }

    private boolean isFiveDaysBeforeConcert(Item item) {
        return item.sellIn < 6 && isQualityLessThan50(item);
    }

    private boolean isTenDaysBeforeConcert(Item item) {
        return item.sellIn < 11 && isQualityLessThan50(item);
    }

    private boolean isQualityLessThan50(Item item) {
        return item.quality < 50;
    }

    private void increaseQualityBy1(Item item) {
        item.quality += 1;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0 && !isSulfuras(item)) {
            decreaseQualityBy1(item);
            if (isConjured(item)) {
                decreaseQualityBy1(item);
            }
        }
    }

    private void decreaseQualityBy1(Item item) {
        item.quality -= 1;
    }

    private void decreaseSellInBy1(Item item) {
        item.sellIn -= 1;
    }

    private void setQualityToZero(Item item) {
        item.quality = 0;
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }

    private boolean isConjured(Item item) {
        return item.name.equals(CONJURED) && item.quality != 0;
    }
}