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
import com.rails.elasticsearch.service.impl.DataProcess_Hotel_gt10_price_adapter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDataProcess_Hotel_gt10_price_adapter {

	@Autowired
	private DataProcess_Hotel_gt10_price_adapter dataProcess_Hotel_gt10_price_adapter;

	@Test
	public void testDataProcess_Hotel_gt10_price_adapter() {
		List<MessageRequest> datas = new ArrayList<>();
		String body = "{\r\n" + "	\"productPriceId\": \"2853b86271156d956aa74cc6b7bba51c\",\r\n"
				+ "	\"fromChannel\": \"4\",\r\n" + "	\"hotelId\": \"4_799344\",\r\n"
				+ "	\"productId\": \"4_799344_23476610_137336891\",\r\n" + "	\"city\": 208,\r\n"
				+ "	\"oldProductId\": \"799344_23476610_137336891\",\r\n"
				+ "	\"roomTypeId\": \"4_799344_137336891\",\r\n" + "	\"oldRoomtypeId\": \"23476610\",\r\n"
				+ "	\"activityId\": \"4_137336891\",\r\n" + "	\"oldActivityId\": \"137336891\",\r\n"
				+ "	\"bizdate\": \"20180913\",\r\n" + "	\"listingPrice\": 0,\r\n" + "	\"salePrice\": 26800,\r\n"
				+ "	\"purchasePrice\": 0,\r\n" + "	\"minimumFloating\": 0,\r\n" + "	\"maximumFloating\": 0,\r\n"
				+ "	\"commission\": 0,\r\n" + "	\"commissionRate\": 0,\r\n" + "	\"extrabedPrice\": 0,\r\n"
				+ "	\"doublePrice\": 0,\r\n" + "	\"triplePrice\": 0,\r\n" + "	\"quadPrice\": 0,\r\n"
				+ "	\"exchangeValue\": 0,\r\n" + "	\"webScore\": 0,\r\n" + "	\"burScore\": 0,\r\n"
				+ "	\"webCommission\": 0,\r\n" + "	\"burCommission\": 0,\r\n" + "	\"isBreakFast\": \"0\",\r\n"
				+ "	\"numberOfBreakfast\": 0,\r\n" + "	\"guaranteeCode\": \"2\",\r\n"
				+ "	\"starCancel\": 1534123858911,\r\n" + "	\"endCancel\": 1534123858911,\r\n"
				+ "	\"forfeit\": 26800,\r\n" + "	\"productRemain\": 2,\r\n" + "	\"productBooked\": 0,\r\n"
				+ "	\"avstat\": \"1\",\r\n" + "	\"isInstantConfirm\": \"1\",\r\n" + "	\"validFlag\": \"1\",\r\n"
				+ "	\"publishState\": \"1\",\r\n" + "	\"createTime\": 1534123859556,\r\n"
				+ "	\"versionNo\": 1534123859556\r\n" + "}";
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setBody(body);
		datas.add(messageRequest);
		boolean mqData2Elasticsearch = dataProcess_Hotel_gt10_price_adapter.mqData2Elasticsearch(datas);
		Assert.assertTrue(!mqData2Elasticsearch);
	}
}
