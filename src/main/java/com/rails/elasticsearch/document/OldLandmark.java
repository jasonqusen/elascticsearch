package com.rails.elasticsearch.document;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class OldLandmark {

	@Field(type = FieldType.Text)
	private String oldLandmarkCode;
	@Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String oldLandmarkName;
}
