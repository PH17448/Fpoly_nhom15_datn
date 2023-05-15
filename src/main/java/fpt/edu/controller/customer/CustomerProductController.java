package fpt.edu.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerProductController {
	@RequestMapping(value= "product/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("customer/product/list");
		
		
		
		return mav ;
	}
}
