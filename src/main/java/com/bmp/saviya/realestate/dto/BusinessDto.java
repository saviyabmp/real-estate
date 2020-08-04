package com.bmp.saviya.realestate.dto;

import lombok.Data;

@Data
public class BusinessDto {

    private Long id;

    private String name;

    private String description;

    private int status;

    private GeoLocationDto geoLocation;

    private CategoryDto category;

    public Long getId() {
        return id;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public GeoLocationDto getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocationDto geoLocation) {
        this.geoLocation = geoLocation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
