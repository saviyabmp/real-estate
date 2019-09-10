package com.bmp.saviya.realestate.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmp.saviya.realestate.dto.RequestDto;
import com.bmp.saviya.realestate.dto.ResponseDto;
import com.bmp.saviya.realestate.model.Business;
import com.bmp.saviya.realestate.model.Category;
import com.bmp.saviya.realestate.repository.BusinessRepository;
import com.bmp.saviya.realestate.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {

	private final BusinessRepository businessRepository;
	//private final ModelMapper mapper;

	@Autowired
	public BusinessServiceImpl(final BusinessRepository businessRepository ) {
		this.businessRepository = businessRepository;
		//this.mapper = mapper;
	}

	@Override
	public ResponseDto addBusiness(RequestDto requestDto) {

		// convert entity
		Business bus = new Business();
		Category cat = new Category();
		cat.setId(requestDto.getBusiness().getCategory().getId());
		bus.setCategory(cat);
		bus.setName(requestDto.getBusiness().getName());
		bus.setDescription(requestDto.getBusiness().getDescription());
		bus.setStatus(requestDto.getBusiness().getStatus());
		businessRepository.save(bus);

		return null;
	}

}
