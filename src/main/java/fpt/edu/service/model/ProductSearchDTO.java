package fpt.edu.service.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class ProductSearchDTO {
	private Long id;
	
	private String productName;
	
	private BigDecimal minPriceIn;
	
	private BigDecimal maxPriceIn;
	
	private BigDecimal minPriceTag;	
	
	private BigDecimal maxPriceTag;
	
	private BigDecimal minNewPrice;
	
	private BigDecimal maxNewPrice;
	
	private BigDecimal minQuantity;
	
	private BigDecimal maxQuantity;
	
	private List<Long> categoryIds;
	
	private List<Long> brandIds;
	
	private List<Long> discountIds;
	
//	private short status;
	
	private Boolean deleted;

	private String createdBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minCreatedTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxCreatedTime;
	
	private String lastModifedBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minLastModifedTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxLastModifedTime;
	
	private Boolean isEdit = false;

	public ProductSearchDTO() {
		
	}
	
	public ProductSearchDTO(Long id, String productName, BigDecimal minPriceIn, BigDecimal maxPriceIn,
			BigDecimal minPriceTag, BigDecimal maxPriceTag, BigDecimal minNewPrice, BigDecimal maxNewPrice,
			BigDecimal minQuantity, BigDecimal maxQuantity, List<Long> categoryIds, List<Long> brandIds,
			List<Long> discountIds, Boolean deleted, String createdBy, Date minCreatedTime, Date maxCreatedTime,
			String lastModifedBy, Date minLastModifedTime, Date maxLastModifedTime, Boolean isEdit) {
		super();
		this.id = id;
		this.productName = productName;
		this.minPriceIn = minPriceIn;
		this.maxPriceIn = maxPriceIn;
		this.minPriceTag = minPriceTag;
		this.maxPriceTag = maxPriceTag;
		this.minNewPrice = minNewPrice;
		this.maxNewPrice = maxNewPrice;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.categoryIds = categoryIds;
		this.brandIds = brandIds;
		this.discountIds = discountIds;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.minCreatedTime = minCreatedTime;
		this.maxCreatedTime = maxCreatedTime;
		this.lastModifedBy = lastModifedBy;
		this.minLastModifedTime = minLastModifedTime;
		this.maxLastModifedTime = maxLastModifedTime;
		this.isEdit = isEdit;
	}

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

	public BigDecimal getMinPriceIn() {
		return minPriceIn;
	}

	public void setMinPriceIn(BigDecimal minPriceIn) {
		this.minPriceIn = minPriceIn;
	}

	public BigDecimal getMaxPriceIn() {
		return maxPriceIn;
	}

	public void setMaxPriceIn(BigDecimal maxPriceIn) {
		this.maxPriceIn = maxPriceIn;
	}

	public BigDecimal getMinPriceTag() {
		return minPriceTag;
	}

	public void setMinPriceTag(BigDecimal minPriceTag) {
		this.minPriceTag = minPriceTag;
	}

	public BigDecimal getMaxPriceTag() {
		return maxPriceTag;
	}

	public void setMaxPriceTag(BigDecimal maxPriceTag) {
		this.maxPriceTag = maxPriceTag;
	}

	public BigDecimal getMinNewPrice() {
		return minNewPrice;
	}

	public void setMinNewPrice(BigDecimal minNewPrice) {
		this.minNewPrice = minNewPrice;
	}

	public BigDecimal getMaxNewPrice() {
		return maxNewPrice;
	}

	public void setMaxNewPrice(BigDecimal maxNewPrice) {
		this.maxNewPrice = maxNewPrice;
	}

	public BigDecimal getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(BigDecimal minQuantity) {
		this.minQuantity = minQuantity;
	}

	public BigDecimal getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(BigDecimal maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<Long> getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(List<Long> brandIds) {
		this.brandIds = brandIds;
	}

	public List<Long> getDiscountIds() {
		return discountIds;
	}

	public void setDiscountIds(List<Long> discountIds) {
		this.discountIds = discountIds;
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

	public Date getMinCreatedTime() {
		return minCreatedTime;
	}

	public void setMinCreatedTime(Date minCreatedTime) {
		this.minCreatedTime = minCreatedTime;
	}

	public Date getMaxCreatedTime() {
		return maxCreatedTime;
	}

	public void setMaxCreatedTime(Date maxCreatedTime) {
		this.maxCreatedTime = maxCreatedTime;
	}

	public String getLastModifedBy() {
		return lastModifedBy;
	}

	public void setLastModifedBy(String lastModifedBy) {
		this.lastModifedBy = lastModifedBy;
	}

	public Date getMinLastModifedTime() {
		return minLastModifedTime;
	}

	public void setMinLastModifedTime(Date minLastModifedTime) {
		this.minLastModifedTime = minLastModifedTime;
	}

	public Date getMaxLastModifedTime() {
		return maxLastModifedTime;
	}

	public void setMaxLastModifedTime(Date maxLastModifedTime) {
		this.maxLastModifedTime = maxLastModifedTime;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	
	
}
