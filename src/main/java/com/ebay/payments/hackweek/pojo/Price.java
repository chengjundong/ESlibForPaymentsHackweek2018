package com.ebay.payments.hackweek.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ebay.payments.hackweek.pojo.serialization.PriceDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Price implements Serializable {

	private static final long serialVersionUID = 5164793702178771412L;

	@JsonDeserialize(using = PriceDeserializer.class)
	private BigDecimal value;
	private String currency;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Price [value=" + value + ", currency=" + currency + "]";
	}
}
