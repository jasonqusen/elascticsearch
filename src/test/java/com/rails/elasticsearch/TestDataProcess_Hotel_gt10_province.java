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
import com.rails.elasticsearch.service.impl.DataProcess_Hotel_gt10_province;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDataProcess_Hotel_gt10_province {

	@Autowired
	private DataProcess_Hotel_gt10_province dataProcess_Hotel_gt10_province;

	@Test
	public void testDataProcess_Hotel_gt10_province() {
		List<MessageRequest> datas = new ArrayList<>();
		String body = "{\r\n" + "            \"provinceCode\": 9,\r\n" + "            \"provinceName\": \"河南\",\r\n"
				+ "            \"countryCode\": 1,\r\n" + "            \"countryName\": \"中国\"\r\n" + "        }";
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setBody(body);
		datas.add(messageRequest);
		boolean mqData2Elasticsearch = dataProcess_Hotel_gt10_province.mqData2Elasticsearch(datas);
		Assert.assertTrue(!mqData2Elasticsearch);
	}
}
