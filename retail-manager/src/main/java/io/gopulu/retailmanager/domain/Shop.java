package io.gopulu.retailmanager.domain;


public class Shop {
    /**
     * unique name for each of the shops
     */
    final private String name;

    /**
     * latitude value in degrees
     */
    private double latitude;

    /**
     * longitude value in degrees
     */
    private double longitude;

    /**
     * Address of the shop which has number and postal code
     */
    private Address address;


    private Shop(ShopBuilder shopBuilder) {
        this.name = shopBuilder.name;
        this.latitude = shopBuilder.latitude;
        this.longitude = shopBuilder.longitude;
        this.address = shopBuilder.address;
    }

    public String getName() {
        return name;
    }


    public double getLatitude() {
        return latitude;
    }


    public double getLongitude() {
        return longitude;
    }

    public Address getAddress() {
        return address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        return name.equals(shop.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }


    public static class ShopBuilder {
        private String name;

        private double latitude;
        private double longitude;

        private Address address;

        public ShopBuilder(String name) {
            this.name = name;
        }

        public ShopBuilder setLatitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public ShopBuilder setLongitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public ShopBuilder setAddress(String shopNumber, String postCode) {
            this.address = new Address(shopNumber, postCode);
            return this;
        }

        public Shop build() {
            return new Shop(this);
        }
    }
}
