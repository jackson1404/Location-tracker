/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.service;

import com.location.tracker.testing.dto.NominatimResponseDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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

        if (response.getBody() != null && response.getBody().length > 0) {
            NominatimResponseDto loc = response.getBody()[0];
            Map<String, Double> map = new HashMap<>();
            map.put("lat", Double.parseDouble(loc.getLat()));
            map.put("lon", Double.parseDouble(loc.getLon()));
            return map;
        } else {
            throw new RuntimeException("Unable to find location for address: " + address);
        }
    }


}
