package com.dtxmaker.kata.tennis2;

import java.util.HashMap;
import java.util.Map;

public class Initial extends GameState
{
    public Initial(TennisGame2 game)
    {
        super(game);
    }

    @Override
    public String getScore()
    {
        if (game.isTie())
        {
            return SCORES.get(game.getServerScore()) + "-All";
        }
        else
        {
            return SCORES.get(game.getServerScore()) + "-" + SCORES.get(game.getReceiverScore());
        }
    }

    private static final Map<Integer, String> SCORES = new HashMap<>();

    static
    {
        SCORES.put(0, "Love");
        SCORES.put(1, "Fifteen");
        SCORES.put(2, "Thirty");
        SCORES.put(3, "Forty");
    }
}
