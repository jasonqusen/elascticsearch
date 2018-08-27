/**
 * Copyright 2018 电子计算技术研究所
 * Author：WenLi
 * 创建日期：2018年8月13日
 */
package com.rails.elasticsearch.service.impl;

import java.util.List;

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

@Service("DataProcess_Hotel_gt10_business_area")
public class DataProcess_Hotel_gt10_business_area implements MQ2Elasticsearch {

	private Logger logger = LoggerFactory.getLogger(DataProcess_Hotel_gt10_business_area.class);
	@Autowired
	private TransportClient client;

	@Override
	public boolean mqData2Elasticsearch(List<MessageRequest> datas) {
		datas.stream().forEach(e -> {
			String body = e.getBody();
			JSONObject parseObject = JSONObject.parseObject(body);
			IndexResponse response = client
					.prepareIndex("business_area", "business_area", parseObject.getString("businessCode"))
					.setSource(parseObject.toJSONString(), XContentType.JSON).get();
			logger.info("DataProcess_Hotel_gt10_business_area========" + response.status());
		});
		return false;
	}
}
