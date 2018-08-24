package com.rails.elasticsearch.service;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.rails.elasticsearch.dao.HotelDao;
import com.rails.elasticsearch.document.Hotel;

@Service
public class HotelService {

	@Autowired
	private HotelDao hotelDao;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	/**
	 * term 查询
	 */
	public Iterable<Hotel> termQuery() {

		TermQueryBuilder builder = new TermQueryBuilder("businessAreaName", "北京");

		Iterable<Hotel> hotels = hotelDao.search(builder);

		return hotels;
	}

	/**
	 * terms 查询
	 */
	public Iterable<Hotel> termsQuery() {
		TermsQueryBuilder builder = new TermsQueryBuilder("businessAreaName", "北京", "南京", "天津");

		Iterable<Hotel> hotels = hotelDao.search(builder);

		return hotels;
	}

	/**
	 * 分页查询
	 */
	public Iterable<Hotel> pageQuery() {
		TermsQueryBuilder builder = new TermsQueryBuilder("businessAreaName", "北京");
		int pageNum = 1;
		int pageSize = 15;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		return hotelDao.search(builder, pageable);
	}

	/**
	 * 

	 */
	public Iterable<Hotel> pageAndSortQuery() {
		TermsQueryBuilder builder = new TermsQueryBuilder("businessAreaName", "北京");

		String orderBy = "createTime";
		Sort sort = new Sort(Direction.DESC, orderBy);

		int pageNum = 1; // 作用是什么？？
		int pageSize = 15;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);

		return hotelDao.search(builder, pageable);
	}

	/**
	 * match 查询
	 */
	public Iterable<Hotel> matchQuery() {
		MatchQueryBuilder builder = new MatchQueryBuilder("businessAreaName", "上海");
		return hotelDao.search(builder);
	}

	/**
	 * 高亮显示
	 */
	public Iterable<Hotel> hightQuery() {

		int pageNum = 1;
		int pageSize = 15;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

		NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.termQuery("hotelName", "北京"))
				.withHighlightFields(new HighlightBuilder.Field("hotelName")).withPageable(pageable).build();

		Page<Hotel> page = elasticsearchTemplate.queryForPage(searchQuery, Hotel.class, new SearchResultMapper() {

			@SuppressWarnings("unchecked")
			@Override
			public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {

				List<Hotel> hotels = new ArrayList<>();
				SearchHits hits = response.getHits();

				for (SearchHit searchHit : hits) {
					if (hits.getHits().length <= 0) {
						return null;
					}
					Hotel hotel = new Hotel();
					String highLightMessage = searchHit.getHighlightFields().get("hotelName").fragments()[0].toString();
					hotel.setHotelId(searchHit.getId());
					hotel.setHotelName(highLightMessage);
					hotels.add(hotel);
				}
				if (hotels.size() > 0) {
					return new AggregatedPageImpl<T>((List<T>) hotels);
				}
				return null;
			}
		});
		return page;
	}

	/**
	 * multi-match查询
	 */
	public Iterable<Hotel> multiMatchQuery() {
		int pageNum = 1;
		int pageSize = 15;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		MultiMatchQueryBuilder queryBuilder = QueryBuilders.multiMatchQuery("北京", "hotelName", "businessAreaName");
		return hotelDao.search(queryBuilder, pageable);
	}
}
