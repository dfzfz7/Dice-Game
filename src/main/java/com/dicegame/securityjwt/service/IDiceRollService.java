package com.dicegame.securityjwt.service;

import java.util.List;

import com.dicegame.securityjwt.dto.DiceRoll;

public interface IDiceRollService {

	// CRUD METHODS

	// Create dice roll
	public DiceRoll createDiceRoll(DiceRoll diceRoll);

	// Get all dice rolls
	public List<DiceRoll> listDiceRolls();

	// Get dice roll by id
	public DiceRoll getDiceRoll(Long id);

	// Update dice roll
	public DiceRoll updateDiceRoll(DiceRoll diceRoll);

	// Delete dice roll by id
	public void deleteDiceRoll(Long id);

}
