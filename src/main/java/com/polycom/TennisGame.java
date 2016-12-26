package com.polycom;

public class TennisGame {

	private Player player1;
	private Player player2;

	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getCurrentScore() {
		if (player1.getScore() >= 3 && player2.getScore() >= 3) {
			if (Math.abs(player2.getScore() - player1.getScore()) >= 2) {
				return "Win for " + getLeadPlayer().getName();
			} else if (player1.getScore() == player2.getScore()) {
				return "Deuce";
			} else {
				return "Advantage " + getLeadPlayer().getName();
			}
		} else {
			return player1.getPointDescription() + ", " + player2.getPointDescription();
		}
	}

	public Player getLeadPlayer() {
		return (player1.getScore() > player2.getScore()) ? player1 : player2;
	}

}
