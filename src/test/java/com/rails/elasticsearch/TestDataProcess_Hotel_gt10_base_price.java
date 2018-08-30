package com.rails.elasticsearch;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rails.elasticsearch.common.MessageRequest;
import com.rails.elasticsearch.service.impl.DataProcess_Hotel_gt10_base_price;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDataProcess_Hotel_gt10_base_price {

	@Autowired
	private DataProcess_Hotel_gt10_base_price dataProcess_Hotel_gt10_base_price;

	@Test
	public void testDataProcess_Hotel_gt10_base_price() {
		List<MessageRequest> datas = new ArrayList<>();
		String body = "{\r\n" + "	\"hotelId\": \"4_374782\",\r\n" + "	\"city\": \"354\",\r\n"
				+ "	\"basePrice\": \"22400\",\r\n" + "	\"bizdate\": \"20180810\",\r\n"
				+ "	\"createTime\": 1534123859556,\r\n" + "	\"updateTime\": 1534123859556\r\n" + "}";
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setBody(body);
		datas.add(messageRequest);
		
		boolean mqData2Elasticsearch = dataProcess_Hotel_gt10_base_price.mqData2Elasticsearch(datas);
		Assert.assertTrue(!mqData2Elasticsearch);
	}
}
