package com.ebay.payments.hackweek.pojo.serialization;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Support Jackson to do customized de-serialization (Double to BigDecimal) of
 * {@link com.ebay.payments.hackweek.pojo.Price#getValue() getValue()}
 * 
 * @author jucheng
 *
 */
public class PriceDeserializer extends JsonDeserializer<BigDecimal> {

	@Override
	public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Double rawVal = p.readValueAs(Double.class);
		return BigDecimal.valueOf(rawVal);
	}
}
