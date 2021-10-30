package com.shop.demo.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.shop.demo.exception.OverWeightBasketException;
import com.shop.demo.exception.ProhibitedItemException;
import com.shop.demo.model.Item;
import com.shop.demo.model.ItemType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BasketServiceTest {

    @Autowired
    BasketService basketService;

    @BeforeEach
    public void resetBasket() {
        basketService.clearItems();
    }

    @Test
    void test_AddOnlySupportedTypes_WithinMaxCapacity_AddsSuccessfully() throws ProhibitedItemException, OverWeightBasketException {
        Item apples1kg =
            Item.of(1l, "Apple", "Green Apples", ItemType.FRUIT, 1000);
        Item oranges1kg =
        Item.of(2l, "Orange", "Orange", ItemType.FRUIT, 1000);

        Item cucumber500g =
        Item.of(3l, "Cucumber", "Organic Cucumber", ItemType.VEG, 500);

        Item carrot500g =
        Item.of(3l, "Carrot", "Ooty Carrot", ItemType.VEG, 500);

        basketService.addItem(apples1kg);
        basketService.addItem(oranges1kg);
        basketService.addItem(cucumber500g);
        basketService.addItem(carrot500g);

    }
   
    @Test
    void test_AddProhibitedItem_throwsExeption() throws ProhibitedItemException, OverWeightBasketException {
        Item appleIphone =
            Item.of(1l, "Apple iPhone 12", "Best iPhone Yet", ItemType.ELECTRONICS, 180);

        assertThrows(ProhibitedItemException.class, () -> basketService.addItem(appleIphone) );
    }

    @Test
    void test_AddItems_GreaterThanMaxCapacity_throwsExeption() throws ProhibitedItemException, OverWeightBasketException {
        Item apples3kg =
            Item.of(1l, "Apple", "Green Apples", ItemType.FRUIT, 3000);
        Item carrot500g =
            Item.of(3l, "Carrot", "Ooty Carrot", ItemType.VEG, 500);
                
        assertThrows(OverWeightBasketException.class, () -> { basketService.addItem(apples3kg); basketService.addItem(carrot500g);} );
        
        Item carrot4kg =
            Item.of(4l, "Carrot", "Ooty Carrot", ItemType.VEG, 4000);

        assertThrows(OverWeightBasketException.class, () -> basketService.addItem(carrot4kg) );


    }

}
