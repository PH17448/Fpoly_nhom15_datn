package fpt.edu.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fpt.edu.entity.Category;
import fpt.edu.entity.Product;
import fpt.edu.repository.CategoryRepository;
import fpt.edu.repository.ProductRepository;
import fpt.edu.service.CategoryService;
import fpt.edu.service.ProductService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAllCategoryExist() {
		return categoryRepository.findAllCategoryExist();
		
	}
		
	
}
