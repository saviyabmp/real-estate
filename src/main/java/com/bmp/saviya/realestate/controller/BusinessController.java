package com.bmp.saviya.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmp.saviya.realestate.dto.RequestDto;
import com.bmp.saviya.realestate.dto.ResponseDto;
import com.bmp.saviya.realestate.service.BusinessService;

@RestController
@RequestMapping("v1/hela/")
public class BusinessController {

	private final BusinessService businessService;

	@Autowired
	public BusinessController(final BusinessService businessService) {
		this.businessService = businessService;
	}

	@PostMapping("business")
	public ResponseEntity<?> addBusiness(@RequestBody RequestDto requestDto) {

		ResponseDto res = businessService.addBusiness(requestDto);

		return new ResponseEntity<ResponseDto>(res, HttpStatus.OK);

	}

}
