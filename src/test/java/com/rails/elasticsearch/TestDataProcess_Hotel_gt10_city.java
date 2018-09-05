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
import com.rails.elasticsearch.service.impl.DataProcess_Hotel_gt10_city;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDataProcess_Hotel_gt10_city {

	@Autowired
	private DataProcess_Hotel_gt10_city dataProcess_Hotel_gt10_city;

	@Test
	public void testDataProcess_Hotel_gt10_city() {
		List<MessageRequest> datas = new ArrayList<>();
		String body = "{\r\n" + "	\"cityCode\": \"1\",\r\n" + "	\"cityName\": \"北京\",\r\n"
				+ "	\"cityNameEn\": \"Beijing\",\r\n" + "	\"priority\": \"0\",\r\n" + "	\"validFlag\": \"1\",\r\n"
				+ "	\"suoXie\": \"\",\r\n" + "	\"provinceCode\": \"1\",\r\n" + "	\"provinceName\": \"北京\",\r\n"
				+ "	\"countryCode\": \"1\",\r\n" + "	\"countryName\": \"中国\",\r\n" + "	\"hotFlag\": \"0\",\r\n"
				+ "	\"parentCityCode\": \"-1\",\r\n" + "	\"lng\": \"116.407399\",\r\n"
				+ "	\"lat\": \"39.904211\"\r\n" + "}";
		String body2 = "{\r\n" + "	\"cityCode\": \"2\",\r\n" + "	\"cityName\": \"北京\",\r\n"
				+ "	\"cityNameEn\": \"Beijing\",\r\n" + "	\"priority\": \"0\",\r\n" + "	\"validFlag\": \"1\",\r\n"
				+ "	\"suoXie\": \"\",\r\n" + "	\"provinceCode\": \"1\",\r\n" + "	\"provinceName\": \"北京\",\r\n"
				+ "	\"countryCode\": \"1\",\r\n" + "	\"countryName\": \"中国\",\r\n" + "	\"hotFlag\": \"0\",\r\n"
				+ "	\"parentCityCode\": \"-1\",\r\n" + "	\"lng\": \"116.407399\",\r\n"
				+ "	\"lat\": \"39.904211\"\r\n" + "}";
		MessageRequest messageRequest = new MessageRequest();
		MessageRequest messageRequest2 = new MessageRequest();
		messageRequest.setBody(body);
		messageRequest2.setBody(body2);
		datas.add(messageRequest);
		datas.add(messageRequest2);
		boolean mqData2Elasticsearch = dataProcess_Hotel_gt10_city.mqData2Elasticsearch(datas);
		Assert.assertTrue(!mqData2Elasticsearch);
	}
}
