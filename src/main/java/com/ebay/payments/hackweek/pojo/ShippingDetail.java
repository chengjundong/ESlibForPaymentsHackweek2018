package com.ebay.payments.hackweek.pojo;

import java.io.Serializable;
import java.time.Instant;

public class ShippingDetail implements Serializable {

	private static final long serialVersionUID = 4563742834557313395L;

	private String shippingServiceCode;
	private String shippingCarrierCode;
	private Instant minEstimatedDeliveryDate;
	private Instant maxEstimatedDeliveryDate;

	public String getShippingServiceCode() {
		return shippingServiceCode;
	}

	public void setShippingServiceCode(String shippingServiceCode) {
		this.shippingServiceCode = shippingServiceCode;
	}

	public String getShippingCarrierCode() {
		return shippingCarrierCode;
	}

	public void setShippingCarrierCode(String shippingCarrierCode) {
		this.shippingCarrierCode = shippingCarrierCode;
	}

	public Instant getMinEstimatedDeliveryDate() {
		return minEstimatedDeliveryDate;
	}

	public void setMinEstimatedDeliveryDate(Instant minEstimatedDeliveryDate) {
		this.minEstimatedDeliveryDate = minEstimatedDeliveryDate;
	}

	public Instant getMaxEstimatedDeliveryDate() {
		return maxEstimatedDeliveryDate;
	}

	public void setMaxEstimatedDeliveryDate(Instant maxEstimatedDeliveryDate) {
		this.maxEstimatedDeliveryDate = maxEstimatedDeliveryDate;
	}

	@Override
	public String toString() {
		return "ShippingDetail [shippingServiceCode=" + shippingServiceCode + ", shippingCarrierCode="
				+ shippingCarrierCode + ", minEstimatedDeliveryDate=" + minEstimatedDeliveryDate
				+ ", maxEstimatedDeliveryDate=" + maxEstimatedDeliveryDate + "]";
	}
}
