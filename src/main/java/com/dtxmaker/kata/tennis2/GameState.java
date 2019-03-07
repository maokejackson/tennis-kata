package com.dtxmaker.kata.tennis2;

public abstract class GameState
{
    TennisGame2 game;

    public GameState(TennisGame2 game)
    {
        this.game = game;
    }

    public abstract String getScore();
}
