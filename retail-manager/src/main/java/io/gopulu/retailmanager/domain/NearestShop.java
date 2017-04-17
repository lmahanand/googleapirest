package io.gopulu.retailmanager.domain;

import io.gopulu.retailmanager.dao.ShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 *
 */
@Component
public class NearestShop {
    @Autowired
    private LocationCoordinates locationCoordinates;

    @Autowired
    private ShopDao shopDao;

    public Shop findNearestShop(double lat, double lng) {
        final List<Shop> shops = shopDao.getShops();
        final List<Shop> nearestShops = findAllNearestShops(shops, lat,lng);

        return findNearestShop(nearestShops, lat, lng);
    }

    private Shop findNearestShop(List<Shop> nearestShops, double lat, double lng) {
        Map<String, Double> shopMap = new ConcurrentHashMap<>();

        for (Shop s : nearestShops) {
            shopMap.put(s.getName(), locationCoordinates.distanceBetweenTwoCoordinates(lat, lng, s.getLatitude(), s.getLongitude()));
        }
        Set<Map.Entry<String, Double>> entries = shopMap.entrySet();
        Optional<Map.Entry<String, Double>> nearestShop = entries.stream().sorted((m2, m1) -> m2.getValue().compareTo(m1.getValue())).findFirst();

        if(!nearestShop.isPresent()){
            return new Shop.ShopBuilder("Sorry, no nearest shop found.").build();
        }
        return shopDao.getShop(nearestShop.get().getKey());
    }

    /**
     *
     * @param shops
     * @param lat
     * @param lng
     * @return
     */
    private List<Shop> findAllNearestShops(List<Shop> shops, double lat, double lng) {
        return shops.stream().filter(s ->
                locationCoordinates.distanceBetweenTwoCoordinates(lat, lng, s.getLatitude(), s.getLongitude()) < 0.1)
                .collect(Collectors.toList());
    }
}
