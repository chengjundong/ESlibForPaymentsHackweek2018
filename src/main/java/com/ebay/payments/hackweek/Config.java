package com.ebay.payments.hackweek;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ebay.payments.hackweek.pojo.ItemInfo;
import com.ebay.payments.hackweek.repo.ElasticSearchRepo;

/**
 * Configuration class for the entire lib, anyone use this lib should include
 * this configuration bean in his Spring configuration, then do the DI.
 * 
 * @author jucheng
 *
 */
@Configuration
@PropertySource("classpath:elastic-lib-lister.properties")
public class Config {

	@Value("${elasticsearch.host}")
	private String host;

	@Value("${elasticsearch.port}")
	private Integer port;

	@Value("${elasticsearch.username}")
	private String username;

	@Value("${elasticserach.password}")
	private String password;

	/**
	 * @return an intance of {@link RestHighLevelClient} within Basic Auth ability
	 */
	@Bean(destroyMethod = "close")
	public RestHighLevelClient highLevelClient() {

		final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));

		return new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, "https"))
				.setHttpClientConfigCallback(builder -> builder.setDefaultCredentialsProvider(credentialsProvider)));
	}
	
	@Bean
	public ElasticSearchRepo<ItemInfo> itemInfoRepo(RestHighLevelClient client) {
		return new ElasticSearchRepo<>(client, ItemInfo.class);
	}
}
