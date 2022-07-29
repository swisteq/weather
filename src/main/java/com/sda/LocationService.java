package com.sda;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class LocationService {

    public Location create(String city,String region,String country,Integer longitude,Integer latitude){

        if (city == null || city.isBlank()){
            throw new IllegalArgumentException("Pole city nie może być puste");
        }
        if (region == null || region.isBlank()){
            throw new IllegalArgumentException("Pole region nie może być puste");
        }
        if (country == null || country.isBlank()){
            throw new IllegalArgumentException("Pole country nie może być puste");
        }
        if (longitude == null){
            throw new IllegalArgumentException("Pole longitude nie może być puste");
        }
        if (latitude == null){
            throw new IllegalArgumentException("Pole latitude nie może być puste");
        }

        Location location = new Location();
        location.setCity(city);
        location.setRegion(region);
        location.setCountry(country);
        location.setLongitude(longitude);
        location.setLatitude(latitude);
        location.setCreatedDate(Instant.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));

        LocationRepository locationRepository = new LocationRepository();
        Location savedLocation = locationRepository.save(location);

        return savedLocation;
    }
}