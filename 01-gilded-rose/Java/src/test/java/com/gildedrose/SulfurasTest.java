package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class SulfurasTest {
    GildedRose app;
    Item[] items;
    String itemName = "Sulfuras, Hand of Ragnaros";
    int sellIn = 0;
    int quality = 80;
    int numberOfUpdates = 3;

    @Test
    void sulfurasItem_ShouldCreateProperly() {
        items = new Item[] { new Item(itemName, 0, 0) };
        app = new GildedRose(items);

        assertThat(app.items[0].name).isEqualToIgnoringCase(itemName);
    }

    @Test
    void sellIn_ShouldNotChange_WhenUpdatedOnce() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn);
    }

    @Test
    void sellIn_ShouldNotChange_WhenUpdatedMultipleTimes() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].sellIn).isEqualTo(sellIn);
    }

    @Test
    void quality_ShouldNotChange_WhenPositiveSellInAndUpdatedOnce() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality);
    }

    @Test
    void quality_ShouldNotChange_WhenPositiveSellInAndUpdatedMultipleTimes() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(quality);
    }

    @Test
    void quality_ShouldNotChange_WhenNegativeSellInAndUpdatedOnce() {
        int sellIn = -2;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality);
    }

    @Test
    void quality_ShouldNotChange_WhenNegativeSellInAndUpdatedMultipleTimes() {
        int sellIn = -2;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(quality);
    }
}
