package fpt.edu.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fpt.edu.entity.Brand;
import fpt.edu.entity.Category;
import fpt.edu.entity.Discount;
import fpt.edu.entity.Image;
import fpt.edu.entity.Product;
import fpt.edu.helper.TypeHelper;
import fpt.edu.service.BrandService;
import fpt.edu.service.CategoryService;
import fpt.edu.service.DiscountService;
import fpt.edu.service.ImageService;
import fpt.edu.service.ProductService;
import fpt.edu.service.StorageService;
import fpt.edu.service.model.BrandDTO;
import fpt.edu.service.model.CategoryDTO;
import fpt.edu.service.model.DiscountDTO;
import fpt.edu.service.model.ImageProductDTO;
import fpt.edu.service.model.ProductSearchDTO;

@Controller
@RequestMapping("admin/product")
public class ProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private DiscountService discountService;
	
	@Autowired
	private TypeHelper typeHelper;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private StorageService storageService;

	@ModelAttribute("categories")
	public List<CategoryDTO> getCategories(){
		return categoryService.findAllCategoryExist().stream().map(item->{
			CategoryDTO dto = new CategoryDTO();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).collect(Collectors.toList());
	}

	@ModelAttribute("brands")
	public List<BrandDTO> getBrands(){
		return brandService.findAllBrandExist().stream().map(item->{
			BrandDTO dto = new BrandDTO();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).collect(Collectors.toList());
	}

	@ModelAttribute("discounts")
	public List<DiscountDTO> getDiscounts(){
		return discountService.findAllDiscountExist().stream().map(item->{
			DiscountDTO dto = new DiscountDTO();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).collect(Collectors.toList());
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model,
			@PathVariable("id") Long id) {
		Optional<Product> optProduct = productService.findById(id);
		List<Image> optImage = imageService.findImageExistByProductId(id);
		ImageProductDTO dto = new ImageProductDTO();
		if(optProduct.isPresent()) {
			Product entity = optProduct.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setProductId(entity.getId());
			dto.setCategoryId(entity.getCategory().getId());
			dto.setBrandId(entity.getBrand().getId());
			dto.setDiscountId(entity.getDiscount().getId());
			dto.setIsEdit(true);
			//sua
			model.addAttribute("productDTO", dto);
			return new ModelAndView("dashboard/product/addOrEdit", model);
		}
		model.addAttribute("messageDanger", "Sản phẩm không tồn tại");

		return new ModelAndView("dashboard/product/productManage", model);
	}

	@GetMapping("add")
	public String add(ModelMap model) {
//		model.addAttribute("productDTO", new ProductDTO());
//		model.addAttribute("imageDTO", new ImageDTO());
		model.addAttribute("imageProductDTO", new ImageProductDTO());
		return "dashboard/product/addOrEdit";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @ModelAttribute("productSearchDTO") ProductSearchDTO dataSearch,
			@PathVariable("id") Long id) throws IOException {

		Optional<Product> opt = productService.findById(id);

		if(opt.isPresent()) {
//			if(!StringUtils.isEmpty(opt.get().getImage())) {
//				storageService.delete(opt.get().getImage());
//			}
			productService.delete(opt.get());

			model.addAttribute("messageSuccess", "Đã xóa sản phẩm thành công");

		}else model.addAttribute("messageDanger", "Sản phẩm không tồn tại");

		this.searchProductExist(model, dataSearch);
		return new ModelAndView("/dashboard/product/productManage", model);
	}

	@PostMapping("productManage")
	public ModelAndView saveOrUpdateProduct(ModelMap model, @ModelAttribute("productSearchDTO") ProductSearchDTO dataSearch,
			@Valid @ModelAttribute("imageProductDTO") ImageProductDTO imageProductDTO,
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("imageProductDTO", imageProductDTO);
			return new ModelAndView("dashboard/product/addOrEdit", model);
		}
		Product product = new Product();
		BeanUtils.copyProperties(imageProductDTO, product);

		Category category = new Category();
		category.setId(imageProductDTO.getCategoryId());
		product.setCategory(category);

		Brand brand = new Brand();
		brand.setId(imageProductDTO.getBrandId());
		product.setBrand(brand);

		Discount discount = new Discount();
		discount.setId(imageProductDTO.getDiscountId());
		product.setDiscount(discount);
		
		productService.save(product);
		
		Image image = new Image();
		imageProductDTO.getImgFiles().stream().filter(m -> !m.isEmpty()).forEach(i ->{
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();
			
			image.setImgLink(storageService.getStoredFileName(i, uuString));
			storageService.store(i, image.getImgLink());
			image.setProduct(product);
			imageService.save(image);
		});
			
		if(imageProductDTO.getIsEdit() == false) {
			model.addAttribute("messageSuccess","Thêm mới sản phẩm thành công");
		}else model.addAttribute("messageDanger", "Cập nhật sản phẩm thành công");
		this.searchProductExist(model, dataSearch);
		return new ModelAndView("dashboard/product/productManage");
	}

	@PostMapping("deleteAllByIds")
	public ModelAndView deleteAllById(ModelMap model, @ModelAttribute("productSearchDTO") ProductSearchDTO dataSearch,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		String[] ids = request.getParameterValues("productIds");

		if(ids != null) {
			for(String item: ids) {
				Optional<Product> opt = productService.findById(Long.parseLong(item));
				if(opt.isPresent()) {
//					if(!StringUtils.isEmpty(opt.get().getImage())) {
//						storageService.delete(opt.get().getImage());
//					}
					productService.delete(opt.get());
				}
			}
			model.addAttribute("messageSuccess", "Đã xóa hết những sản phẩm đã chọn");

			this.searchProductExist(model, dataSearch);
			return new ModelAndView("dashboard/product/productManage", model);
		}else model.addAttribute("messageDanger", "Bạn chưa chọn ô checkbox nào");

		this.searchProductExist(model, dataSearch);
		return new ModelAndView("dashboard/product/productManage", model);
	}

	@GetMapping("productManage")
	public String productManage(ModelMap model) {
		List<Product> products = productService.selectProductExist();
		model.addAttribute("products", products);
		model.addAttribute("productSearchDTO", new ProductSearchDTO());
		return "dashboard/product/productManage";
	}
	
	@GetMapping("searchProductManage")
	public String searchProductManage(ModelMap model, @ModelAttribute("productSearchDTO") ProductSearchDTO dataSearch) {
		Optional<ProductSearchDTO> opt = Optional.of(dataSearch);
		if(opt.isPresent()) {
			this.searchProductExist(model, dataSearch);
			return "dashboard/product/productManage";
		}else {
			List<Product> products = productService.selectProductExist();
			model.addAttribute("products", products);
			model.addAttribute("productSearchDTO", opt.get());
			return "dashboard/product/productmanage";
		}
	}

	public void searchProductExist(ModelMap model, ProductSearchDTO dataSearch) {
		Optional<ProductSearchDTO> opt = Optional.of(dataSearch);
		if(opt.isPresent()) {
			String productName = typeHelper.convertObjectTypeString(dataSearch.getProductName());
			List<Long> lstBrand = typeHelper.convertObjectTypeListLong(dataSearch.getBrandIds());
			List<Long> lstCategory = typeHelper.convertObjectTypeListLong(dataSearch.getCategoryIds());
			List<Long> lstDiscount = typeHelper.convertObjectTypeListLong(dataSearch.getDiscountIds());
			BigDecimal minNewPrice = typeHelper.convertObjectTypeBigDecimal(dataSearch.getMinNewPrice());
			BigDecimal maxNewPrice = typeHelper.convertObjectTypeBigDecimal(dataSearch.getMaxNewPrice());
			BigDecimal minPriceIn = typeHelper.convertObjectTypeBigDecimal(dataSearch.getMinPriceIn());
			BigDecimal maxPriceIn = typeHelper.convertObjectTypeBigDecimal(dataSearch.getMaxPriceIn());
			BigDecimal minPriceTag = typeHelper.convertObjectTypeBigDecimal(dataSearch.getMinPriceTag());
			BigDecimal maxPriceTag = typeHelper.convertObjectTypeBigDecimal(dataSearch.getMaxPriceTag());
			BigDecimal minQuantity = typeHelper.convertObjectTypeBigDecimal(dataSearch.getMinQuantity());
			BigDecimal maxQuantity = typeHelper.convertObjectTypeBigDecimal(dataSearch.getMaxQuantity());
			String createdBy = typeHelper.convertObjectTypeString(dataSearch.getCreatedBy());
			String lastModifedBy = typeHelper.convertObjectTypeString(dataSearch.getLastModifedBy());
			Date minCreatedTime = typeHelper.convertObjectTypeDate(dataSearch.getMinCreatedTime());
			Date maxCreatedTime = typeHelper.convertObjectTypeDate(dataSearch.getMaxCreatedTime());
			Date minLastModifedTime = typeHelper.convertObjectTypeDate(dataSearch.getMinLastModifedTime());
			Date maxLastModifedTime = typeHelper.convertObjectTypeDate(dataSearch.getMaxLastModifedTime());
			ProductSearchDTO data = new ProductSearchDTO(-1L, productName, minPriceIn,
					maxPriceIn, minPriceTag, maxPriceTag, minNewPrice, maxNewPrice, minQuantity, maxQuantity
					, lstCategory, lstBrand, lstDiscount, false, createdBy, minCreatedTime, maxCreatedTime,
					lastModifedBy, minLastModifedTime, maxLastModifedTime, dataSearch.getIsEdit());
			List<Product> result = productService.searchProductExist(data);
			model.addAttribute("products", result);
			model.addAttribute("productSearchDTO", dataSearch);
		}
	}
}
