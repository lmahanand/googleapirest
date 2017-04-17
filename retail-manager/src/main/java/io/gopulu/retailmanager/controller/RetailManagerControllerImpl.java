package io.gopulu.retailmanager.controller;

import io.gopulu.retailmanager.domain.Shop;

import io.gopulu.retailmanager.service.ShopQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
public class RetailManagerControllerImpl implements RetailManagerController {

    @Autowired
    private ShopQueryService shopQueryService;

    @RequestMapping("/shops")
    public List<Shop> getShops() {
        return shopQueryService.getShops();
    }

    @RequestMapping("/shops/{lat}/{lng}")
    @Override
    public Shop findNearestShop(@PathVariable double lat, @PathVariable double lng) {
        return shopQueryService.findNearestShop(lat, lng);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "/shops")
    public Shop addShop(@RequestBody io.gopulu.retailmanager.dto.Shop dto) {
        return shopQueryService.addShop(dto);
    }

    @RequestMapping("/shops/{name}")
    public Shop getShop(@PathVariable String name) {
        Shop shop = shopQueryService.getShop(name);
        return shop;
    }
}
