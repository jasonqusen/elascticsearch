package com.rails.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rails.elasticsearch.service.HotelService;

import io.swagger.annotations.ApiOperation;

@RestController
public class HotelController {

	@Autowired
	private HotelService hotelService;

	/**
	 * 分页及排序
	 * 
	 * @return
	 */
	@GetMapping("/query/page/sort")
	@ApiOperation(value = "分页及排序", notes ="分页及排序")
	public Object pageAndSortQuery() {
		return hotelService.pageAndSortQuery();
	}
}
