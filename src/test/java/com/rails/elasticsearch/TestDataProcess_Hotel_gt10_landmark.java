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
import com.rails.elasticsearch.service.impl.DataProcess_Hotel_gt10_landmark;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDataProcess_Hotel_gt10_landmark {

	@Autowired
	private DataProcess_Hotel_gt10_landmark dataProcess_Hotel_gt10_landmark;

	@Test
	public void testProcess_Hotel_gt10_landmark() {
		List<MessageRequest> datas = new ArrayList<>();
		String body = "{\r\n" + "	\"landmarkCode\": \"1_1088447\",\r\n" + "	\"landmarkName\": \"龙湾国际机场\",\r\n"
				+ "	\"landmarkType\": 1,\r\n" + "	\"validFlag\": \"1\",\r\n" + "	\"cityCode\": 491,\r\n"
				+ "	\"cityName\": \"温州\",\r\n" + "	\"hotFlag\": \"0\",\r\n" + "	\"lng\": 120.853201,\r\n"
				+ "	\"lat\": 27.913121,\r\n" + "	\"priority\": 0\r\n" + "}";
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setBody(body);
		datas.add(messageRequest);
		boolean mqData2Elasticsearch = dataProcess_Hotel_gt10_landmark.mqData2Elasticsearch(datas);
		Assert.assertTrue(!mqData2Elasticsearch);
	}
}
