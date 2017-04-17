package io.gopulu.retailmanager.dao;

import io.gopulu.retailmanager.domain.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by lingrajmahanand on 4/9/17.
 */
@Repository
public class ShopDaoImpl implements ShopDao {
    private static ConcurrentHashMap<String, Shop> shopMap;

    static {
        shopMap = new ConcurrentHashMap<>();

        Shop shop1 = new Shop.ShopBuilder("Gopulu").setLatitude(1).setLongitude(2).build();
        shopMap.put(shop1.getName(), shop1);

        Shop shop2 = new Shop.ShopBuilder("kanika").setLatitude(1).setLongitude(2).build();
        shopMap.put(shop2.getName(),shop2);
    }

    public static ConcurrentHashMap<String, Shop> getShopMap() {
        return shopMap;
    }

    public static void setShopMap(ConcurrentHashMap<String, Shop> shopMap) {
        ShopDaoImpl.shopMap = shopMap;
    }

    @Override
    public Shop getShop(String name) {
        return shopMap.get(name);
    }

    @Override
    public Shop addShop(Shop shop) {
        if(shopMap.containsKey(shop.getName())){
            shopMap.replace(shop.getName(),shop);
        }else {
            shopMap.putIfAbsent(shop.getName(), shop);
        }
        return shop;
    }

    @Override
    public List<Shop> getShops() {
        return shopMap.entrySet().stream().map(shopName -> shopName.getValue()).collect(Collectors.toList());
    }
}
