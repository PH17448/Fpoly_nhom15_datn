package fpt.edu.repository;
//
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import fpt.edu.entity.Brand;
import fpt.edu.entity.Discount;
@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long>{
	@Query(value = "SELECT * FROM Discounts d where d.deleted = false", nativeQuery = true)
	List<Discount> findAllDiscountExist();
}
