package com.ebay.payments.hackweek.pojo;

import java.io.Serializable;

/**
 * Mapping to the document of elastic search index: item_test2.
 * 
 * <h2>Sample document</h2>
 * 
 * <pre>
 * {
 *    "tag": "Smart Phone",
 *    "lineItemId": 3,
 *    "categoryId": 1001,
 *    "categoryName": "Phone",
 *    "title": "Huawei Mate 20 Pro",
 *    "price": {
 *      "value": 1300,
 *      "currency": "USD"
 *    },
 *    "itemCondition": "NEW",
 *    "description": "Huawei Mate 20 Proand; 4200mAh battery lasts up to two days on a single charge and its 40W Supercharge technology enables it to achieve a 70% battery charge in 30 minutes."
 *  }
 * </pre>
 * 
 * @author jucheng
 *
 */
public class ItemInfo implements Serializable {

	private static final long serialVersionUID = -3748018479564552698L;

	private String tag;
	private Long lineItemId;
	private Long categoryId;
	private String categoryName;
	private String title;
	private Price price;
	private String itemCondition;
	private String description;
	private Image image;
	private Seller seller;
	private Integer quantity;
	private ShippingDetail shippingDetail;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(Long lineItemId) {
		this.lineItemId = lineItemId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ShippingDetail getShippingDetail() {
		return shippingDetail;
	}

	public void setShippingDetail(ShippingDetail shippingDetail) {
		this.shippingDetail = shippingDetail;
	}

	@Override
	public String toString() {
		return "ItemInfo [tag=" + tag + ", lineItemId=" + lineItemId + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", title=" + title + ", price=" + price + ", itemCondition=" + itemCondition
				+ ", description=" + description + ", image=" + image + ", seller=" + seller + ", quantity=" + quantity
				+ ", shippingDetail=" + shippingDetail + "]";
	}
}
