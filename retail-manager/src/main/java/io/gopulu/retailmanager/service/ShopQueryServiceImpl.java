package io.gopulu.retailmanager.service;

import io.gopulu.retailmanager.dao.ShopDao;
import io.gopulu.retailmanager.domain.LocationCoordinates;
import io.gopulu.retailmanager.domain.NearestShop;
import io.gopulu.retailmanager.domain.Shop;
import io.gopulu.retailmanager.domain.ShopFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopQueryServiceImpl implements ShopQueryService {

    @Autowired
    private ShopDao shopDao;

    @Autowired
    LocationCoordinates locationCoordinates;

    @Autowired
    NearestShop nearestShop;

    @Override
    public Shop getShop(String name) {
        return shopDao.getShop(name);
    }


    @Override
    public List<Shop> getShops() {
        return shopDao.getShops();
    }

    @Override
    public Shop addShop(io.gopulu.retailmanager.dto.Shop shop) {

        locationCoordinates.populateLatAndLng(shop.getNumber(),shop.getPostCode());

        Shop shopValueObject = ShopFactory.createShop(shop.getName(),shop.getNumber(),shop.getPostCode(), locationCoordinates);
        return shopDao.addShop(shopValueObject);
    }

    @Override
    public Shop findNearestShop(double lat, double lng) {
        return nearestShop.findNearestShop(lat,lng);
    }

}
