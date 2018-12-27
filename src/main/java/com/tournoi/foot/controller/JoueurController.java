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

import com.tournoi.foot.model.Joueur;
import com.tournoi.foot.service.JoueurServiceImpl;

@Controller
@RequestMapping("/joueur")
public class JoueurController {
	
	@Autowired
	private JoueurServiceImpl joueurService;
	
	@RequestMapping(value= {"/", "/list"}, method=RequestMethod.GET)
	public ModelAndView getAllJoueur() {
		ModelAndView model = new ModelAndView();
		List<Joueur> list = joueurService.getAllJoueur();
		model.addObject("joueur_list", list);
		model.setViewName("joueur_list");
		return model;
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ModelAndView editJoueur(@PathVariable int id) {
		ModelAndView model = new ModelAndView();
		Joueur joueur = joueurService.findJoueurById(id);
		model.addObject("joueurForm", joueur);
		model.setViewName("joueur_form");
		return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addJoueur() {
		ModelAndView model = new ModelAndView();		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Joueur joueur = context.getBean("joueur", Joueur.class);
		model.addObject("joueurForm", joueur);
		model.setViewName("joueur_form");
		context.close();
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("joueurForm") Joueur joueur) {
		
		if (joueur.getIdJoueur() != null) {
			joueurService.updateJoueur(joueur);
		} else {
			joueurService.addJoueur(joueur);
		}
		return new ModelAndView("redirect:/joueur/list");
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)	
	public ModelAndView deleteJoueur(@PathVariable("id") int id) {
		joueurService.deleteJoueur(id);
		return new ModelAndView("redirect:/joueur/list");
	}
}
