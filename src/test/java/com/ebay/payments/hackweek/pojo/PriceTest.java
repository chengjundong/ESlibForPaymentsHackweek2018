package com.ebay.payments.hackweek.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PriceTest {

	@Test
	public void testDeserialization_CorrectInput_Succeed() throws Exception {
		// assign
		final String rawJson = "{\"value\": 1300.99, \"currency\": \"USD\"}";

		// act
		Price price = new ObjectMapper().readValue(rawJson, Price.class);

		// assert
		assertThat(price).isNotNull()
			.extracting("value", "currency").containsExactly(BigDecimal.valueOf(1300.99), "USD");
	}

	@Test
	public void testSerialization_CorrectInput_Succeed() throws Exception {
		// assign
		Price price = new Price();
		price.setCurrency("USD");
		price.setValue(BigDecimal.valueOf(3.99));

		// act
		String output = new ObjectMapper().writeValueAsString(price);

		// assert
		JSONAssert.assertEquals("{\"value\": 3.99, \"currency\": \"USD\"}", output, true);
	}
}
