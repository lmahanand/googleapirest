package io.gopulu.retailmanager.controller;


import io.gopulu.retailmanager.domain.Shop;

import java.util.List;



public interface RetailManagerController {

    public List<Shop> getShops();

    public Shop getShop(String name);

    public Shop addShop(io.gopulu.retailmanager.dto.Shop dto);

    public Shop findNearestShop(double lat, double lng);
}
