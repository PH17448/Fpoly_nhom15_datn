package fpt.edu.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fpt.edu.entity.Brand;
import fpt.edu.entity.Discount;
import fpt.edu.entity.Product;
import fpt.edu.repository.DiscountRepository;
import fpt.edu.repository.ProductRepository;
import fpt.edu.service.DiscountService;
import fpt.edu.service.ProductService;

@Service
public class DiscountServiceImpl implements DiscountService{
	@Autowired
	private DiscountRepository discountRepository;

	@Override
	public List<Discount> findAllDiscountExist() {
		return discountRepository.findAllDiscountExist();
	}
	
	
}	
