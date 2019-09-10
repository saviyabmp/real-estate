package com.bmp.saviya.realestate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "geo_location")
@NamedQuery(name = "GeoLocation.findAll", query = "SELECT p FROM GeoLocation p")
public class GeoLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double latitude;

	private Double longitude;
}
