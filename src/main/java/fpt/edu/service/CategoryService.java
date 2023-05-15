package fpt.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fpt.edu.entity.Category;
import fpt.edu.entity.Product;

public interface CategoryService {

	List<Category> findAllCategoryExist();
	
}
