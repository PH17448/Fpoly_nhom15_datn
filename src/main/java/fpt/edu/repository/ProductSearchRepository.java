package fpt.edu.repository;
import java.util.List;
import org.springframework.stereotype.Repository;
import fpt.edu.entity.Product;
import fpt.edu.service.model.ProductSearchDTO;
@Repository
public interface ProductSearchRepository{

	public List<Product> searchProductExist(ProductSearchDTO productSearchDTO);

}
