package com.fiskrindy.burgerTracker.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fiskrindy.burgerTracker.Models.Burger;
import com.fiskrindy.burgerTracker.Repositories.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository burgerRepo;
	
	public BurgerService(BurgerRepository burgerRepo) {
		this.burgerRepo = burgerRepo;
	}
	
	public List<Burger> allBurgers() {
		return burgerRepo.findAll();
	}
	
	public Burger addBurger(Burger burger) {
		return burgerRepo.save(burger);
	}
	
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepo.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		}
		return null;
	}
	
	public Burger edit(Burger burger) {
		return burgerRepo.save(burger);
	}
}
