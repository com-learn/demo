package com.shop.demo.service;

import com.shop.demo.exception.OverWeightBasketException;
import com.shop.demo.exception.ProhibitedItemException;
import com.shop.demo.model.Item;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Component
@Slf4j
@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE)
public class BasketServiceImpl implements BasketService {
    
    BasketTemplate basketTemplate;

    public void addItem(Item item) throws ProhibitedItemException, OverWeightBasketException {
        basketTemplate.addItem(item);
    }
    public void clearItems() {
        log.info("clearing items...");
        basketTemplate.clearItems();
    }
    
    public int getItemCount(){
        return basketTemplate.getBasketSize();
    }
}
