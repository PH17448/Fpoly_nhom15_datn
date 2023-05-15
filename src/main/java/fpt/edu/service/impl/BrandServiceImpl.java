package fpt.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.entity.Brand;
import fpt.edu.repository.BrandRepository;
import fpt.edu.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public List<Brand> findAllBrandExist() {
		return brandRepository.findAllBrandExist();
	}
	
	
}
