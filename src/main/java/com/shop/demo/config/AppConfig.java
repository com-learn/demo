package com.shop.demo.config;

import java.util.ArrayList;
import java.util.List;

import com.shop.demo.model.ItemType;
import com.shop.demo.service.BasketTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    BasketTemplate basketTemplate() {
        return BasketTemplate.builder()
            .items(new ArrayList<>())
            .supportedTypes(List.of(ItemType.FRUIT, ItemType.VEG))
            .maxCapacity(3000)
            .build();
    }
    
}
