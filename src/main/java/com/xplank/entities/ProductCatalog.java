package com.xplank.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( schema = "ga_data", name = "product_catalog_new")
public class ProductCatalog {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "hostname")
	private String hostname;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "pagePath")
	private String product_url;
	
	@Column(name = "productSku")
	private String product_id;
	
	@Column(name = "productName")
	private String product_name;
	
	@Column(name = "productCategoryLevel1")
	private String product_category;
	
	@Column(name = "dimension1")
	private String fullImageUrl;
	
	@Column(name = "dimension2")
	private String thumbImageUrl;
	
	@Column(name = "productDetailViews")
	private int traffic;

	@Column(name = "processed_image")
	private String processed_image;
	
	@Column(name = "thumbnail_image")
	private String thumbnail_image;
	
	@Column(name = "excluded")
	private int excluded;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getProduct_url() {
		return product_url;
	}

	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getFullImageUrl() {
		return fullImageUrl;
	}

	public void setFullImageUrl(String fullImageUrl) {
		this.fullImageUrl = fullImageUrl;
	}

	public String getThumbImageUrl() {
		return thumbImageUrl;
	}

	public void setThumbImageUrl(String thumbImageUrl) {
		this.thumbImageUrl = thumbImageUrl;
	}

	public int getTraffic() {
		return traffic;
	}

	public void setTraffic(int traffic) {
		this.traffic = traffic;
	}

	public String getProcessed_image() {
		return processed_image;
	}

	public void setProcessed_image(String processed_image) {
		this.processed_image = processed_image;
	}

	public String getThumbnail_image() {
		return thumbnail_image;
	}

	public void setThumbnail_image(String thumbnail_image) {
		this.thumbnail_image = thumbnail_image;
	}

	public int getExcluded() {
		return excluded;
	}

	public void setExcluded(int excluded) {
		this.excluded = excluded;
	}
	
}
