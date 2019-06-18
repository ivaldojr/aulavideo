package com.leydiane.aulavideo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leydiane.aulavideo.model.Link;
import com.leydiane.aulavideo.service.LinkService;

@Controller
@RequestMapping("/link")
public class LinkController {
	
	@Autowired
	private LinkService linkService;
	
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/link");
		try {
			mv.addObject("links", linkService.findAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Link link) {
		
		ModelAndView mv = new ModelAndView("/linkAdd");
		mv.addObject("link", link);
		
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		try {
			return add(linkService.findById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		try {
			linkService.deletarLink(linkService.findById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Link link, BindingResult result) {
	
		if(result.hasErrors()) {
			return add(link);
		}
		
		try {
			linkService.cadastrarLink(link);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		return findAll();
	}
	
	
}
