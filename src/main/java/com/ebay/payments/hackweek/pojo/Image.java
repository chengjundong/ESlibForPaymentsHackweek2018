package com.ebay.payments.hackweek.pojo;

import java.io.Serializable;

public class Image implements Serializable {

	private static final long serialVersionUID = 706928270558340255L;

	private String imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Image [imageUrl=" + imageUrl + "]";
	}

}
