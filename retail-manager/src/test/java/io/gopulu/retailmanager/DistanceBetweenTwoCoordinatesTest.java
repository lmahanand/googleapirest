package io.gopulu.retailmanager;

import io.gopulu.retailmanager.domain.LocationCoordinates;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lingrajmahanand on 4/17/17.
 */
public class DistanceBetweenTwoCoordinatesTest {
    @Test
    public void testDistanceBetweenTwoCoordinatesOfSameLocation(){
        double lat1 = 18.5925785;
        double lng1 = 73.7183639;

        double lat2 = 18.5925785;
        double lng2 = 73.7183639;
        LocationCoordinates coordinates = new LocationCoordinates();

    }

    @Test
    public void testDistanceBetweenTwoCoordinatesOfNearLocation(){

        double lat1 = 18.6059373;
        double lng1 = 73.75262380000004;

        double lat2 = 18.6067 ;
        double lng2 = 73.752423;
        LocationCoordinates coordinates = new LocationCoordinates();

        // Below assertion finds that both the locations
        // are near since distance between both is less than 0.01 KM

        Assert.assertEquals(0.08740849360184112,coordinates.distanceBetweenTwoCoordinates(lat1,lng1,lat2,lng2),0.0);
    }

    @Test
    public void testDistanceBetweenTwoCoordinatesOfFarLocation(){
        double lat1 = 18.6059373;
        double lng1 = 73.75262380000004;

        double lat2 = 18.57596539447271 ;
        double lng2 = 73.76152038574219;
        LocationCoordinates coordinates = new LocationCoordinates();

        // Below assertion finds that both the locations
        // are far since distance between both is greater than 0.01 KM

        Assert.assertEquals(3.4621101765456497,coordinates.distanceBetweenTwoCoordinates(lat1,lng1,lat2,lng2),0.0);
    }
}
