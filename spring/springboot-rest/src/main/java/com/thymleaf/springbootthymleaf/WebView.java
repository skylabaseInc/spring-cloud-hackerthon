package com.thymleaf.springbootthymleaf;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thymleaf.springbootthymleaf.demo.dao.TeamDao;
import com.thymleaf.springbootthymleaf.demo.domain.Player;
import com.thymleaf.springbootthymleaf.demo.domain.Team;

@RestController
public class WebView {
	@Autowired
	TeamDao teamDao;
	
	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<>();
		players.add(new Player ("Charlie Brown", "Pitcher"));
		players.add(new Player ("Snoopy", "ShortStop"));
		players.add(new Player ("Charlie Brown", "Pitcher"));
		
		Team team = new Team ("California", "Peanuts", players);
		teamDao.save(team);
	}
	
	@RequestMapping ("/hi/{name}")
	public @ResponseBody Team hiThere(@PathVariable String name) {
		return teamDao.findByName(name);
	}

}
