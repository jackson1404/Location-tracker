/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.location.tracker.testing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * NominatinResponseDto Class.
 * <p>
 * </p>
 *
 * @author
 */

public class NominatimResponseDto {

    @JsonProperty("lat")
    private Double lat;

    @JsonProperty("lon")
    private Double lon;

    @JsonProperty("display_name")
    private String displayName;

    private Double distanceFromCurrent;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Double getDistanceFromCurrent() {
        return distanceFromCurrent;
    }

    public void setDistanceFromCurrent(Double distanceFromCurrent) {
        this.distanceFromCurrent = distanceFromCurrent;
    }
}
