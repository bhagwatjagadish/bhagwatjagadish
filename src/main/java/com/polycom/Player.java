package com.polycom;

import java.util.Arrays;
import java.util.List;

public class Player {

    public static final List<String> pointsDescription = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
    
    public Player(String name) {
        this.name = name;
    }

    private int score;
    private String name;
    
    public int getScore() {
        return score;
    }
    
    public String getName() {
        return name;
    }

    public void wonPoint() {
        this.score = this.score + 1;
    }

    public String getPointDescription(){
        return pointsDescription.get(score);
    }

}
