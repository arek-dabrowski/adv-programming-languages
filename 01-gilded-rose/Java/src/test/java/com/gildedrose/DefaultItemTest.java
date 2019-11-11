package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultItemTest {
    GildedRose app;
    Item[] items;
    String itemName = "+5 Dexterity Vest";
    int sellIn = 5;
    int quality = 15;
    int numberOfUpdates = 3;

    @Test
    void defaultItem_ShouldCreateProperly() {
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
    void quality_ShouldDropProperly_WhenPositiveSellInAndUpdatedOnce() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality - 1);
    }

    @Test
    void quality_ShouldDropProperly_WhenPositiveSellInAndUpdatedMultipleTimes() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(quality - numberOfUpdates);
    }

    @Test
    void quality_ShouldDropProperly_WhenNegativeSellInAndUpdatedOnce() {
        int sellIn = -2;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality - 2);
    }

    @Test
    void quality_ShouldDropProperly_WhenNegativeSellInAndUpdatedMultipleTimes() {
        int sellIn = -3;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(quality - 2 * numberOfUpdates);
    }

    @Test
    void quality_CannotBeNegative_WhenUpdatedOnce() {
        int quality = 1;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void quality_CannotBeNegative_WhenUpdatedMultipleTimes() {
        int quality = 2;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(0);
    }
}
