package fpt.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.edu.entity.Image;

@Repository
public interface ImageRepository  extends JpaRepository<Image, Long>{
	@Query(value = "SELECT * FROM `images` i WHERE i.deleted = false ORDER BY i.id DESC", nativeQuery = true)
	List<Image> selectImageExist();
	
	@Query(value = "SELECT * FROM `images` i WHERE i.deleted = false AND i.product_id = :productId ORDER BY p.id DESC", nativeQuery = true)
	List<Image> selectImagesProduct(@Param("productId") Long productId);
	
	@Query(value = "SELECT * FROM `images` i WHERE i.deleted = false and i.product_id = :product_id ORDER BY i.id DESC", nativeQuery = true)
	List<Image> findImageExistByProductId(@Param("product_id") Long product_id);
}
