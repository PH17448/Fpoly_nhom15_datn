package fpt.edu.repository.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;

import fpt.edu.entity.Product;
import fpt.edu.entity.QBrand;
import fpt.edu.entity.QCategory;
import fpt.edu.entity.QDiscount;
import fpt.edu.entity.QProduct;
import fpt.edu.repository.ProductSearchRepository;
import fpt.edu.service.model.ProductSearchDTO;

@Repository
public class ProductSearchRepositoryImpl implements ProductSearchRepository{
	 EntityManager entityManager;

	public ProductSearchRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Product> searchProductExist(ProductSearchDTO productSearchDTO){
		JPAQuery<Product> query = new JPAQuery<Product>(entityManager);
		BooleanBuilder where = new BooleanBuilder();
		QProduct qProduct = QProduct.product;
		QBrand qBrand = QBrand.brand;
		QDiscount qDiscount = QDiscount.discount;
		QCategory qCategory = QCategory.category;

		where.and(qProduct.deleted.isFalse());
		where.and(qBrand.deleted.isFalse());
		where.and(qDiscount.deleted.isFalse());
		where.and(qCategory.deleted.isFalse());

		if(!productSearchDTO.getProductName().equalsIgnoreCase("-1")) {
			if(StringUtils.isNotEmpty(productSearchDTO.getProductName())) {
				where.and(qProduct.productName.containsIgnoreCase(productSearchDTO.getProductName()));
			}
		}
		List<Long> lstCategoryId = productSearchDTO.getCategoryIds();
		List<Long> lstBrandId = productSearchDTO.getBrandIds();
		List<Long> lstDiscountId = productSearchDTO.getDiscountIds();
		
			if(lstCategoryId.size() != 0) {
				where.and(qProduct.category.id.in(lstCategoryId));
			}
		
		
			if(lstBrandId.size() != 0) {
				where.and(qProduct.brand.id.in(lstBrandId));
			}
		
		
			if(lstDiscountId.size() != 0) {
				where.and(qProduct.discount.id.in(lstDiscountId));
			}
		
		
		if(!productSearchDTO.getMinPriceIn().toString().equalsIgnoreCase("-1") &
				!productSearchDTO.getMaxPriceIn().toString().equalsIgnoreCase("-1")) {
			if(!productSearchDTO.getMinPriceIn().toString().isEmpty() && 
					!productSearchDTO.getMaxPriceIn().toString().isEmpty()) {
				where.and(qProduct.priceIn.between(productSearchDTO.getMinPriceIn(), productSearchDTO.getMaxPriceIn()));
			}
		}
		if(!productSearchDTO.getMinPriceTag().toString().equalsIgnoreCase("-1") &&
				!productSearchDTO.getMaxPriceTag().toString().equalsIgnoreCase("-1") ) {
			if(!productSearchDTO.getMinPriceTag().toString().isEmpty() && 
					!productSearchDTO.getMaxPriceTag().toString().isEmpty()) {
				where.and(qProduct.priceTag.between(productSearchDTO.getMinPriceTag(), productSearchDTO.getMaxPriceTag()));
			}
		}
		
		if(!productSearchDTO.getMinQuantity().toString().equalsIgnoreCase("-1") &&
				!productSearchDTO.getMaxQuantity().toString().equalsIgnoreCase("-1")) {
			if(!productSearchDTO.getMinQuantity().toString().isEmpty() && 
					!productSearchDTO.getMaxQuantity().toString().isEmpty()) {
				where.and(qProduct.quantity.between(productSearchDTO.getMinQuantity(), productSearchDTO.getMaxQuantity()));
			}
		}

		if(!productSearchDTO.getMinNewPrice().toString().equalsIgnoreCase("-1") &&
				!productSearchDTO.getMaxNewPrice().toString().equalsIgnoreCase("-1")) {
			if(!productSearchDTO.getMinNewPrice().toString().isEmpty() && 
					!productSearchDTO.getMaxNewPrice().toString().isEmpty()) {
				where.and(qProduct.newPrice.between(productSearchDTO.getMinNewPrice(), productSearchDTO.getMaxNewPrice()));
			}
		}

//		if(String.valueOf(productSearchDTO.getStatus()).length() != 0) {
//			where.and(qProduct.newPrice.between(productSearchDTO.getMinNewPrice(), productSearchDTO.getMaxNewPrice()));
//		}

		if(!productSearchDTO.getCreatedBy().equalsIgnoreCase("-1")) {
			if(!productSearchDTO.getCreatedBy().toString().isEmpty()) {
				where.and(qProduct.createdBy.containsIgnoreCase(productSearchDTO.getCreatedBy()));
			}
		}

		if(!productSearchDTO.getLastModifedBy().equalsIgnoreCase("-1")) {
			if(!productSearchDTO.getLastModifedBy().toString().isEmpty()) {
				where.and(qProduct.lastModifedBy.containsIgnoreCase(productSearchDTO.getLastModifedBy()));
			}
		}
		
		Date CheckDate = Date.from(Instant.EPOCH);
		Instant minCreatedTime = productSearchDTO.getMinCreatedTime().toInstant();
		Instant maxCreatedTime = productSearchDTO.getMaxCreatedTime().toInstant();
		Instant minLastModifedTime = productSearchDTO.getMinLastModifedTime().toInstant();
		Instant maxLastModifedTime = productSearchDTO.getMaxLastModifedTime().toInstant();
		
		if(!productSearchDTO.getMinCreatedTime().toString().equalsIgnoreCase(""+CheckDate) &&
				!productSearchDTO.getMaxCreatedTime().toString().equalsIgnoreCase(""+CheckDate)) {
			if(!productSearchDTO.getMinLastModifedTime().toString().isEmpty() && 
					!productSearchDTO.getMaxLastModifedTime().toString().isEmpty()) {
				where.and(qProduct.lastModifedTime.between(minCreatedTime, maxCreatedTime));
			}
		}
		
		if(!productSearchDTO.getMinLastModifedTime().toString().equalsIgnoreCase(""+CheckDate) &&
				!productSearchDTO.getMaxLastModifedTime().toString().equalsIgnoreCase(""+CheckDate)) {
			if(!productSearchDTO.getMinLastModifedTime().toString().isEmpty() && 
					!productSearchDTO.getMaxLastModifedTime().toString().isEmpty()) {
				where.and(qProduct.lastModifedTime.between(minLastModifedTime, maxLastModifedTime));
			}
		}
		
		List<Product> result = query.from(qProduct).join(qCategory)
				.on(qProduct.category.id.eq(qCategory.id))
				.rightJoin(qBrand).on(qProduct.brand.id.eq(qBrand.id))
				.rightJoin(qDiscount).on(qProduct.discount.id.eq(qDiscount.id))
				.where(where)
				.orderBy(qProduct.id.desc())
				.fetch();
		return result;
	}
	
}
