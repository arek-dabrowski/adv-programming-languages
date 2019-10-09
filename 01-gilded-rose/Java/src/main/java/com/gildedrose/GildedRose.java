package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { //all except aged brie and backstage passes
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { //all except aged brie, backstage passes and sulfuras
                        items[i].quality = items[i].quality - 1; //quality decrease
                    }
                }
            } else { //aged brie and backstage passes
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { //backstage passes rapid increase
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { //decrease sell in for all except sulfuras
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) { //all except aged brie
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { //all except backstage passes
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { //all except sulfuras quality decrease
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else { //for backstage passes quality 0
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else { //only aged brie quality increase
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}