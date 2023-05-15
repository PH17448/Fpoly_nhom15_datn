package fpt.edu.service.model;

import java.math.BigDecimal;
import java.time.Instant;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class ProductDTO {

	private Long id;
	
	@NotEmpty(message = "Tên sản phẩm không được để trống")
	private String productName;
	
	@DecimalMin(value = "1", message = "Số lượng không được để trống")
	@NotNull(message = "Số lượng không được để trống")
	private BigDecimal quantity;
	
	@DecimalMin(value = "1", message = "Giá nhập không được để trống")
	@NotNull(message = "Giá nhập không được để trống")
	private BigDecimal priceIn;
	
	@DecimalMin(value = "1", message = "Giá bán không được để trống")
	@NotNull(message = "Giá bán không được để trống")
	private BigDecimal priceTag;
	
	private BigDecimal newPrice;
	
	@Min(value = 0, message = "Loại sản phẩm không được để trống")
	private Long categoryId;
	
	@Min(value = 0, message = "Tên thương hiệu không được để trống")
	private Long brandId;
	
	@Min(value = 0, message = "Tên loại giảm giá không được để trống")
	private Long discountId;
	
	private short status;
	
	private Boolean deleted;

	private String createdBy;
	
	private Instant createdTime;
	
	private String lastModifedBy;
	
	private Instant lastModifedTime;
	
	private Boolean isEdit = false;
	
	private Boolean isOpenPopup = false;

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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
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

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public Boolean getIsOpenPopup() {
		return isOpenPopup;
	}

	public void setIsOpenPopup(Boolean isOpenPopup) {
		this.isOpenPopup = isOpenPopup;
	}
	
	
}
