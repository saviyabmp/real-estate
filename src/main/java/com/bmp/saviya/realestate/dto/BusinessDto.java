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

}
