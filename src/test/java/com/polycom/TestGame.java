package com.polycom;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.Before;
import org.junit.Test;

public class TestGame {
	 
    Player player1;
    Player player2;
    TennisGame game;
 
    @Before
    public void beforeGameTest() {
        player1 = new Player("Björn Borg");
        player2 = new Player("John McEnroe");
        game = new TennisGame(player1, player2);
    }
 
    @Test
    public void loveForZeroScore() {
        TennisGame game = new TennisGame(player1, player2);
        assertThat(game, hasProperty("currentScore", is("Love, Love")));
    }
 
    @Test
    public void fifteenForScoreFifteen() {
        player2.wonPoint();
        assertThat(game, hasProperty("currentScore", is("Love, Fifteen")));
    }
 
    @Test
    public void thirtyForScoreThirty() {
        player1.wonPoint();
        player1.wonPoint();
        player2.wonPoint();
        assertThat(game, hasProperty("currentScore", is("Thirty, Fifteen")));
    }
 
    @Test
    public void fortyForScoreForty() {
    	
    	for(int i=1;i<=3;i++){
    		player1.wonPoint();
    	}

        assertThat(game, hasProperty("currentScore", is("Forty, Love")));
    }
 
    @Test
    public void advantageWhenEachPlayerHas3PointsPlusAPlayerHasOnePointMore() {
    	for(int i=1;i<=3;i++){
    		player1.wonPoint();
    	}
        
        for(int i=1;i<=4;i++){
        	player2.wonPoint();
    	}

        assertThat(game, hasProperty("currentScore", is("Advantage John McEnroe")));
    }
 
    @Test
    public void advantageWhenEachPlayerHas3Points() {
        for(int index = 1; index <= 3; index++) {
            player1.wonPoint();
        }
        for(int index = 1; index <= 3; index++) {
            player2.wonPoint();
        }
        assertThat(game, hasProperty("currentScore", is("Deuce")));
        player1.wonPoint();
        assertThat(game, hasProperty("currentScore", is(not("Deuce"))));
        player2.wonPoint();
        assertThat(game, hasProperty("currentScore", is("Deuce")));
    }
 
    @Test
    public void gameWonByPlayerWith4PointsAnd2pointsAheadOfOther() {
        for(int index = 1; index <= 4; index++) {
            player1.wonPoint();
        }
        for(int index = 1; index <= 3; index++) {
            player2.wonPoint();
        }
        assertThat(game, hasProperty("currentScore", is(not("Win for Björn Borg"))));
        assertThat(game, hasProperty("currentScore", is(not("Win for John McEnroe"))));
        player1.wonPoint();
        assertThat(game, hasProperty("currentScore", is("Win for Björn Borg")));
    }
 
}
