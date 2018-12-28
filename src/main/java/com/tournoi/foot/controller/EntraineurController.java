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

import com.tournoi.foot.model.Entraineur;
import com.tournoi.foot.service.EntraineurServiceImpl;

@Controller
@RequestMapping("/entraineur")
public class EntraineurController {

	@Autowired
	private EntraineurServiceImpl entraineurService;
	
	@RequestMapping(value= {"/", "/list"}, method=RequestMethod.GET)
	public ModelAndView getAllEntraineurs() {
		ModelAndView model = new ModelAndView();
		List<Entraineur> list = entraineurService.getAllEntraineurs();
		model.addObject("entraineur_list", list);
		model.setViewName("entraineur_list");
		return model;
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ModelAndView editEntraineur(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		Entraineur entraineur = entraineurService.findEntraineurById(id);
		model.addObject("entraineurForm", entraineur);
		model.setViewName("entraineur_form");
		return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addEntraineur() {
		ModelAndView model = new ModelAndView();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Entraineur entraineur = context.getBean("entraineur", Entraineur.class);
		model.addObject("entraineurForm", entraineur);
		model.setViewName("entraineur_form");
		context.close();
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("entraineurForm") Entraineur entraineur) {
		
		if (entraineur.getIdEntraineur() != null) {
			entraineurService.updateEntraineur(entraineur);
		} else {
			entraineurService.addEntraineur(entraineur);
		}
		return new ModelAndView("redirect:/entraineur/list");
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)	
	public ModelAndView deleteEntraineur(@PathVariable("id") int id) {
		entraineurService.deleteEntraineur(id);
		return new ModelAndView("redirect:/entraineur/list");
	}
}
