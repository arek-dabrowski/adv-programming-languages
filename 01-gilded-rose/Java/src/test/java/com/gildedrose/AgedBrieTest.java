package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AgedBrieTest {
    GildedRose app;
    Item[] items;
    String itemName = "Aged Brie";
    int sellIn = 5;
    int quality = 5;
    int numberOfUpdates = 3;

    @Test
    void agedBrieItem_ShouldCreateProperly() {
        items = new Item[] { new Item(itemName, 0, 0) };
        app = new GildedRose(items);

        assertThat(app.items[0].name).isEqualToIgnoringCase(itemName);
    }

    @Test
    void sellIn_ShouldDropProperly_WhenUpdatedOnce() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - 1);
    }

    @Test
    void sellIn_ShouldDropProperly_WhenUpdatedMultipleTimes() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].sellIn).isEqualTo(sellIn - numberOfUpdates);
    }

    @Test
    void quality_ShouldIncreaseProperly_WhenPositiveSellInAndUpdatedOnce() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality + 1);
    }

    @Test
    void quality_ShouldIncreaseProperly_WhenPositiveSellInAndUpdatedMultipleTimes() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(quality + numberOfUpdates);
    }

    @Test
    void quality_ShouldIncreaseProperly_WhenNegativeSellInAndUpdatedOnce() {
        int sellIn = -2;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality + 2);
    }

    @Test
    void quality_ShouldIncreaseProperly_WhenNegativeSellInAndUpdatedMultipleTimes() {
        int sellIn = -2;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(quality + 2 * numberOfUpdates);
    }

    @Test
    void quality_CannotExceed50_WhenPositiveSellInAndUpdatedOnce() {
        int quality = 49;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void quality_CannotExceed50_WhenPositiveSellInAndUpdatedMultipleTimes() {
        int quality = 49;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void quality_CannotExceed50_WhenNegativeSellInAndUpdatedOnce() {
        int sellIn = -2;
        int quality = 49;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void quality_CannotExceed50_WhenNegativeSellInAndUpdatedMultipleTimes() {
        int sellIn = -2;
        int quality = 49;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(50);
    }
}
