package com.rails.elasticsearch.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
@Document(indexName = "price", type = "price")
public class Price {
	@Id
	@Field(type = FieldType.Text)
	private String productPriceId;
	@Field(type = FieldType.Text)
	private String fromChannel;
	@Field(type = FieldType.Text)
	private String hotelId;
	@Field(type = FieldType.Text)
	private String productId;
	@Field(type = FieldType.Integer)
	private Integer city;
	@Field(type = FieldType.Text)
	private String oldProductId;
	@Field(type = FieldType.Text)
	private String roomTypeId;
	@Field(type = FieldType.Text)
	private String oldRoomtypeId;
	@Field(type = FieldType.Text)
	private String activityId;
	@Field(type = FieldType.Text)
	private String oldActivityId;
	@Field(type = FieldType.Text)
	private String bizdate;
	@Field(type = FieldType.Double)
	private Double listingPrice;
	@Field(type = FieldType.Double)
	private Double salePrice;
	@Field(type = FieldType.Double)
	private Double purchasePrice;
	@Field(type = FieldType.Double)
	private Double minimumFloating;
	@Field(type = FieldType.Double)
	private Double maximumFloating;
	@Field(type = FieldType.Double)
	private Double commission;
	@Field(type = FieldType.Double)
	private Double commissionRate;
	@Field(type = FieldType.Double)
	private Double extrabedPrice;
	@Field(type = FieldType.Double)
	private Double doublePrice;
	@Field(type = FieldType.Double)
	private Double triplePrice;
	@Field(type = FieldType.Double)
	private Double quadPrice;
	@Field(type = FieldType.Double)
	private Double exchangeValue;
	@Field(type = FieldType.Double)
	private Double webScore;
	@Field(type = FieldType.Double)
	private Double burScore;
	@Field(type = FieldType.Double)
	private Double webCommission;
	@Field(type = FieldType.Double)
	private Double burCommission;
	@Field(type = FieldType.Double)
	private String feesRemark;
	@Field(type = FieldType.Text)
	private String isBreakFast;
	@Field(type = FieldType.Integer)
	private Integer numberOfBreakfast;
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private String laterBookingTime;
	@Field(type = FieldType.Text)
	private String guaranteeCode;
	@Field(type = FieldType.Text)
	private String holdTime;
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
	private String starCancel;
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
	private String endCancel;
	@Field(type = FieldType.Double)
	private Double forfeit;
	@Field(type = FieldType.Text)
	private String priceRemark;
	@Field(type = FieldType.Integer)
	private Integer productRemain;
	@Field(type = FieldType.Integer)
	private Integer productBooked;
	@Field(type = FieldType.Text)
	private String avstat;
	@Field(type = FieldType.Text)
	private String isInstantConfirm;
	@Field(type = FieldType.Text)
	private String validFlag;
	@Field(type = FieldType.Text)
	private String publishState;
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private String createTime;
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private String versionNo;
	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String nodeNum;
	@Field(type = FieldType.Keyword)
	private String flag1;
	@Field(type = FieldType.Keyword)
	private String flag2;
	@Field(type = FieldType.Keyword)
	private String flag3;
	@Field(type = FieldType.Keyword)
	private String flag4;
	@Field(type = FieldType.Keyword)
	private String flag5;
	@Field(type = FieldType.Keyword)
	private String flag6;
	@Field(type = FieldType.Keyword)
	private String flag7;
	@Field(type = FieldType.Keyword)
	private String flag8;
	@Field(type = FieldType.Keyword)
	private String flag9;
	@Field(type = FieldType.Keyword)
	private String flag10;

}
