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

import com.tournoi.foot.model.Equipe;
import com.tournoi.foot.service.EquipeServiceImpl;

@Controller
@RequestMapping("/equipe")
public class EquipeController {

	@Autowired
	private EquipeServiceImpl equipeService;
	
	@RequestMapping(value= {"/", "/list"}, method=RequestMethod.GET)
	public ModelAndView getAllEquipes() {
		ModelAndView model = new ModelAndView();
		List<Equipe> list = equipeService.getAllEquipes();
		model.addObject("equipe_list", list);
		model.setViewName("equipe_list");
		return model;
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ModelAndView editEquipe(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		Equipe equipe = equipeService.findEquipeById(id);
		model.addObject("equipeForm", equipe);
		model.setViewName("equipe_form");
		return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addEquipe() {
		ModelAndView model = new ModelAndView();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Equipe equipe = context.getBean("equipe", Equipe.class);
		model.addObject("equipeForm", equipe);
		model.setViewName("equipe_form");
		context.close();
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("equipeForm") Equipe equipe) {
		
		if (equipe.getIdEquipe() != null) {
			equipeService.updateEquipe(equipe);
		} else {
			equipeService.addEquipe(equipe);
		}
		return new ModelAndView("redirect:/equipe/list");
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)	
	public ModelAndView deleteEquipe(@PathVariable("id") int id) {
		equipeService.deleteEquipe(id);
		return new ModelAndView("redirect:/equipe/list");
	}
	
}
