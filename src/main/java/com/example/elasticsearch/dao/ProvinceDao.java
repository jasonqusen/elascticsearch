package com.example.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.elasticsearch.document.Province;

public interface ProvinceDao extends ElasticsearchRepository<Province, String> {

}
