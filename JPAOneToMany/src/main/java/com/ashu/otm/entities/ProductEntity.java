package com.ashu.otm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity {
	
	@Id
	@Column(name = "prod_id")
	private Integer prodId;
	
	@Column(name = "prod_name")
	private String prodName;
	
	@Lob
	@Column(name = "prod_image", columnDefinition = "MEDIUMBLOB")
	private byte[] prodImage;

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public byte[] getProdImage() {
		return prodImage;
	}

	public void setProdImage(byte[] prodImage) {
		this.prodImage = prodImage;
	}
	
	
}
