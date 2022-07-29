package com.sda;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationController {

    private LocationService locationService = new LocationService();
    private ObjectMapper objectMapper = new ObjectMapper();

    //POST
    public String createLocation(String json) {
        try {
            LocationDTO locationDTO = objectMapper.readValue(json, LocationDTO.class);
            Location location = locationService.create(locationDTO.getCity(), locationDTO.getRegion(), locationDTO.getCountry(), locationDTO.getLongitude(), locationDTO.getLatitude());
            LocationDTO response = mapToLocationDTO(location);
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            return String.format("{\"errorMessage\": %s}", e.getMessage());
        }

    }

    private LocationDTO mapToLocationDTO(Location location) {
        return LocationDTO.builder()
                .id(location.getId())
                .city(location.getCity())
                .region(location.getRegion())
                .country(location.getCountry())
                .longitude(location.getLongitude())
                .latitude(location.getLatitude())
                .build();
        /*LocationDTO response = new LocationDTO();
        response.setId(location.getId());
        response.setCity(location.getCity());
        response.setRegion(location.getRegion());
        response.setCountry(location.getCountry());
        response.setLongitude(location.getLongitude());
        response.setLatitude(location.getLatitude());*/
    }
}