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
import com.rails.elasticsearch.service.impl.DataProcess_Hotel_gt10_zone;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDataProcess_Hotel_gt10_zone {

	@Autowired
	private DataProcess_Hotel_gt10_zone dataProcess_Hotel_gt10_zone;

	@Test
	public void testDataProcess_Hotel_gt10_zone() {
		List<MessageRequest> datas = new ArrayList<>();
		String body = "{\r\n" + "  \"zoneCode\": \"11\",\r\n" + "  \"zoneName\": \"同安区\",\r\n"
				+ "   \"priority\": \"0\",\r\n" + "   \"validFlag\": \"1\",\r\n" + "   \"cityCode\": \"25\",\r\n"
				+ " \"cityName\": \"厦门\",\r\n" + "   \"hotFlag\": \"0\",\r\n" + "   \"vaildFlag\": \"\"\r\n" + " }";
		String body2 = "{\r\n" + "  \"zoneCode\": \"12\",\r\n" + "  \"zoneName\": \"同安区\",\r\n"
				+ "   \"priority\": \"0\",\r\n" + "   \"validFlag\": \"1\",\r\n" + "   \"cityCode\": \"25\",\r\n"
				+ " \"cityName\": \"厦门\",\r\n" + "   \"hotFlag\": \"0\",\r\n" + "   \"vaildFlag\": \"\"\r\n" + " }";
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setBody(body);
		datas.add(messageRequest);
		MessageRequest messageRequest2 = new MessageRequest();
		messageRequest2.setBody(body2);
		datas.add(messageRequest2);
		boolean mqData2Elasticsearch = dataProcess_Hotel_gt10_zone.mqData2Elasticsearch(datas);
		Assert.assertTrue(!mqData2Elasticsearch);
	}
}
