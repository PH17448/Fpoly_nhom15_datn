package fpt.edu.controller.admin;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fpt.edu.entity.Image;
import fpt.edu.entity.Product;
import fpt.edu.service.ImageService;
import fpt.edu.service.ProductService;
import fpt.edu.service.StorageService;
import fpt.edu.service.model.ImageDTO;
import fpt.edu.service.model.ImageProductDTO;

@Controller
@RequestMapping("admin/image")
public class ImageController {
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private StorageService storageService;
	
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
		Resource file = storageService.loadAsResource(filename);
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
//	
//	@GetMapping("imageManage")
//	public String imageManage(ModelMap model) {
//		List<Image> lstImg = imageService.selectImageExist();
//		List<Product> lstSp = productService.selectAllProductForImageManage();
//		List<ImageProductDTO> lstImageProduct = new ArrayList<ImageProductDTO>();
//		lstSp.stream().forEach(p ->{
//			ImageProductDTO dto = new ImageProductDTO();
//			dto.setProductId(p.getId());
//			dto.setProductName(p.getProductName());
//			dto.setImages(lstImg);
//			dto.setCreatedTime(p.getCreatedTime());
//			dto.setCreatedBy(p.getCreatedBy());
//			lstImageProduct.add(dto);
//		});
//		model.addAttribute("imageProducts", lstImageProduct);
//		return "dashboard/image/imageManage";
//	}
}
