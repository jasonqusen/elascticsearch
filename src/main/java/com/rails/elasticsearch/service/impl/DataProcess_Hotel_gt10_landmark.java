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

@Service("dataProcess_Hotel_gt10_landmark")
public class DataProcess_Hotel_gt10_landmark implements MQ2Elasticsearch {
	private Logger logger = LoggerFactory.getLogger(DataProcess_Hotel_gt10_business_area.class);
	@Autowired
	private TransportClient client;

	@Override
	public boolean mqData2Elasticsearch(List<MessageRequest> datas) {
		datas.stream().forEach(e -> {
			String body = e.getBody();
			JSONObject parseObject = JSONObject.parseObject(body);

			Map<String, Object> location = new HashMap<>();
			location.put("lat", parseObject.get("lat"));
			location.put("lon", parseObject.get("lng"));
			parseObject.put("location", location);
			parseObject.remove("lat");
			parseObject.remove("lng");

			IndexResponse response = client.prepareIndex("landmark", "landmark", parseObject.getString("landmarkCode"))
					.setSource(parseObject.toJSONString(), XContentType.JSON).get();
			logger.info("DataProcess_Hotel_gt10_landmark========" + response.status());
		});
		return false;
	}
}