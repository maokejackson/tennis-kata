package com.dtxmaker.kata.tennis2;

public class GameOver extends GameState
{
    public GameOver(TennisGame2 game)
    {
        super(game);
    }

    @Override
    public String getScore()
    {
        return "Game to " + game.getLeadingPlayerName();
    }
}
