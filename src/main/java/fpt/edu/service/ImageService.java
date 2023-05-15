package fpt.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fpt.edu.entity.Image;
import fpt.edu.entity.Product;

public interface ImageService {

	List<Image> selectImagesProduct(Long productId);

	List<Image> selectImageExist();

	void delete(Image entity);

	<S extends Image> S save(S entity);

	List<Image> findImageExistByProductId(Long product_id);
	
}
