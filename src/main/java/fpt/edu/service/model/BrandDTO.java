package fpt.edu.service.model;


import javax.validation.constraints.NotEmpty;


public class BrandDTO {
	private Long id;
	
	@NotEmpty(message = "Thương hiệu sản phẩm không được để trống")
	private String brandName;
	
	private Boolean deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
