/**
 * Copyright 2018 电子计算技术研究所
 * Author：WenLi
 * 创建日期：2018年8月13日
 */
package com.rails.elasticsearch.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.rails.elasticsearch.common.MessageRequest;
import com.rails.elasticsearch.service.MQ2Elasticsearch;

@Service("DataProcess_Hotel_gt10_room_type_adapter")
public class DataProcess_Hotel_gt10_room_type_adapter implements MQ2Elasticsearch {
	private Logger logger = LoggerFactory.getLogger(DataProcess_Hotel_gt10_room_type_adapter.class);
	@Autowired
	private TransportClient client;

	@Override
	public boolean mqData2Elasticsearch(List<MessageRequest> datas) {
		datas.stream().forEach(e -> {
			String body = e.getBody();
			JSONObject parseObject = JSONObject.parseObject(body);

			Map<String, Object> roomFacilitys = new HashMap<>();
			roomFacilitys.put("facilityName", parseObject.get("facilityName"));
			roomFacilitys.put("facilityStatus", parseObject.get("facilityStatus"));
			roomFacilitys.put("roomFacilityAdId", parseObject.get("roomFacilityAdId"));
			roomFacilitys.put("facilityClassifyName", parseObject.get("facilityClassifyName"));
			parseObject.put("roomFacilitys", roomFacilitys);

			IndexResponse response = client
					.prepareIndex("room_type", "room_type", parseObject.getString("roomTypeAdapterId"))
					.setSource(parseObject.toJSONString(), XContentType.JSON).get();
			logger.info("DataProcess_Hotel_gt10_room_type_adapter========" + response.status());
		});
		return false;
	}
}
