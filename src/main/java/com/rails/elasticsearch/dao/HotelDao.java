package com.rails.elasticsearch.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.rails.elasticsearch.document.Hotel;

public interface HotelDao extends ElasticsearchRepository<Hotel, String> {

	Page<Hotel> findAllByLocation(double lat, double lon, double distance, Pageable pageable);
}
