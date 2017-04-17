package io.gopulu.retailmanager.service;

import io.gopulu.retailmanager.domain.Shop;

import java.util.List;


public interface ShopQueryService {
    public Shop getShop(String name);
    public List<Shop> getShops();
    public Shop addShop(io.gopulu.retailmanager.dto.Shop shop);
    public Shop findNearestShop(double lat, double lng);
}
