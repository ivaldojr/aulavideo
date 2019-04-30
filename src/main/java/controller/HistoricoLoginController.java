package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.HistoricoLogin;
import service.HistoricoLoginService;

@Controller
@RequestMapping("/histlogin")
public class HistoricoLoginController {

	@Autowired
	private HistoricoLoginService historicoService;
	
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/historicoLogin");
		mv.addObject("historicoLogins", historicoService.findAll());
		
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(HistoricoLogin historicoLogin) {
		
		ModelAndView mv = new ModelAndView("/historicoAdd");
		mv.addObject("historico", historicoLogin);
		
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(historicoService.findById(id));
	}
	

	@PostMapping("/save")
	public ModelAndView save(@Valid HistoricoLogin historicoLogin, BindingResult result) {
	
		if(result.hasErrors()) {
			return add(historicoLogin);
		}
		
		try {
			historicoService.cadastrarHistoricoLogin(historicoLogin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return findAll();
	}
	
}
