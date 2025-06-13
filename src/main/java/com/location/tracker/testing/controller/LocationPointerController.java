/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.controller;

import com.location.tracker.testing.dto.LocationPointDto;
import com.location.tracker.testing.dto.NominatimResponseDto;
import com.location.tracker.testing.service.LocationPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * LocationPointerController Class.
 * <p>
 * </p>
 *
 * @author
 */
@RestController
public class LocationPointerController {

    @Autowired
    private LocationPointService locationPointService;

    @GetMapping("/resolve")
    public ResponseEntity<Map<String, Double>> resolveAddressToLatLon(@RequestParam String address) {
        Map<String, Double> result = locationPointService.resolveLatLonFromAddress(address);
        return ResponseEntity.ok(result); // Contains "lat" and "lon"
    }

    @GetMapping("/nearBy")
    public ResponseEntity<List<Map<String, Object>>> fetchNearByPOIs(@RequestParam String userAddress,
                                                                     @RequestParam String type
    ) throws InterruptedException {
        List<Map<String, Object>> result = locationPointService.fetchNearByPOIs(userAddress, type);

        return ResponseEntity.ok(result);

    }



}
