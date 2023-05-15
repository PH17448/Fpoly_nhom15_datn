package fpt.edu.repository;
//
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fpt.edu.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
	@Query(value = "SELECT * FROM Brands b where b.deleted = false", nativeQuery = true)
	List<Brand> findAllBrandExist();
}
