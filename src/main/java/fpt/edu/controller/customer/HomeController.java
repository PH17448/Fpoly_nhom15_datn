package fpt.edu.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value="homeControllerOfCustomer")
public class HomeController {
	@RequestMapping(value= {"/home/index","/"},method=RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("redirect:/product/list");
		return mav ;
	}
}
