package fpt.edu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fpt.edu.entity.Image;
import fpt.edu.repository.ImageRepository;
import fpt.edu.service.ImageService;
import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService{
	private ImageRepository imageRepository;
	private static Logger logger = LoggerFactory.getLogger(Slf4j.class);

	@Override
	public List<Image> selectImageExist() {
		return imageRepository.selectImageExist();
	}
	
	@Override
	public List<Image> selectImagesProduct(Long productId) {
		return imageRepository.selectImagesProduct(productId);
	}

	@Override
	public <S extends Image> S save(S entity) {
		logger.info("Save image succs");
		entity.setDeleted(false);
		return imageRepository.save(entity);
	}

	@Override
	public void delete(Image entity) {
		entity.setDeleted(true);
		imageRepository.save(entity);
	}

	@Override
	public List<Image> findImageExistByProductId(Long id) {
		return imageRepository.findImageExistByProductId(id);
	}
	
	
}
