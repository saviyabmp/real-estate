package com.bmp.saviya.realestate.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestDto {

	private BusinessDto business;

}
