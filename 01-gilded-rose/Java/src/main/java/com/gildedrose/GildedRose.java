package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for(Item item : items){
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) { //all except aged brie and backstage passes
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) { //all except aged brie, backstage passes and sulfuras
                        item.quality = item.quality - 1; //quality decrease
                    }
                }
            } else { //aged brie and backstage passes
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) { //backstage passes rapid increase
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) { //decrease sell in for all except sulfuras
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) { //all except aged brie
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) { //all except backstage passes
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) { //all except sulfuras quality decrease
                                item.quality = item.quality - 1;
                            }
                        }
                    } else { //for backstage passes quality 0
                        item.quality = 0;
                    }
                } else { //only aged brie quality increase
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}