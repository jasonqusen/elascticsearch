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
import com.rails.elasticsearch.service.impl.DataProcess_Hotel_gt10_hotel_adapter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDataProcess_Hotel_gt10_hotel_adapter {

	@Autowired
	private DataProcess_Hotel_gt10_hotel_adapter dataProcess_Hotel_gt10_hotel_adapter;

	@Test
	public void testDataProcess_Hotel_gt10_hotel_adapter() {
		List<MessageRequest> datas = new ArrayList<>();
		String body = "{\r\n" + "	\"country\": 1,\r\n" + "	\"hotelFacility\": [{\r\n"
				+ "		\"facilityName\": \"活动设施\",\r\n" + "		\"facilityValue\": \"足浴\"\r\n" + "	},\r\n"
				+ "	{\r\n" + "		\"facilityName\": \"客房设施和服务\",\r\n"
				+ "		\"facilityValue\": \"国内长途电话,国际长途电话,拖鞋,雨伞,书桌,24小时热水,电热水壶,咖啡壶/茶壶,免费洗漱用品(6样以上),免费瓶装水,迷你吧,小冰箱,浴衣,多种规格电源插座,110V电压插座,浴缸,独立淋浴间,吹风机,房内保险箱,空调,有线频道,液晶电视机,微波炉,衣柜/衣橱,闹钟,针线包,220V电压插座,遮光窗帘,手动窗帘,备用床具,床具:鸭绒被,沙发,电子秤,房间内高速上网,电话,客房WIFI覆盖免费,空气净化器\"\r\n"
				+ "	},\r\n" + "	{\r\n" + "		\"facilityName\": \"通用设施\",\r\n"
				+ "		\"facilityValue\": \"中餐厅,咖啡厅,前台贵重物品保险柜,收费停车场,免费旅游交通图(可赠送),大堂吧,电梯,有可无线上网的公共区域 免费,所有公共及私人场所严禁吸烟,大堂免费报纸,公共音响系统,无烟楼层,多媒体演示系统,公共区域闭路电视监控系统,充电车位\"\r\n"
				+ "	},\r\n" + "	{\r\n" + "		\"facilityName\": \"服务项目\",\r\n"
				+ "		\"facilityValue\": \"会议厅,旅游票务服务,洗衣服务,叫车服务,邮政服务,专职行李员,行李寄存,叫醒服务,接机服务,租车服务,礼宾服务,传真/复印,办理私人登记入住/退房手续,婚宴服务,24小时前台服务,快速办理入住/退房手续,专职门童,信用卡结算服务,24小时大堂经理,接站服务\"\r\n"
				+ "	}],\r\n" + "	\"oldBusinessAreaName\": \"国贸地区\",\r\n" + "	\"hotelPolicy\": [{\r\n"
				+ "		\"policyValue\": \"入住时间：14:00以后&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;离店时间：12:00以前\",\r\n"
				+ "		\"policyName\": \"CheckInCheckOut\"\r\n" + "	},\r\n" + "	{\r\n"
				+ "		\"policyValue\": \"不接受18岁以下客人单独入住。<br/>不接受18岁以下客人在无监护人陪同的情况下入住\",\r\n"
				+ "		\"policyName\": \"Child\"\r\n" + "	},\r\n" + "	{\r\n"
				+ "		\"policyValue\": \"自助早餐&nbsp;RMB&nbsp;48\",\r\n" + "		\"policyName\": \"Meal\"\r\n"
				+ "	},\r\n" + "	{\r\n" + "		\"policyValue\": \"不可携带宠物。\",\r\n" + "		\"policyName\": \"Pet\"\r\n"
				+ "	},\r\n" + "	{\r\n" + "		\"policyValue\": \"14:00\",\r\n"
				+ "		\"policyName\": \"CheckInFrom\"\r\n" + "	},\r\n" + "	{\r\n"
				+ "		\"policyValue\": \"\",\r\n" + "		\"policyName\": \"CheckInTo\"\r\n" + "	},\r\n" + "	{\r\n"
				+ "		\"policyValue\": \"\",\r\n" + "		\"policyName\": \"CheckOutFrom\"\r\n" + "	},\r\n"
				+ "	{\r\n" + "		\"policyValue\": \"12:00\",\r\n" + "		\"policyName\": \"CheckOutTo\"\r\n"
				+ "	},\r\n" + "	{\r\n"
				+ "		\"policyValue\": \"{\\\"allowChildrenToStay\\\":true,\\\"allowExtraBed\\\":false,\\\"allowExtraCrib\\\":false,\\\"allowUseExistingBed\\\":true,\\\"descriptions\\\":[],\\\"existingBed\\\":{\\\"fees\\\":[],\\\"limitInfo\\\":[{\\\"max\\\":\\\"-1\\\",\\\"min\\\":\\\"-1\\\",\\\"type\\\":\\\"Age\\\"}],\\\"maxOccupancy\\\":1}}\",\r\n"
				+ "		\"policyName\": \"childAndExtraBedPolicy\"\r\n" + "	}],\r\n" + "	\"oldCountry\": \"1\",\r\n"
				+ "	\"province\": 1,\r\n" + "	\"versionNo\": 1534123859556,\r\n" + "	\"tel\": \"010-57075700\",\r\n"
				+ "	\"fax\": \"\",\r\n"
				+ "	\"announcement\": \"北京和乔丽致酒店座落于北京东部商务及贸易核心区CBD，毗邻新中央电视台，雅致的装修，柔和的灯光，暖色的大理石，配以西方古典与中国传统相结合的红木家具，浪漫幻境般风格配饰，让您每每感到眷恋。\",\r\n"
				+ "	\"longitude\": 116.471403,\r\n" + "	\"oldCityName\": \"北京\",\r\n"
				+ "	\"oldHotelId\": \"374782\",\r\n" + "	\"oldChainBrandName\": \"其他\",\r\n"
				+ "	\"oldCountryName\": \"中国\",\r\n" + "	\"oldChainBrand\": \"0\",\r\n"
				+ "	\"oldProvince\": \"1\",\r\n" + "	\"oldProvinceName\": \"北京\",\r\n"
				+ "	\"tags\": \"会议酒店,复式LOFT,特价频道\",\r\n" + "	\"businessArea\": \"767\",\r\n"
				+ "	\"decorateYear\": \"20120901\",\r\n" + "	\"oldBusinessArea\": \"767\",\r\n"
				+ "	\"setupYear\": \"2010\",\r\n" + "	\"hotelTips\": \"目前北京全城禁烟，酒店均为无烟房。\",\r\n"
				+ "	\"countryName\": \"中国\",\r\n" + "	\"provinceName\": \"北京\",\r\n" + "	\"starLevel\": \"14\",\r\n"
				+ "	\"city\": 1,\r\n" + "	\"validFlag\": \"1\",\r\n" + "	\"chainBrand\": \"0\",\r\n"
				+ "	\"latitude\": 39.912151,\r\n" + "	\"businessAreaName\": \"国贸地区\",\r\n"
				+ "	\"oldCountyCode\": \"94\",\r\n" + "	\"cityName\": \"北京\",\r\n" + "	\"hotelScore\": 3.5,\r\n"
				+ "	\"fromChannel\": \"4\",\r\n" + "	\"chainBrandName\": \"其他\",\r\n"
				+ "	\"introduction\": \"北京和乔丽致酒店地处北京东部商务及贸易核心区CBD，毗邻新中央电视台。<br>北京和乔丽致酒店是一家涉外酒店，风格雅致，以西方古典与中国传统相结合的红木家具装点。酒店大堂高雅、气派，拥有独具风格的回廊和花园式前广场。客房全部备有IDD/DDD电话、迷你酒吧、保险箱，卫星电视系统和电脑上网。<br>酒店还拥有小型多功能会议室、小型KTV，为您提供商务洽谈及休闲娱乐一体式服务；酒店中餐厅以粤菜为主，提供地道的鲍、参等人间美味。\",\r\n"
				+ "	\"countyName\": \"朝阳区\",\r\n"
				+ "	\"supportCard\": \"万事达(Master),威士(VISA),运通(AMEX),大来(Diners Club),JCB,国内发行银联卡\",\r\n"
				+ "	\"address\": \"光华路甲8号\",\r\n" + "	\"companyType\": \"0\",\r\n"
				+ "	\"oldStarLevel\": \"4\",\r\n" + "	\"hotelId\": \"4_374782\",\r\n"
				+ "	\"hotelName\": \"北京和乔丽致酒店\",\r\n" + "	\"oldCountyName\": \"朝阳区\",\r\n"
				+ "	\"countyCode\": \"94\",\r\n" + "	\"oldCity\": \"1\",\r\n"
				+ "	\"createTime\": 1534123859556,\r\n" + "	\"linkmanPhone\": \"010-57075700\"\r\n" + "}";
		MessageRequest messageRequest = new MessageRequest();
		messageRequest.setBody(body);
		datas.add(messageRequest);
		boolean mqData2Elasticsearch = dataProcess_Hotel_gt10_hotel_adapter.mqData2Elasticsearch(datas);
		Assert.assertTrue(!mqData2Elasticsearch);
	}
}
