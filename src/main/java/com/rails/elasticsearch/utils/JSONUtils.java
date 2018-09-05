package com.rails.elasticsearch.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.rails.elasticsearch.common.DateUtils;

public class JSONUtils {
	/**
	 * 封装nested数据处理
	 * 
	 * @param parseObject
	 * @param strings
	 * @return
	 */
	public static JSONObject getNested(JSONObject parseObject, String... strings) {
		List<Map<String, Object>> listMap = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put(strings[0], parseObject.get(strings[1]));
		map.put(strings[2], parseObject.get(strings[2]));
		listMap.add(map);
		parseObject.put(strings[1], listMap);
		parseObject.remove(strings[2]);

		return parseObject;
	}

	/**
	 * 封装location
	 * 
	 * @param jsonObject
	 * @param strings
	 * @return
	 */
	public static JSONObject getLocation(JSONObject parseObject, String... strings) {
		Map<String, Object> location = new HashMap<>();
		location.put(strings[0], parseObject.get(strings[1]));
		location.put(strings[2], parseObject.get(strings[3]));
		parseObject.put(strings[4], location);
		parseObject.remove(strings[1]);
		parseObject.remove(strings[3]);

		return parseObject;
	}

	/**
	 * 时间格式化
	 * 
	 * @param format
	 * @param parseObject
	 * @param Datestr
	 * @return
	 */
	public static JSONObject formatDate(String format, JSONObject parseObject, String Datestr) {
		if (parseObject.get(Datestr) != null) {
			parseObject.put(Datestr, DateUtils.longToString((long) parseObject.get(Datestr), format));
		}
		return parseObject;
	}
}
