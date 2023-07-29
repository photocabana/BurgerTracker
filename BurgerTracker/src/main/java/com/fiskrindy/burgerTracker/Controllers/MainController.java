package com.fiskrindy.burgerTracker.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fiskrindy.burgerTracker.Models.Burger;
import com.fiskrindy.burgerTracker.Services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	BurgerService burgerService;
	
//	Gives us access to our whole database on our jsp page
	@GetMapping("/")
	public String dashboard(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	
//	When submitting the form, check for any errors in BindingResult
	@PostMapping("/addBurger")
	public String dashboard(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Burger> burgers = burgerService.allBurgers();
			model.addAttribute("burgers", burgers);
			return "index.jsp";
		}
		burgerService.addBurger(burger);
		return "redirect:/";
	}
	
//	Edit Singular
	@GetMapping("/edit/{id}")
	public String editBurger(@PathVariable("id") Long id, @ModelAttribute("burger") Burger burger, Model model) {
		model.addAttribute("burger", burgerService.findBurger(id));
		return "edit.jsp";
	}
	
//	ModelAttribute & BindingResult have to come before PathVariable
	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("burger", burger);
			return "index.jsp";
		}
		burgerService.edit(burger);
		return "redirect:/";
	}
}
