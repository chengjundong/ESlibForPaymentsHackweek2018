package com.ebay.payments.hackweek;

import org.assertj.core.api.JUnitSoftAssertions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ebay.payments.hackweek.pojo.ItemInfo;
import com.ebay.payments.hackweek.repo.ElasticSearchRepo;

/**
 * Test the initialization of Spring Context
 * 
 * @author jucheng
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
public class ConfigTest {

	@Autowired
	private RestHighLevelClient client;

	@Autowired
	private ElasticSearchRepo<ItemInfo> itemInfoRepo;

	@Rule
	public JUnitSoftAssertions softly = new JUnitSoftAssertions();

	@Test
	public void testSpringContextInit() {
		softly.assertThat(client).isNotNull();
		softly.assertThat(itemInfoRepo).isNotNull();
	}
}
