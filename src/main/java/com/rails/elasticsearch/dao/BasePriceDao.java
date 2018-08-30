package com.rails.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.rails.elasticsearch.document.BasePrice;

public interface BasePriceDao extends ElasticsearchRepository<BasePrice, String> {

}
