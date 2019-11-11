package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ConjuredTest {
    GildedRose app;
    Item[] items;
    String itemName = "Conjured Mana Cake";
    int sellIn = 5;
    int quality = 15;
    int numberOfUpdates = 3;
    int dropRate = 2;

    @Test
    void conjuredItem_ShouldCreateProperly() {
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

        assertThat(app.items[0].quality).isEqualTo(quality - dropRate);
    }

    @Test
    void quality_ShouldDropProperly_WhenPositiveSellInAndUpdatedMultipleTimes() {
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(quality - dropRate * numberOfUpdates);
    }

    @Test
    void quality_ShouldDropProperly_WhenNegativeSellInAndUpdatedOnce() {
        int sellIn = -2;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(quality - 2 * dropRate);
    }

    @Test
    void quality_ShouldDropProperly_WhenNegativeSellInAndUpdatedMultipleTimes() {
        int sellIn = -2;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(quality - 2 * dropRate * numberOfUpdates);
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
        int quality = 1;
        items = new Item[] { new Item(itemName, sellIn, quality) };

        app = new GildedRose(items);
        for(int i = 0; i < numberOfUpdates; i++){
            app.updateQuality();
        }

        assertThat(app.items[0].quality).isEqualTo(0);
    }
}
