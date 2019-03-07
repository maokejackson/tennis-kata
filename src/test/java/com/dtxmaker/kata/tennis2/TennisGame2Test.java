package com.dtxmaker.kata.tennis2;

import com.dtxmaker.kata.TennisGame;
import com.dtxmaker.kata.TennisGameTest;

public class TennisGame2Test extends TennisGameTest
{
    @Override
    protected TennisGame prepareGame()
    {
        return new TennisGame2(SERVER, RECEIVER);
    }
}
