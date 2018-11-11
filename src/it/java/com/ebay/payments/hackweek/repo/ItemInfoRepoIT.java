package com.ebay.payments.hackweek.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebay.payments.hackweek.Config;
import com.ebay.payments.hackweek.pojo.ItemInfo;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { Config.class })
public class ItemInfoRepoIT {

	@Autowired
	private ElasticSearchRepo<ItemInfo> itemInfoRepo;

	@Test
	public void matchQuery_QueryByTitle_OneItemReturned() throws Exception {
		// act
		List<ItemInfo> result = itemInfoRepo.matchQuery("title", "Huawei Mate 20 Pro");
		
		// assign
		assertThat(result).isNotNull().hasSize(1)
				.extracting("tag", "lineItemId", "categoryId", "categoryName", "title", "price.value", "price.currency")
				.containsExactly(tuple("Smart Phone", 3L, 1001L, "Phone", "Huawei Mate 20 Pro", BigDecimal.valueOf(1300.0), "USD"));
	}
	
	@Test
	public void matchQuery_QueryByTag_AtLeastTheeItemReturned() throws Exception {
		// act
		List<ItemInfo> result = itemInfoRepo.matchQuery("tag", "Smart Phone");
		
		// assign
		assertThat(result).isNotNull()
			.extracting("lineItemId", "categoryId", "categoryName", "title", "price.value", "price.currency")
			.contains(tuple(1L, 1001L, "Phone", "iphone XS max", BigDecimal.valueOf(1400.0), "USD"),
					tuple(2L, 1001L, "Phone", "Samsung Galaxy Note 9 ", BigDecimal.valueOf(999.0), "USD"),
					tuple(3L, 1001L, "Phone", "Huawei Mate 20 Pro", BigDecimal.valueOf(1300.0), "USD"));
	}
	
	@Test
	public void matchQuery_QueryByNonExistedTag_EmptyListReturned() throws Exception {
		// act
		List<ItemInfo> result = itemInfoRepo.matchQuery("tag", "invalid");
		
		// assign
		assertThat(result).isEmpty();
	}
}
