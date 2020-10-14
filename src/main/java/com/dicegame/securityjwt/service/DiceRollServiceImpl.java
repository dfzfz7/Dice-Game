package com.dicegame.securityjwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dicegame.securityjwt.dto.DiceRoll;
import com.dicegame.securityjwt.dao.IDiceRollDAO;

@Service
public class DiceRollServiceImpl implements IDiceRollService {

	// Use of methods from repository DAO
	@Autowired
	IDiceRollDAO iDiceRollDAO;

	// Create dice roll
	@Override
	public DiceRoll createDiceRoll(DiceRoll diceRoll) {
		return iDiceRollDAO.save(diceRoll);
	}

	// Get all dice rolls
	@Override
	public List<DiceRoll> listDiceRolls() {
		return iDiceRollDAO.findAll();
	}

	// Get dice roll by id
	@Override
	public DiceRoll getDiceRoll(Long id) {
		return iDiceRollDAO.findById(id).get();
	}

	// Update dice roll
	@Override
	public DiceRoll updateDiceRoll(DiceRoll diceRoll) {
		return iDiceRollDAO.save(diceRoll);
	}

	// Delete dice roll by id
	@Override
	public void deleteDiceRoll(Long id) {
		iDiceRollDAO.deleteById(id);
	}

}
