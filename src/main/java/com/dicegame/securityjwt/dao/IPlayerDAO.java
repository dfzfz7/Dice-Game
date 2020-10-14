package com.dicegame.securityjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dicegame.securityjwt.dto.Player;

public interface IPlayerDAO extends JpaRepository<Player, Long> {

}
