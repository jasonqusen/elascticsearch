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
import com.rails.elasticsearch.service.impl.DataProcess_Hotel_gt10_product_adapter;;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDataProcess_Hotel_gt10_product_adapter {

	@Autowired
	private DataProcess_Hotel_gt10_product_adapter dataProcess_Hotel_gt10_product_adapter;

	@Test
	public void testDataProcess_Hotel_gt10_city() {
		List<MessageRequest> datas = new ArrayList<>();
		String body = "{\r\n" + "	\"productId\": \"4_5602280_26497140_48284235\",\r\n"
				+ "	\"oldProductId\": \"48284235\",\r\n" + "	\"productName\": \"温荷家庭六人房(限时促销)\",\r\n"
				+ "	\"city\": \"617\",\r\n" + "	\"supplierId\": \"0\",\r\n" + "	\"supplierName\": \"SupplierID\",\r\n"
				+ "	\"vendorId\": \"0\",\r\n" + "	\"vendorName\": \"VendorID\",\r\n" + "	\"priority\": \"0\",\r\n"
				+ "	\"fromChannel\": \"4\",\r\n" + "	\"hotelId\": \"4_5602280\",\r\n"
				+ "	\"oldHotelOutid\": \"5602280\",\r\n" + "	\"roomTypeId\": \"4_5602280_26497140\",\r\n"
				+ "	\"roomTypeName\": \"温荷家庭六人房\",\r\n" + "	\"oldRoomTypeId\": \"26497140\",\r\n"
				+ "	\"oldRoomTypeName\": \"温荷家庭六人房\",\r\n" + "	\"oldRoomTypeId1\": \"\",\r\n"
				+ "	\"roomTypeNum\": \"1\",\r\n" + "	\"bedDetail\": \"2张1.5米宽双人床,1张3米宽榻榻米\",\r\n"
				+ "	\"bedDetailAdd\": \"不能加床\",\r\n" + "	\"capacity\": \"6\",\r\n"
				+ "	\"capacityExtend\": \"\",\r\n" + "	\"storeyNum\": \"2-5\",\r\n" + "	\"storeyTotal\": \"\",\r\n"
				+ "	\"roomArea\": \"33.06\",\r\n" + "	\"kuandaiDetail\": \"宽带资费:无;无线宽带:无;有线宽带:全部房间有,且免费\",\r\n"
				+ "	\"smokelessDetail\": \"不可吸烟\",\r\n" + "	\"winDetail\": \"有窗\",\r\n"
				+ "	\"breakfastDetail\": \"\",\r\n" + "	\"toiletDetail\": \"\",\r\n"
				+ "	\"applicability\": \"\",\r\n" + "	\"applicabilityDetail\": \"\",\r\n" + "	\"payWay\": \"1\",\r\n"
				+ "	\"payCanChange\": \"0\",\r\n" + "	\"lineChannel\": \"1,4\",\r\n" + "	\"isSupported\": \"0\",\r\n"
				+ "	\"depositRatio\": \"0\",\r\n" + "	\"receiptFlag\": \"1\",\r\n"
				+ "	\"isSpecialInvoice\": \"1\",\r\n" + "	\"isHourlyRoom\": \"0\",\r\n"
				+ "	\"isConnection\": \"0\",\r\n" + "	\"isAgency\": \"0\",\r\n"
				+ "	\"receiveTextRemark\": \"0\",\r\n" + "	\"stockSaleFlag\": \"1\",\r\n"
				+ "	\"examineType\": \"0\",\r\n" + "	\"productState\": \"0\",\r\n" + "	\"validFlag\": \"1\",\r\n"
				+ "	\"createTime\": 1534123859556,\r\n" + "	\"versionNo\": 1534123859556,\r\n"
				+ "	\"exchangeFlag\": \"\",\r\n" + "	\"integralFlag\": \"\",\r\n" + "	\"hotelFlag1\": \"\",\r\n"
				+ "	\"hotelFlag2\": \"\",\r\n" + "	\"hotelFlag3\": \"\",\r\n" + "	\"hotelFlag4\": \"\",\r\n"
				+ "	\"hotelFlag5\": \"\",\r\n" + "	\"hotelFlag6\": \"\",\r\n" + "	\"hotelFlag7\": \"\",\r\n"
				+ "	\"hotelFlag8\": \"\",\r\n" + "	\"hotelFlag9\": \"\",\r\n" + "	\"hotelFlag10\": \"\"\r\n" + "}";
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setBody(body);
		datas.add(messageRequest);
		boolean mqData2Elasticsearch = dataProcess_Hotel_gt10_product_adapter.mqData2Elasticsearch(datas);
		Assert.assertTrue(!mqData2Elasticsearch);
	}
}
