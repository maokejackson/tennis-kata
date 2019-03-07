package com.dtxmaker.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class TennisGameTest
{
    protected static final String SERVER   = "Naomi";
    protected static final String RECEIVER = "Serena";

    private TennisGame game;

    @BeforeEach
    void before()
    {
        game = prepareGame();
    }

    protected abstract TennisGame prepareGame();

    private void serverWinBall()
    {
        serverWinBalls(1);
    }

    private void serverWinBalls(int balls)
    {
        for (int i = 0; i < balls; i++)
        {
            game.winBall(SERVER);
        }
    }

    private void receiverWinBall()
    {
        receiverWinBalls(1);
    }

    private void receiverWinBalls(int balls)
    {
        for (int i = 0; i < balls; i++)
        {
            game.winBall(RECEIVER);
        }
    }

    @Test
    void test_InvalidPlayer_Error()
    {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> game.winBall("Foo"));
        assertEquals("Player does not exist", thrown.getMessage());
    }

    @Test
    void test_GameStart_LoveAll()
    {
        assertEquals("Love-All", game.getScore());
    }

    @Test
    void test_S1_FifteenLove()
    {
        serverWinBalls(1);

        assertEquals("Fifteen-Love", game.getScore());
    }

    @Test
    void test_S2_ThirtyLove()
    {
        serverWinBalls(2);

        assertEquals("Thirty-Love", game.getScore());
    }

    @Test
    void test_S3_ThirtyLove()
    {
        serverWinBalls(3);

        assertEquals("Forty-Love", game.getScore());
    }

    @Test
    void test_S4_GameToServer()
    {
        serverWinBalls(4);

        assertEquals("Game to Naomi", game.getScore());
    }

    @Test
    void test_R1_LoveFifteen()
    {
        receiverWinBalls(1);

        assertEquals("Love-Fifteen", game.getScore());
    }

    @Test
    void test_R2_LoveThirty()
    {
        receiverWinBalls(2);

        assertEquals("Love-Thirty", game.getScore());
    }

    @Test
    void test_R3_LoveForty()
    {
        receiverWinBalls(3);

        assertEquals("Love-Forty", game.getScore());
    }

    @Test
    void test_R4_GameToReceiver()
    {
        receiverWinBalls(4);

        assertEquals("Game to Serena", game.getScore());
    }

    @Test
    void test_R1S1_LoveFifteen()
    {
        receiverWinBalls(1);
        serverWinBalls(1);

        assertEquals("Fifteen-All", game.getScore());
    }

    @Test
    void test_R3S1_FifteenForty()
    {
        receiverWinBalls(3);
        serverWinBalls(1);

        assertEquals("Fifteen-Forty", game.getScore());
    }

    @Test
    void test_S3R3_Deuce()
    {
        serverWinBalls(3);
        receiverWinBalls(3);

        assertEquals("Deuce", game.getScore());
    }

    @Test
    void test_S1R2S2R1_Deuce()
    {
        serverWinBalls(1);
        receiverWinBalls(2);
        serverWinBalls(2);
        receiverWinBalls(1);

        assertEquals("Deuce", game.getScore());
    }

    @Test
    void test_S3R3S1R1_Deuce()
    {
        serverWinBalls(3);
        receiverWinBalls(3);
        serverWinBalls(1);
        receiverWinBalls(1);

        assertEquals("Deuce", game.getScore());
    }

    @Test
    void test_S3R3S1_AdvantageServer()
    {
        serverWinBalls(3);
        receiverWinBalls(3);
        serverWinBalls(1);

        assertEquals("Advantage Naomi", game.getScore());
    }

    @Test
    void test_S1R2S2R1S1_AdvantageServer()
    {
        serverWinBalls(1);
        receiverWinBalls(2);
        serverWinBalls(2);
        receiverWinBalls(1);
        serverWinBalls(1);

        assertEquals("Advantage Naomi", game.getScore());
    }

    @Test
    void test_S3R4_AdvantageReceiver()
    {
        serverWinBalls(3);
        receiverWinBalls(4);

        assertEquals("Advantage Serena", game.getScore());
    }

    @Test
    void test_S1R2S2R2_AdvantageReceiver()
    {
        serverWinBalls(1);
        receiverWinBalls(2);
        serverWinBalls(2);
        receiverWinBalls(2);

        assertEquals("Advantage Serena", game.getScore());
    }

    @Test
    void test_S1R2S2R1S2_GameToServer()
    {
        serverWinBalls(1);
        receiverWinBalls(2);
        serverWinBalls(2);
        receiverWinBalls(1);
        serverWinBalls(2);

        assertEquals("Game to Naomi", game.getScore());
    }

    @Test
    void test_S3R3S1R3_GameToReceiver()
    {
        serverWinBalls(3);
        receiverWinBalls(3);
        serverWinBalls(1);
        receiverWinBalls(3);

        assertEquals("Game to Serena", game.getScore());
    }

    @Test
    void test_S4R1_GameOver()
    {
        serverWinBalls(4);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, this::receiverWinBall);
        assertEquals("Game over", thrown.getMessage());
    }

    @Test
    void test_S5_GameOver()
    {
        serverWinBalls(4);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, this::serverWinBall);
        assertEquals("Game over", thrown.getMessage());
    }

    @Test
    void test_R4S1_GameOver()
    {
        receiverWinBalls(4);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, this::serverWinBall);
        assertEquals("Game over", thrown.getMessage());
    }

    @Test
    void test_S3R3S1R3S1_GameOver()
    {
        serverWinBalls(3);
        receiverWinBalls(3);
        serverWinBalls(1);
        receiverWinBalls(3);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, this::serverWinBall);
        assertEquals("Game over", thrown.getMessage());
    }
}
