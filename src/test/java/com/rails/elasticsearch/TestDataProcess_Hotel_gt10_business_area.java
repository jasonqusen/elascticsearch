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
import com.rails.elasticsearch.service.impl.DataProcess_Hotel_gt10_business_area;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDataProcess_Hotel_gt10_business_area {

	@Autowired
	private DataProcess_Hotel_gt10_business_area dataProcess_Hotel_gt10_business_area;

	@Test
	public void testDataProcess_Hotel_gt10_business_area() {
		List<MessageRequest> datas = new ArrayList<>();
		String body = "{\r\n" + "	\"businessCode\": 4,\r\n" + "	\"businessName\": \"虹桥地区\",\r\n"
				+ "	\"shortName\": \"虹桥\",\r\n" + "	\"priority\": \"0\",\r\n" + "	\"validFlag\": \"1\",\r\n"
				+ "	\"cityCode\": 2,\r\n" + "	\"cityName\": \"\",\r\n" + "	\"hotFlag\": \"0\",\r\n"
				+ "	\"lng\": 121.401031494141,\r\n" + "	\"lat\": 31.2018852233887\r\n" + "}";
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setBody(body);
		datas.add(messageRequest);
		boolean mqData2Elasticsearch = dataProcess_Hotel_gt10_business_area.mqData2Elasticsearch(datas);
		Assert.assertTrue(!mqData2Elasticsearch);
	}
}
