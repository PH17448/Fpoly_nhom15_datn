package fpt.edu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
@Table(name= "products")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "product_name", columnDefinition = "nvarchar(100) not null")
	private String productName;
	
	@Column(nullable = false)
	private BigDecimal quantity;
	
	@Column(name = "price_in", nullable = false)
	private BigDecimal priceIn;
	
	@Column(name = "price_tag", nullable = false)
	private BigDecimal priceTag;
	
	@Column(name = "newPrice", nullable = false)
	private BigDecimal newPrice;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "discountId")
	private Discount discount;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Image> images;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OrderDetail> orderDetails;
	
	@Column(nullable = false)
	private short status;
	
	@Column(nullable = false)
	private Boolean deleted;
	
	@Column(name = "created_by", columnDefinition = "nvarchar(100) not null")
	private String createdBy;
	
	@Column(name = "created_time")
	private Instant createdTime;
	
	@Column(name = "last_modifed_by", columnDefinition = "nvarchar(100) not null")
	private String lastModifedBy;
	
	@Column(name = "last_modifed_time")
	private Instant lastModifedTime;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public BigDecimal getQuantity() {
		return quantity;
	}



	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}



	public BigDecimal getPriceIn() {
		return priceIn;
	}



	public void setPriceIn(BigDecimal priceIn) {
		this.priceIn = priceIn;
	}



	public BigDecimal getPriceTag() {
		return priceTag;
	}



	public void setPriceTag(BigDecimal priceTag) {
		this.priceTag = priceTag;
	}



	public BigDecimal getNewPrice() {
		return newPrice;
	}



	public void setNewPrice(BigDecimal newPrice) {
		this.newPrice = newPrice;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public Brand getBrand() {
		return brand;
	}



	public void setBrand(Brand brand) {
		this.brand = brand;
	}



	public Discount getDiscount() {
		return discount;
	}



	public void setDiscount(Discount discount) {
		this.discount = discount;
	}



	public Set<Image> getImages() {
		return images;
	}



	public void setImages(Set<Image> images) {
		this.images = images;
	}



	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}



	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}



	public short getStatus() {
		return status;
	}



	public void setStatus(short status) {
		this.status = status;
	}



	public Boolean getDeleted() {
		return deleted;
	}



	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public Instant getCreatedTime() {
		return createdTime;
	}



	public void setCreatedTime(Instant createdTime) {
		this.createdTime = createdTime;
	}



	public String getLastModifedBy() {
		return lastModifedBy;
	}



	public void setLastModifedBy(String lastModifedBy) {
		this.lastModifedBy = lastModifedBy;
	}



	public Instant getLastModifedTime() {
		return lastModifedTime;
	}



	public void setLastModifedTime(Instant lastModifedTime) {
		this.lastModifedTime = lastModifedTime;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", quantity=" + quantity + ", priceIn=" + priceIn
				+ ", priceTag=" + priceTag + ", newPrice=" + newPrice + ", category=" + category + ", brand=" + brand
				+ ", discount=" + discount + ", images=" + images + ", orderDetails=" + orderDetails + ", status="
				+ status + ", deleted=" + deleted + ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", lastModifedBy=" + lastModifedBy + ", lastModifedTime=" + lastModifedTime + "]";
	}
	
}
