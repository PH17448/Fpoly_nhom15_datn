package fpt.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//
import fpt.edu.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductSearchRepository{
	@Query(value = "SELECT p.* FROM `products` p WHERE p.deleted = false ORDER BY p.id DESC", nativeQuery = true)
	List<Product> selectProductExist();
	
	@Query(value ="SELECT p.id, p.product_name, p.created_by, p.created_time FROM `products` p WHERE p.deleted = false ORDER BY p.id DESC", nativeQuery = true)
	List<Product> selectAllProductForImageManage();
}
