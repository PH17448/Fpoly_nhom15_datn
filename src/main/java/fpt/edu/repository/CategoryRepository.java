package fpt.edu.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import fpt.edu.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query(value = "SELECT * FROM categories c where c.deleted = false", nativeQuery = true)
	List<Category> findAllCategoryExist();
}
