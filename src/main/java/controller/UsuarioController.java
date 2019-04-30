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

import model.Usuario;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/user");
		try {
			mv.addObject(userService.findAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
		
	}
	
	
	@GetMapping("/add")
	public ModelAndView add(Usuario user) {
		
		ModelAndView mv = new ModelAndView("/userAdd");
		mv.addObject("post", user);
		
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		try {
			return add(userService.findById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		try {
			userService.deletarUsuario(userService.findById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Usuario user, BindingResult result) {
	
		if(result.hasErrors()) {
			return add(user);
		}
		
		try {
			userService.cadastrarUsuario(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return findAll();
	}
	
	
}
