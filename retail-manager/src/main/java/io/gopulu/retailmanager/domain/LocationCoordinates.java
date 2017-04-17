package io.gopulu.retailmanager.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * It retrieves the coordinates of lattitude and longitude
 */
@Component
public class LocationCoordinates {
    private double lat;
    private double lng;

    public void populateLatAndLng(String number, String postCode) {
        final RestTemplate restTemplate = new RestTemplate();
        final String geoCodeLink = createGeoCodeLink(number, postCode);
        final String geoCodeJson = restTemplate.getForObject(geoCodeLink, String.class);

        final JsonNode location = parseJsonForLocation(geoCodeJson);

        this.lat = getLat(location);
        this.lng = getLng(location);

    }

    /**
     * Calculates the distance between two locations in Kilometer
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return distance in kilometers
     */
    public double distanceBetweenTwoCoordinates(double lat1, double lng1, double lat2, double lng2) {

        final double dLat = Math.toRadians(lat2-lat1);
        final double dLng = Math.toRadians(lng2-lng1);

        final double sindLat = Math.sin(dLat / 2);
        final double sindLng = Math.sin(dLng / 2);

        final double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));

        final double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        final double dist = Const.EARTH_RADIUS * c;

        return dist; // output distance, in KILOMETER
    }

    private JsonNode parseJsonForLocation(String geoCodeJson) {
        final ObjectMapper mapper = new ObjectMapper();
        JsonNode results = null;
        JsonNode location = null;
        try {
            results = mapper.readTree(geoCodeJson);
        } catch (IOException ioe) {
            System.err.println(ioe.getStackTrace());
        }

        if (results != null) {
            List<JsonNode> geometry = results.findValues(Const.GEOMETRY);

            location = geometry.get(0).findValue(Const.LOCATION);
        }
        return location;

    }

    private double getLat(JsonNode location) {
        JsonNode lat = location.findValue("lat");
        return Double.valueOf(lat.toString());
    }

    private double getLng(JsonNode location) {
        JsonNode lng = location.findValue("lng");
        return Double.valueOf(lng.toString());
    }

    private String createGeoCodeLink(String number, String postCode) {
        return Const.GEOCODE_LINK + number + "," + postCode + Const.PATH_VAR_KEY + Const.GEOCODE_KEY;
    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }

}
