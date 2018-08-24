package com.rails.elasticsearch.document;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
public class HotelFacility {
	@Field(type = FieldType.Keyword)
	private String facilityName;
	@Field(type = FieldType.Text)
	private String facilityValue;
	@Field(type = FieldType.Keyword)
	private String facilityNameEn;
	@Field(type = FieldType.Text)
	private String facilityValueEn;

}
