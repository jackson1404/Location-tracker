/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.service;

import com.location.tracker.testing.dto.LocationPointDto;
import com.location.tracker.testing.dto.NominatimResponseDto;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * LocationPointService Class.
 * <p>
 * </p>
 *
 * @author
 */
@Service
public class LocationPointService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Double> resolveLatLonFromAddress(String address) {
        String url = String.format("https://nominatim.openstreetmap.org/search?q=%s&format=json&limit=1",
                                   UriUtils.encodeQueryParam(address, StandardCharsets.UTF_8));

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "LocationTracker/1.0 (location-tracker@email.com)");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<NominatimResponseDto[]> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, NominatimResponseDto[].class
        );

        response.getBody();
        if (response.getBody().length > 0) {
            NominatimResponseDto loc = response.getBody()[0];
            Map<String, Double> map = new HashMap<>();
            map.put("lat", loc.getLat());
            map.put("lon", loc.getLon());
            return map;
        } else {
            throw new RuntimeException("Unable to find location for address: " + address);
        }
    }


    public List<Map<String, Object>> fetchNearByPOIs(String userAddress, String type) throws InterruptedException {
        Map<String, Double> userLocation = resolveLatLonFromAddress(userAddress);

        Thread.sleep(1100); // Respect Nominatim rate limit

        double userLat = userLocation.get("lat");
        double userLon = userLocation.get("lon");

//        userLat = userLat;
//        userLon = userLon;

        String searchQuery = String.format("%s+NEAR+%s", type, userAddress);  //need to have correct syntax for the search query
        Thread.sleep(1000);
        String url = String.format("https://nominatim.openstreetmap.org/search?q=%s&format=json&limit=5",
                                   UriUtils.encodeQueryParam(searchQuery, StandardCharsets.UTF_8));

        System.out.println("the url is " + url);
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "LocationTracker/1.0 (location-tracker@email.com)");
        headers.set("Accept", "application/json");

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<NominatimResponseDto[]> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, NominatimResponseDto[].class
        );

        if (response.getBody() == null || response.getBody().length == 0) {
            return Collections.emptyList();
        }

        List<Map<String, Object>> result = new ArrayList<>();
        for (NominatimResponseDto dto : response.getBody()) {
            double poiLat = dto.getLat();
            double poiLon = dto.getLon();
            double distance = calculateDistance(userLat, userLon, poiLat, poiLon);

            Map<String, Object> map = new HashMap<>();
            map.put("display_name", trimDisplayName(dto.getDisplayName()));
            map.put("lat", poiLat);
            map.put("lon", poiLon);
            map.put("distance_in_km", String.format("%3f km", distance));
            result.add(map);
        }
        return result;
    }

    private String trimDisplayName(String fullDisplayName) {
        String[] parts = fullDisplayName.split(",\\s*");
        StringBuilder builder = new StringBuilder();
        for (String part : parts) {
            builder.append(part);
            if (part.contains("မြို့")) break; // Stop at "မြို့" (city-level)
            builder.append(", ");
        }
        return builder.toString().trim().replaceAll(",\\s*$", ""); // Remove trailing comma
    }


//    private String trimDisplayName(String fullDisplayName) {
//        String[] parts = fullDisplayName.split(",\\s*");
//        int limit = Math.min(parts.length, 4); // Get up to 4 parts if available
//        return String.join(", ", Arrays.copyOfRange(parts, 0, limit));
//    }


    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {

        final int R = 6371; // Radius of Earth in km

        double latDist = Math.toRadians(lat2 - lat1);

        double lonDist = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDist / 2) * Math.sin(latDist / 2)

                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))

                * Math.sin(lonDist / 2) * Math.sin(lonDist / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;

    }



}
