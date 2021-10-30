package com.shop.demo.service;

import com.shop.demo.exception.OverWeightBasketException;
import com.shop.demo.exception.ProhibitedItemException;
import com.shop.demo.model.Item;

public interface BasketService {
    public void addItem(Item item) throws ProhibitedItemException, OverWeightBasketException;
    public void clearItems();
    public int getItemCount();
}
