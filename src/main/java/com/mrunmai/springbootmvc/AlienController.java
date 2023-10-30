package com.mrunmai.springbootmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mrunmai.springbootmvc.model.Alien;

@RestController // instead of writing @ResponseBody to every method change the type of
				// controller. But if some methods are normal methods then go back to mvc
				// controller.
public class AlienController {
	@Autowired
	AlienRepo repo;

	@GetMapping("aliens")
//	@ResponseBody // otherwise it will consider return statement as jsp page, and not the data.
	public List<Alien> getAliens() {
		List<Alien> aliens = repo.findAll();

		return aliens;
	}

	@GetMapping("alien/{aid}")
//	@ResponseBody
	public Alien getAlien(@PathVariable("aid") int aid) {
		Alien a = repo.findById(aid).orElse(new Alien(0, ""));
		return a;
	}
}
