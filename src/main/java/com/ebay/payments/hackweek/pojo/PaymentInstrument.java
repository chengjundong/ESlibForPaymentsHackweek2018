package com.ebay.payments.hackweek.pojo;

import java.io.Serializable;

public class PaymentInstrument implements Serializable {

	private static final long serialVersionUID = 7036881889487893369L;
	
	private String paymentMethodType;

	public String getPaymentMethodType() {
		return paymentMethodType;
	}

	public void setPaymentMethodType(String paymentMethodType) {
		this.paymentMethodType = paymentMethodType;
	}

	@Override
	public String toString() {
		return "PaymentInstrument [paymentMethodType=" + paymentMethodType + "]";
	}
}
