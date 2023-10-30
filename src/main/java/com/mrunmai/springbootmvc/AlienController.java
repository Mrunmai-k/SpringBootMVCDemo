package com.mrunmai.springbootmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrunmai.springbootmvc.model.Alien;

@Controller
public class AlienController {
	@Autowired
	AlienRepo repo;
	
	@GetMapping("aliens")
	@ResponseBody // otherwise it will consider return statement as jsp page, and not the data.
    public List<Alien> getAliens() {
        List<Alien> aliens = repo.findAll();
        
        return aliens;
    }
}
