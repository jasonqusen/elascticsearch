package com.rails.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.rails.elasticsearch.document.Landmark;

public interface LandmarkDao extends ElasticsearchRepository<Landmark, String> {

}
