package io.gopulu.retailmanager.domain;

public class ShopFactory {
    public static Shop createShop(String name, String number, String postCode, LocationCoordinates location) {
        return new Shop.ShopBuilder(name).setAddress(number, postCode).setLatitude(location.getLat()).setLongitude(location.getLng()).build();
    }
}
