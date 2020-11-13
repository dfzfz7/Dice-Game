package com.dicegame.securityjwt.service;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dicegame.securityjwt.dao.IPlayerDAO;
import com.dicegame.securityjwt.dto.Player;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	// Use of methods from repository DAO
	@Autowired
	private IPlayerDAO iPlayerDAO;
	
	// Retrieves the Player using the DAO and returns a User to be authenticated by Spring
	@Override
	public UserDetails loadUserByUsername(String playerName) throws UsernameNotFoundException {
		Player player = iPlayerDAO.findByPlayerName(playerName);
        if (player == null) {
            throw new UsernameNotFoundException(playerName);
        }
        return new User(player.getPlayerName(), player.getPassword(), emptyList());
	}

}
