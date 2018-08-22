package com.example.elasticsearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.elasticsearch.document.RoomType;

public interface RoomTypeDao extends ElasticsearchRepository<RoomType, String> {

}
