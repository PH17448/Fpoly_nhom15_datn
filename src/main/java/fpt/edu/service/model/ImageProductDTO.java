package fpt.edu.service.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageProductDTO {
	private Long productId;
	
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
	
	private Boolean productDeleted;

	private String createdBy;
	
	private Instant createdTime;
	
	private String lastModifedBy;
	
	private Instant lastModifedTime;
	
	private Boolean isEdit = false;
	
	private Boolean isOpenPopup = false;
	
	private Long imageId;
	
	private String imageUrl;
	
	private List<MultipartFile> imgFiles;
	
	private Boolean imageDeleted;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Boolean getProductDeleted() {
		return productDeleted;
	}

	public void setProductDeleted(Boolean productDeleted) {
		this.productDeleted = productDeleted;
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

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<MultipartFile> getImgFiles() {
		return imgFiles;
	}

	public void setImgFiles(List<MultipartFile> imgFiles) {
		this.imgFiles = imgFiles;
	}

	public Boolean getImageDeleted() {
		return imageDeleted;
	}

	public void setImageDeleted(Boolean imageDeleted) {
		this.imageDeleted = imageDeleted;
	}
	
	
	
}
