package com.ebay.payments.hackweek.repo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <ol>
 * <li>Build search request</li>
 * <li>Use search API to query ES</li>
 * <li>Encapsulate the result set and return</li>
 * </ol>
 * 
 * @author jucheng
 *
 * @param <T> -- the class of entity
 */
public class ElasticSearchRepo<T> {

	private static final Logger LOG = Loggers.getLogger("ElasticSearchRepo");
	
	private final Class<T> clazz;
	private final RestHighLevelClient client;
	
	public ElasticSearchRepo(RestHighLevelClient client, Class<T> clazz) {
		this.client = client;
		this.clazz = clazz;
	}

	/**
	 * ElasticSearch exact match query
	 * 
	 * @param fieldName
	 * @param fieldVal
	 * @return a list of result
	 * @throws IOException
	 */
	public List<T> matchQuery(String fieldName, String fieldVal) throws IOException {
		
		List<T> result = new LinkedList<>();
		ObjectMapper jackson = new ObjectMapper();
		
		SearchSourceBuilder ssb = new SearchSourceBuilder();
		ssb.query(QueryBuilders.matchQuery(fieldName, fieldVal));
		
		SearchRequest req = new SearchRequest();
		req.source(ssb);
		
		SearchResponse response = client.search(req, RequestOptions.DEFAULT);
		response.getHits().forEach(hit -> {
			try {
				result.add(jackson.readValue(hit.getSourceAsString(), clazz));
			} catch (IOException e) {
				LOG.error("Failed to convert one hit result", e);
			}
		});
		
		return result;
	}

}
