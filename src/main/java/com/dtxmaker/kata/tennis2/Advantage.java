package com.dtxmaker.kata.tennis2;

public class Advantage extends GameState
{
    public Advantage(TennisGame2 game)
    {
        super(game);
    }

    @Override
    public String getScore()
    {
        return "Advantage " + game.getLeadingPlayerName();
    }
}
