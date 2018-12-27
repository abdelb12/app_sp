package com.tournoi.foot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tournoi.foot.model.Arbitre;
import com.tournoi.foot.service.ArbitreServiceImpl;

@Controller
@RequestMapping("/arbitre")
public class ArbitreController {
	
	@Autowired
	private ArbitreServiceImpl arbitreService;
	
	@RequestMapping(value= {"/", "/list"}, method=RequestMethod.GET)
	public ModelAndView getAllArbitres() {
		ModelAndView model = new ModelAndView();
		List<Arbitre> list = arbitreService.getAllArbitres();
		model.addObject("arbitre_list", list);
		model.setViewName("arbitre_list");
		return model;
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ModelAndView editArbitre(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		Arbitre arbitre = arbitreService.findArbitreById(id);
		model.addObject("arbitreForm", arbitre);
		model.setViewName("arbitre_form");
		return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addArbitre() {
		ModelAndView model = new ModelAndView();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Arbitre arbitre = context.getBean("arbitre", Arbitre.class);
		model.addObject("arbitreForm", arbitre);
		model.setViewName("arbitre_form");
		context.close();
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("arbitreForm") Arbitre arbitre) {
		
		if (arbitre.getIdArbitre() != null) {
			arbitreService.updateArbitre(arbitre);
		} else {
			arbitreService.addArbitre(arbitre);
		}
		return new ModelAndView("redirect:/arbitre/list");
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)	
	public ModelAndView deleteArbitre(@PathVariable("id") int id) {
		arbitreService.deleteArbitre(id);
		return new ModelAndView("redirect:/arbitre/list");
	}

}
