package com.dtxmaker.kata.tennis2;

public class Deuce extends GameState
{
    public Deuce(TennisGame2 game)
    {
        super(game);
    }

    @Override
    public String getScore()
    {
        return "Deuce";
    }
}
