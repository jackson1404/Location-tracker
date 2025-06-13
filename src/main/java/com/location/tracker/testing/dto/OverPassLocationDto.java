///***************************************************************
// * Author       :
// * Created Date :
// * Version      :
// * History  :
// * *************************************************************/
//package com.location.tracker.testing.dto;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * OverPassResponseDto Class.
// * <p>
// * </p>
// *
// * @author
// */
//
//public class OverPassLocationDto {
//    private List<Element> elements;
//
//    public List<LocationPointDto> toLocationPointDtoList() {
//        List<LocationPointDto> list = new ArrayList<>();
//        for (Element el : elements) {
//            LocationPointDto dto = new LocationPointDto();
//            dto.setLat(el.getLat());
//            dto.setLon(el.getLon());
//            dto.setName(el.getTags().getOrDefault("name", "Unknown"));
//            dto.setType(el.getTags().get("amenity"));
//            list.add(dto);
//        }
//        return list;
//    }
//
//    public List<Element> getElements() {
//        return elements;
//    }
//
//    public void setElements(List<Element> elements) {
//        this.elements = elements;
//    }
//
//    public static class Element {
//        private double lat;
//        private double lon;
//        private Map<String, String> tags;
//
//        public double getLat() { return lat; }
//        public void setLat(double lat) { this.lat = lat; }
//        public double getLon() { return lon; }
//        public void setLon(double lon) { this.lon = lon; }
//        public Map<String, String> getTags() { return tags; }
//        public void setTags(Map<String, String> tags) { this.tags = tags; }
//    }
//}
