package com.mrunmai.springbootmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrunmai.springbootmvc.model.Alien;

@RestController // instead of writing @ResponseBody to every method change the type of
				// controller. Works only if all the methods are returning json.
public class AlienController {
	@Autowired
	AlienRepo repo;

	@GetMapping(path = "aliens", produces = "application/xml")
	// @ResponseBody // otherwise it will consider return statement as jsp page, and
	// not the data. Converts the java object into json
	public List<Alien> getAliens() {
		List<Alien> aliens = repo.findAll();
		System.out.println("fetching aliens");
		return aliens;
	}

	@GetMapping("alien/{aid}")
	// @ResponseBody
	public Alien getAlien(@PathVariable("aid") int aid) {
		Alien a = repo.findById(aid).orElse(new Alien(0, ""));
		return a;
	}

	@PostMapping(path = "alien", consumes = { "application/json" })
	public Alien addAlien(@RequestBody Alien a) {
		repo.save(a);
		return a;
	}
}

// @RequestBody converts the json object to java