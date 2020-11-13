package com.dicegame.securityjwt.dto;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "player") // Table name in database
public class Player {

	// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "player_name", // Column name in database
			columnDefinition = "varchar(255) default 'Anonymous'") // Default name if null
	private String playerName;
	@Column(name = "password") // Column name in database
	private String password;
	@Column(name = "success_rate") // Column name in database
	private Double successRate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_date") // Column name in database
	private Date regDate;

	// Entities relationship
	@OneToMany(mappedBy="player")
	@JsonIgnore //To fix issue with infinite recursion
	private List<DiceRoll> diceRolls;

	// CONSTRUCTORS

	public Player() {
	}

	public Player(Long id, String playerName, String password, Date regDate) {
		this.id = id;
		this.playerName = addName(playerName); 
		this.password = password;
		this.successRate = 0.0; // Should be 0 due to players has not played yet
		this.regDate =  new Date(System.currentTimeMillis());
	}

	// GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(Double successRate) {
		this.successRate = successRate ;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public List<DiceRoll> getDiceRoll() {
		return diceRolls;
	}

	public void setDiceRoll(List<DiceRoll> diceRoll) {
		this.diceRolls = diceRoll;
	}

	// METHODS

	// Player information
	@Override
	public String toString() {
		return "Player [id = " + id + ", player name = " + playerName + ", registration date = " + regDate + ", dice rolls = "
				+ this.diceRolls() + ", success rate = " + successRate + " ]";
	}
	
	// Set player as Anonymous if no name given
	private String addName(String name) {
		if (name == null) {
			name = "Anonymous";
		}
		return name;
	}

	// Get number of dice rolls
	public int diceRolls() {
		int diceRolls = this.diceRolls.size();
		return diceRolls;
	}

	// Update success rate
	public void updateSuccessRate() {
		
		// Count dice rolls won
		int diceRollsWon = 0;
		for (DiceRoll diceRoll : diceRolls) {
			if (diceRoll.checkIfWon()) {
				diceRollsWon++;
			}
		}
		// Calculates success rate = dice rolls won / number of dice rolls
		this.setSuccessRate ((double) diceRollsWon / (double) this.diceRolls());
	}

	// Roll the dices
	public DiceRoll rollTheDices() {
		// Get random number from 1-6 for two dices
		Random random = new Random();
		int dice1 = random.nextInt(5) + 1;
		int dice2 = random.nextInt(5) + 1;
		int sum = dice1 + dice2;

		// Check if player has won (sum of dices must be 7 in order to win)
		if (sum == 7) {
			System.out.println("You WON!");
		} else {
			System.out.println("You LOST!");
		}

		// Add a DiceRoll object to players dice roll list with obtained values
		DiceRoll diceRoll = new DiceRoll(null, dice1, dice2, this);
		this.diceRolls.add(diceRoll);
		
		//Update success rate
		this.updateSuccessRate();
		
		System.out.println(diceRoll.toString());
		
		return diceRoll;
	}

}
