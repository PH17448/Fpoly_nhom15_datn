package fpt.edu.service.model;

import javax.validation.constraints.NotEmpty;


public class CategoryDTO {

	private Long id;
	
	@NotEmpty(message = "Loại sản phẩm không được để trống")
	private String categoryName;
	
	private Boolean deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
