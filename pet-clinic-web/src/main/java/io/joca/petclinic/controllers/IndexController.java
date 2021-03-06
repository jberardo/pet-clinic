package io.joca.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Joao Berardo
 * @since Feb. 07, 2019
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping({ "", "/", "/index", "index.html" })
	public String index() {
		return "index";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/oups")
	public String oups() {
		return "notimplemented";
	}
}