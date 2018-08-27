package com.rails.elasticsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rails.elasticsearch.document.Hotel;
import com.rails.elasticsearch.service.HotelService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	/**
	 * 分页及排序
	 * 
	 * @return
	 */
	@GetMapping("/hotel/page/sort")
	@ApiOperation(value = "分页及排序", notes = "分页及排序")
	public Page<Hotel> pageAndSortQuery() {
		return hotelService.pageAndSortQuery();
	}

	/**
	 * term查询
	 * 
	 * @return
	 */
	@GetMapping("/hotel/term")
	@ApiOperation(value = "term查询", notes = "term查询")
	public Iterable<Hotel> termQuery() {
		return hotelService.termQuery();
	}

	/**
	 * 根据商业区名称查找
	 * 
	 * @return
	 */
	@GetMapping("/hotel/cityName")
	@ApiOperation(value = "根据城市名称查找", notes = "根据城市名称查找")
	public List<Hotel> findByCityName(@RequestParam String cityName) {
		return hotelService.findByCityName(cityName);
	}

	/**
	 * 根据商业区名称查找
	 * 
	 * @return
	 */
	@GetMapping("/hotel/businessArea/match")
	@ApiOperation(value = "根据商业区匹配查找", notes = "根据商业区匹配查找")
	public List<Hotel> matchQuery(@RequestParam String businessAreaCode, @RequestParam String businessAreaName) {
		return hotelService.matchQuery(businessAreaCode, businessAreaName);
	}
}
