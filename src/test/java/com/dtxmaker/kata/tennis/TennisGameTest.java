package com.dtxmaker.kata.tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TennisGameTest
{
    @Test
    public void test_GameStart_LoveAll() throws Exception
    {
        TennisGame game = new TennisGame();
        assertEquals("Love All", game.getScore());
    }

    @Test
    public void test_S1_FifteenLove() throws Exception
    {
        TennisGame game = new TennisGame();
        game.serverScores();
        assertEquals("Fifteen Love", game.getScore());
    }

    @Test
    public void test_S2_ThirtyLove() throws Exception
    {
        TennisGame game = new TennisGame();
        game.serverScores();
        game.serverScores();
        assertEquals("Thirty Love", game.getScore());
    }

    @Test
    public void test_S3_ThirtyLove() throws Exception
    {
        TennisGame game = new TennisGame();
        game.serverScores();
        game.serverScores();
        game.serverScores();
        assertEquals("Forty Love", game.getScore());
    }

    @Test
    public void test_S4_GameToServer() throws Exception
    {
        TennisGame game = new TennisGame();
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.serverScores();
        assertEquals("Game to Server", game.getScore());
    }

    @Test
    public void test_R1_LoveFifteen() throws Exception
    {
        TennisGame game = new TennisGame();
        game.receiverScores();
        assertEquals("Love Fifteen", game.getScore());
    }

    @Test
    public void test_R2_LoveThirty() throws Exception
    {
        TennisGame game = new TennisGame();
        game.receiverScores();
        game.receiverScores();
        assertEquals("Love Thirty", game.getScore());
    }

    @Test
    public void test_R3_LoveForty() throws Exception
    {
        TennisGame game = new TennisGame();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        assertEquals("Love Forty", game.getScore());
    }

    @Test
    public void test_R4_GameToReceiver() throws Exception
    {
        TennisGame game = new TennisGame();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        assertEquals("Game to Receiver", game.getScore());
    }

    @Test
    public void test_R1S1_LoveFifteen() throws Exception
    {
        TennisGame game = new TennisGame();
        game.receiverScores();
        game.serverScores();
        assertEquals("Fifteen All", game.getScore());
    }

    @Test
    public void test_R3S1_FifteenForty() throws Exception
    {
        TennisGame game = new TennisGame();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.serverScores();
        assertEquals("Fifteen Forty", game.getScore());
    }

    @Test
    public void test_S3R3_Deuce() throws Exception
    {
        TennisGame game = new TennisGame();
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void test_S3R3S1_AdvantageServer() throws Exception
    {
        TennisGame game = new TennisGame();
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.serverScores();
        assertEquals("Advantage Server", game.getScore());
    }

    @Test
    public void test_S3R3S1R1_Deuce() throws Exception
    {
        TennisGame game = new TennisGame();
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.serverScores();
        game.receiverScores();
        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void test_S3R3S1R3_GameToReceiver() throws Exception
    {
        TennisGame game = new TennisGame();
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        assertEquals("Game to Receiver", game.getScore());
    }

    @Test
    public void test_S3R4_AdvantageReceiver() throws Exception
    {
        TennisGame game = new TennisGame();
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        assertEquals("Advantage Receiver", game.getScore());
    }

    @Test(expected = IllegalStateException.class)
    public void test_S4R1_GameOver() throws Exception
    {
        TennisGame game = new TennisGame();
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();
    }

    @Test(expected = IllegalStateException.class)
    public void test_R4S1_GameOver() throws Exception
    {
        TennisGame game = new TennisGame();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.serverScores();
    }
}
