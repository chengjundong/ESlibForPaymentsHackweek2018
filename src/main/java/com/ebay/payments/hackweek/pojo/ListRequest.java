package com.ebay.payments.hackweek.pojo;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ListRequest {

	private final Integer listingRequestedId = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);

	private final Instant listingCreationDate = Instant.now();

	private List<ItemInfo> lineItems;

	private PaymentInstrument paymentInstrument;

	private Map<String, String> attributes;

	public List<ItemInfo> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<ItemInfo> lineItems) {
		this.lineItems = lineItems;
	}

	public PaymentInstrument getPaymentInstrument() {
		return paymentInstrument;
	}

	public void setPaymentInstrument(PaymentInstrument paymentInstrument) {
		this.paymentInstrument = paymentInstrument;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public Integer getListingRequestedId() {
		return listingRequestedId;
	}

	public Instant getListingCreationDate() {
		return listingCreationDate;
	}

	@Override
	public String toString() {
		return "ListRequest [listingRequestedId=" + listingRequestedId + ", listingCreationDate=" + listingCreationDate
				+ ", lineItems=" + lineItems + ", paymentInstrument=" + paymentInstrument + ", attributes=" + attributes
				+ "]";
	}
}
