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
import com.rails.elasticsearch.service.impl.DataProcess_Hotel_gt10_room_type_adapter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDataProcess_Hotel_gt10_room_type_adapter {

	@Autowired
	private DataProcess_Hotel_gt10_room_type_adapter dataProcess_Hotel_gt10_room_type_adapter;

	@Test
	public void testDataProcess_Hotel_gt10_city() {
		List<MessageRequest> datas = new ArrayList<>();
		String body = "{\r\n" + "	\"roomTypeAdapterId\": \"4_2313538_21871547\",\r\n"
				+ "	\"hotelId\": \"4_2313538\",\r\n" + "	\"city\": \"3928\",\r\n"
				+ "	\"roomName\": \"豪华梅里观景标准间\",\r\n" + "	\"feature\": \"\",\r\n" + "	\"introductions\": \"\",\r\n"
				+ "	\"roomTypeNum\": \"4\",\r\n" + "	\"bedDetail\": \"2张1.2米宽单人床\",\r\n"
				+ "	\"bedDetailAdd\": \"不能加床\",\r\n" + "	\"capacity\": \"2\",\r\n"
				+ "	\"capacityExtend\": \"\",\r\n" + "	\"storeyNum\": \"\",\r\n" + "	\"storeyTotal\": \"\",\r\n"
				+ "	\"roomArea\": \"28\",\r\n" + "	\"kuandaiDetail\": \"宽带资费:无;无线宽带:无;有线宽带:全部房间有,且免费\",\r\n"
				+ "	\"smokelessDetail\": \"允许吸烟\",\r\n" + "	\"winDetail\": \"未知\",\r\n"
				+ "	\"breakfastDetail\": \"\",\r\n" + "	\"toiletDetail\": \"\",\r\n"
				+ "	\"roomFacilitys\": \"[{\\\"facilityName\\\": \\\"国内长途电话,有线频道,液晶电视机,电视机,电话,免费国内长途电话\\\", \\\"facilityStatus\\\": null, \\\"roomFacilityAdId\\\": null, \\\"facilityClassifyName\\\": \\\"媒体科技\\\"}, {\\\"facilityName\\\": \\\"露台,山景,享有风景,阳台\\\", \\\"facilityStatus\\\": null, \\\"roomFacilityAdId\\\": null, \\\"facilityClassifyName\\\": \\\"室外景观\\\"}, {\\\"facilityName\\\": \\\"唤醒服务,语音留言,欢迎礼品\\\", \\\"facilityStatus\\\": null, \\\"roomFacilityAdId\\\": null, \\\"facilityClassifyName\\\": \\\"其他\\\"}, {\\\"facilityName\\\": \\\"电热水壶,咖啡壶/茶壶,免费瓶装水,迷你吧,咖啡机,用餐区,厨房,厨房用具,微波炉\\\", \\\"facilityStatus\\\": null, \\\"roomFacilityAdId\\\": null, \\\"facilityClassifyName\\\": \\\"食品饮品\\\"}, {\\\"facilityName\\\": \\\"书桌,电风扇,电热毯,暖气,220V电压插座,遮光窗帘,手动窗帘,床具:毯子或被子,房间内高速上网,客房WIFI覆盖,客房WIFI覆盖免费\\\", \\\"facilityStatus\\\": null, \\\"roomFacilityAdId\\\": null, \\\"facilityClassifyName\\\": \\\"便利设施\\\"}, {\\\"facilityName\\\": \\\"拖鞋,24小时热水,免费洗漱用品(6样以上),独立淋浴间,吹风机,电热水器,免费洗漱用品(6样以内),浴室,淋浴\\\", \\\"facilityStatus\\\": null, \\\"roomFacilityAdId\\\": null, \\\"facilityClassifyName\\\": \\\"浴室\\\"}]\",\r\n"
				+ "	\"flag1\": \"\",\r\n" + "	\"flag2\": \"\",\r\n" + "	\"flag3\": \"\",\r\n"
				+ "	\"flag4\": \"\",\r\n" + "	\"flag5\": \"\"\r\n" + "}";
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setBody(body);
		datas.add(messageRequest);
		boolean mqData2Elasticsearch = dataProcess_Hotel_gt10_room_type_adapter.mqData2Elasticsearch(datas);
		Assert.assertTrue(!mqData2Elasticsearch);
	}
}
