package com.dicegame.securityjwt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dice_roll") // Table name in database
public class DiceRoll {

	// ATTRIBUTES

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "dice_1") // Column name in database
	private int dice1;
	@Column(name = "dice_2") // Column name in database
	private int dice2;
	@Column(name = "won")
	private boolean won;

	@ManyToOne // Entities relationship
	@JoinColumn(name = "player_id")
	@JsonIgnore // To fix issue with infinite recursion
	private Player player;

	// CONSTRUCTORS

	public DiceRoll() {
	}

	public DiceRoll(Long id, int dice1, int dice2, Player player) {
		this.id = id;
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.won = checkIfWon();
		this.player = player;
	}

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDice1() {
		return dice1;
	}

	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	public int getDice2() {
		return dice2;
	}

	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	// METHODS

	// Dice roll information
	@Override
	public String toString() {
		return "Dice Roll [id = " + id + ", dice 1 = " + dice1 + ", dice 2 = " + dice2 + ", roll won =" + won + ", player = " + player
				+ " ]";
	}

	// Check if dice roll was won (sum of dices must be 7 in order to win)
	public boolean checkIfWon() {
		int sum = dice1 + dice2;
		if (sum == 7) {
			won = true;
		} else {
			won = false;
		}
		return won;
	}
}
