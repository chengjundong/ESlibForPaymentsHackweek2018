package com.ebay.payments.hackweek.repo;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ebay.payments.hackweek.pojo.ItemInfo;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

@Ignore("All elastic search classes are final, hard to mock. Put it in here temporarily.")
public class ItemInfoElasticSearchRepoTest {

	@InjectMocks
	private ElasticSearchRepo<ItemInfo> repo;
	
	@Mock
	private RestHighLevelClient client;
	
	private String source = "{\n" + 
			"                    \"tag\": \"Smart Phone\",\n" + 
			"                    \"lineItemId\": 3,\n" + 
			"                    \"categoryId\": 1001,\n" + 
			"                    \"categoryName\": \"Phone\",\n" + 
			"                    \"title\": \"Huawei Mate 20 Pro\",\n" + 
			"                    \"price\": {\n" + 
			"                        \"value\": 1300,\n" + 
			"                        \"currency\": \"USD\"\n" + 
			"                    },\n" + 
			"                    \"itemCondition\": \"NEW\",\n" + 
			"                    \"description\": \"DESC\"\n" + 
			"                }";
	
	@SuppressWarnings("unchecked")
	@Test
	public void matchQuery() throws Exception {
		// assgin
		final String fieldName = "title";
		final String fieldVal = "Huawei Mate 20 Pro";
		final SearchResponse searchResp = mock(SearchResponse.class);
		final SearchHit hit = mock(SearchHit.class);
		final SearchHits hints = new SearchHits(new SearchHit[] {hit}, 1, 1.00F);
		
		given(client.search(any(SearchRequest.class), RequestOptions.DEFAULT)).willReturn(searchResp);
		given(hit.getSourceAsString()).willReturn(source);
		given(searchResp.getHits()).willReturn(hints);
		willCallRealMethod().given(hints).forEach(any(Consumer.class));
		
		// act
		List<ItemInfo> result = repo.matchQuery(fieldName, fieldVal);
		
		// assign
		assertThat(result).isNotNull().hasSize(1)
			.extracting("tag", "lineItemId", "categoryId", "categoryName", "title", "price.value", "price.currency", "itemCondition", "description")
			.contains(tuple("Smart Phone", 3, 1001, "Phone", "Huawei Mate 20 Pro", BigDecimal.valueOf(1300), "USD", "NEW", "DESC"));
	}
}
