package com.thymleaf.springbootthymleaf;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thymleaf.springbootthymleaf.demo.domain.Player;
import com.thymleaf.springbootthymleaf.demo.domain.Team;

@RestController
public class WebView {
	
	private Team team;
	
	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<>();
		players.add(new Player ("Charlie Brown", "Pitcher"));
		players.add(new Player ("Snoopy", "ShortStop"));
		players.add(new Player ("Charlie Brown", "Pitcher"));
		
		team = new Team ("California", "Peanuts", players);
	}
	
	@RequestMapping ("/hi")
	public @ResponseBody Team hiThere() {
		return team;
	}

}
