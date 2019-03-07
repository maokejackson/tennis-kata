package com.dtxmaker.kata.tennis;

import com.dtxmaker.kata.TennisGame;
import com.dtxmaker.kata.TennisGameTest;

public class TennisGame1Test extends TennisGameTest
{
    @Override
    protected TennisGame prepareGame()
    {
        return new TennisGame1(SERVER, RECEIVER);
    }
}
