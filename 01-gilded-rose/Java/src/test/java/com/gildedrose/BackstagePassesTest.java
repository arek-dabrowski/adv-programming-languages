package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackstagePassesTest {
    GildedRose app;
    Item[] items;
    String itemName = "Backstage passes to a TAFKAL80ETC concert";
    int sellIn = 15;
    int quality = 5;
    int numberOfUpdates = 3;

    @Test
    void backstagePassesItem_ShouldCreateProperly() {
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
    void quality_ShouldIncreaseProperly_WhenSellInMoreThanTenAndUpdatedOnce() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality + 1);
    }

    @Test
    void quality_ShouldIncreaseProperly_WhenSellInMoreThanTenAndUpdatedMultipleTimes() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(quality + numberOfUpdates);
    }

    @Test
    void quality_ShouldIncreaseProperly_WhenSellInBetweenTenAndFiveAndUpdatedOnce() {
        int increaseRate = 2;
        int sellIn = 10;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality + increaseRate);
    }

    @Test
    void quality_ShouldIncreaseProperly_WhenSellInBetweenTenAndFiveAndUpdatedMultipleTimes() {
        int increaseRate = 2;
        int sellIn = 10;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(quality + increaseRate * numberOfUpdates);
    }

    @Test
    void quality_ShouldIncreaseProperly_WhenSellInFiveOrLessAndUpdatedOnce() {
        int increaseRate = 3;
        int sellIn = 5;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality + increaseRate);
    }

    @Test
    void quality_ShouldIncreaseProperly_WhenSellInFiveOrLessAndUpdatedMultipleTimes() {
        int increaseRate = 3;
        int sellIn = 5;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(quality + increaseRate * numberOfUpdates);
    }

    @Test
    void quality_ShouldDropToZero_WhenSellInLessThanZeroAndUpdatedOnce() {
        int sellIn = 0;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void quality_ShouldDropToZero_WhenSellInLessThanZeroAndUpdatedMultipleTimes() {
        int sellIn = 1;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void quality_CannotExceed50_WhenUpdatedOnce() {
        int quality = 49;
        int sellIn = 3;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void quality_CannotExceed50_WhenUpdatedMultipleTimes() {
        int quality = 49;
        int sellIn = 5;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(50);
    }
}
