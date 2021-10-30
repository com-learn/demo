package com.shop.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Item {
    Long itemId;
    String itemName;
    String itemDescription;
    ItemType ItemType;
    Integer itemQty;
}
