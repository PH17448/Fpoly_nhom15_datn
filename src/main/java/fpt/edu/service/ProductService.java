package fpt.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fpt.edu.entity.Product;
import fpt.edu.service.model.ProductSearchDTO;

public interface ProductService {

	void delete(Product entity);

	Optional<Product> findById(Long id);

	<S extends Product> S save(S entity);

	List<Product> searchProductExist(ProductSearchDTO productSearchDTO);

	List<Product> selectProductExist();

	List<Product> selectAllProductForImageManage();
}
