package io.gopulu.retailmanager.dao;

import io.gopulu.retailmanager.domain.Shop;

import java.util.List;

/**
 * Created by lingrajmahanand on 4/9/17.
 */
public interface ShopDao {
    public Shop getShop(String name);
    public Shop addShop(Shop shop);
    public List<Shop> getShops();
}
