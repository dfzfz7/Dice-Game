package com.dicegame.securityjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dicegame.securityjwt.dto.DiceRoll;

public interface IDiceRollDAO extends JpaRepository<DiceRoll, Long> {

}
