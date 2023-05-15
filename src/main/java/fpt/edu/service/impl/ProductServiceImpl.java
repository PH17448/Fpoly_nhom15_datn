package fpt.edu.service.impl;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fpt.edu.entity.Product;
import fpt.edu.repository.ProductRepository;
import fpt.edu.repository.ProductSearchRepository;
import fpt.edu.repository.impl.ProductSearchRepositoryImpl;
import fpt.edu.service.ProductService;
import fpt.edu.service.model.ProductSearchDTO;

@Service
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;

	private final ProductSearchRepositoryImpl productSearchRepositoryImpl;

	public ProductServiceImpl(ProductRepository productRepository, ProductSearchRepositoryImpl productSearchRepositoryImpl) {
		this.productRepository = productRepository;
		this.productSearchRepositoryImpl = productSearchRepositoryImpl;
	}

	@Override
	public <S extends Product> S save(S entity) {
		entity.setDeleted(false);
		entity.setNewPrice(BigDecimal.ZERO);
		entity.setCreatedBy("aa");
		entity.setCreatedTime(Instant.now());
		//tam thoi`
		entity.setLastModifedBy("aa");
		entity.setLastModifedTime(Instant.now());
		return productRepository.save(entity);
	}

	@Override
	public List<Product> searchProductExist(ProductSearchDTO productSearchDTO) {
		return productSearchRepositoryImpl.searchProductExist(productSearchDTO);
//		return null ;
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> selectProductExist() {
		return productRepository.selectProductExist();
	}

	@Override
	public void delete(Product entity) {
		entity.setDeleted(true);
		productRepository.save(entity);
	}

	@Override
	public List<Product> selectAllProductForImageManage() {
		return productRepository.selectAllProductForImageManage();
	}	
	
	
}
