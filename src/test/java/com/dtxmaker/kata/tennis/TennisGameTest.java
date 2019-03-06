package com.dtxmaker.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TennisGameTest
{
    private TennisGame game = new TennisGame();

    @Test
    public void test_GameStart_LoveAll() throws Exception
    {
        assertEquals("Love All", game.getScore());
    }

    @Test
    public void test_S1_FifteenLove() throws Exception
    {
        game.serverScores();

        assertEquals("Fifteen Love", game.getScore());
    }

    @Test
    public void test_S2_ThirtyLove() throws Exception
    {
        game.serverScores();
        game.serverScores();

        assertEquals("Thirty Love", game.getScore());
    }

    @Test
    public void test_S3_ThirtyLove() throws Exception
    {
        game.serverScores();
        game.serverScores();
        game.serverScores();

        assertEquals("Forty Love", game.getScore());
    }

    @Test
    public void test_S4_GameToServer() throws Exception
    {
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.serverScores();

        assertEquals("Game to Server", game.getScore());
    }

    @Test
    public void test_R1_LoveFifteen() throws Exception
    {
        game.receiverScores();

        assertEquals("Love Fifteen", game.getScore());
    }

    @Test
    public void test_R2_LoveThirty() throws Exception
    {
        game.receiverScores();
        game.receiverScores();

        assertEquals("Love Thirty", game.getScore());
    }

    @Test
    public void test_R3_LoveForty() throws Exception
    {
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();

        assertEquals("Love Forty", game.getScore());
    }

    @Test
    public void test_R4_GameToReceiver() throws Exception
    {
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();

        assertEquals("Game to Receiver", game.getScore());
    }

    @Test
    public void test_R1S1_LoveFifteen() throws Exception
    {
        game.receiverScores();
        game.serverScores();

        assertEquals("Fifteen All", game.getScore());
    }

    @Test
    public void test_R3S1_FifteenForty() throws Exception
    {
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.serverScores();

        assertEquals("Fifteen Forty", game.getScore());
    }

    @Test
    public void test_S3R3_Deuce() throws Exception
    {
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();

        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void test_S1R2S2R1_Deuce() throws Exception
    {
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();

        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void test_S3R3S1R1_Deuce() throws Exception
    {
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
    public void test_S3R3S1_AdvantageServer() throws Exception
    {
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
    public void test_S1R2S2R1S1_AdvantageServer() throws Exception
    {
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();
        game.serverScores();

        assertEquals("Advantage Server", game.getScore());
    }

    @Test
    public void test_S3R4_AdvantageReceiver() throws Exception
    {
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();

        assertEquals("Advantage Receiver", game.getScore());
    }

    @Test
    public void test_S1R2S2R2_AdvantageReceiver() throws Exception
    {
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();
        game.receiverScores();

        assertEquals("Advantage Receiver", game.getScore());
    }

    @Test
    public void test_S1R2S2R1S2_GameToServer() throws Exception
    {
        game.serverScores();
        game.receiverScores();
        game.receiverScores();
        game.serverScores();
        game.serverScores();
        game.receiverScores();
        game.serverScores();
        game.serverScores();

        assertEquals("Game to Server", game.getScore());
    }

    @Test
    public void test_S3R3S1R3_GameToReceiver() throws Exception
    {
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
    public void test_S4R1_GameOver() throws Exception
    {
        game.serverScores();
        game.serverScores();
        game.serverScores();
        game.serverScores();

        IllegalStateException thrown = assertThrows(IllegalStateException.class, game::receiverScores);
        assertEquals("Game over", thrown.getMessage());
    }

    @Test
    public void test_R4S1_GameOver() throws Exception
    {
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();
        game.receiverScores();

        IllegalStateException thrown = assertThrows(IllegalStateException.class, game::serverScores);
        assertEquals("Game over", thrown.getMessage());
    }

    @Test
    public void test_S3R3S1R3S1_GameOver() throws Exception
    {
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

        IllegalStateException thrown = assertThrows(IllegalStateException.class, game::serverScores);
        assertEquals("Game over", thrown.getMessage());
    }
}
