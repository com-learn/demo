package com.shop.demo.service;

import java.util.List;

import com.shop.demo.exception.OverWeightBasketException;
import com.shop.demo.exception.ProhibitedItemException;
import com.shop.demo.model.Item;
import com.shop.demo.model.ItemType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;


@Builder
@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE)
public class BasketTemplate {

    @NonNull
    List<Item> items;
    @NonNull
    List<ItemType> supportedTypes;
    @NonNull
    Integer maxCapacity;
    
    public void addItem(Item item) throws OverWeightBasketException, ProhibitedItemException {
        
        if(!isTypeSupported(item.getItemType()))             
            throw new ProhibitedItemException();

        if(!isCapacityAvailable(item.getItemQty()))
            throw new OverWeightBasketException();
        
        items.add(item);
        
    }

    public void clearItems() {
        items.clear();
    }

    public int getBasketSize(){
        return items.size();
    }

    private int getCurrentCapacity(){
        return items.stream().mapToInt(e->e.getItemQty().intValue()).sum();
    }

    private boolean isTypeSupported(ItemType itemType){
        return supportedTypes.contains(itemType);
    }
    
    private boolean isCapacityAvailable(int itemQty) {
        return (getCurrentCapacity() + itemQty <= maxCapacity);
    }

}
