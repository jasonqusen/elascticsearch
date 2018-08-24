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
import com.rails.elasticsearch.common.DateUtils;
import com.rails.elasticsearch.common.MessageRequest;
import com.rails.elasticsearch.service.MQ2Elasticsearch;

@Service("DataProcess_Hotel_gt10_hotel_adapter")
public class DataProcess_Hotel_gt10_hotel_adapter implements MQ2Elasticsearch {

	private Logger logger = LoggerFactory.getLogger(DataProcess_Hotel_gt10_hotel_adapter.class);
	@Autowired
	private TransportClient client;

	@Override
	public boolean mqData2Elasticsearch(List<MessageRequest> datas) {
		datas.stream().forEach(e -> {
			String body = e.getBody();
			JSONObject parseObject = JSONObject.parseObject(body);

			if (parseObject.get("versionNo") != null) {
				parseObject.put("versionNo",
						DateUtils.longToString((long) parseObject.get("versionNo"), "yyyy-MM-dd HH:mm:ss.SSS"));
			}
			if (parseObject.get("createTime") != null) {
				parseObject.put("createTime",
						DateUtils.longToString((long) parseObject.get("createTime"), "yyyy-MM-dd HH:mm:ss.SSS"));
			}
			if (parseObject.get("latestOrderTime") != null) {
				parseObject.put("latestOrderTime",
						DateUtils.longToString((long) parseObject.get("latestOrderTime"), "yyyy-MM-dd HH:mm:ss.SSS"));
			}
			Map<String, Object> businessArea = new HashMap<>();
			businessArea.put("businessAreaCode", parseObject.get("businessArea"));
			businessArea.put("businessAreaName", parseObject.get("businessAreaName"));
			parseObject.put("businessArea", businessArea);
			parseObject.remove("businessAreaName");

			Map<String, Object> oldBusinessArea = new HashMap<>();
			oldBusinessArea.put("oldBusinessAreaCode", parseObject.get("oldBusinessArea"));
			oldBusinessArea.put("oldBusinessAreaName", parseObject.get("oldBusinessAreaName"));
			parseObject.put("oldBusinessArea", oldBusinessArea);
			parseObject.remove("oldBusinessAreaName");

			IndexResponse response = client.prepareIndex("hotel", "hotel", parseObject.getString("hotelId"))
					.setSource(parseObject.toJSONString(), XContentType.JSON).get();
			logger.info("DataProcess_Hotel_gt10_hotel_adapter========" + response.status());
		});
		return false;
	}
}
