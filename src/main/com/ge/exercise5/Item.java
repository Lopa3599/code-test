package com.ge.exercise5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Item {

    private static final Logger logger = LogManager.getLogger(Item.class);

    public ItemType type;
    public int value;
    public int sellBy;

    public Item(ItemType itemType, int value, int sellBy) {
        this.type = itemType;
        this.value = value;
        this.sellBy = sellBy;
    }

    public ItemType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSellBy() {
        return sellBy;
    }

    public void setSellBy(int sellBy) {
        this.sellBy = sellBy;
    }
}
