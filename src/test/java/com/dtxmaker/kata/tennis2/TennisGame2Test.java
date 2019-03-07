package com.dtxmaker.kata.tennis2;

import com.dtxmaker.kata.TennisGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TennisGame2Test
{
    private static final String SERVER   = "Naomi";
    private static final String RECEIVER = "Serena";

    private TennisGame game = new TennisGame2(SERVER, RECEIVER);

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
    public void test_InvalidPlayer_Error() throws Exception
    {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> game.winBall("Foo"));
        assertEquals("Player does not exist", thrown.getMessage());
    }

    @Test
    public void test_GameStart_LoveAll() throws Exception
    {
        assertEquals("Love-All", game.getScore());
    }

    @Test
    public void test_S1_FifteenLove() throws Exception
    {
        serverWinBalls(1);

        assertEquals("Fifteen-Love", game.getScore());
    }

    @Test
    public void test_S2_ThirtyLove() throws Exception
    {
        serverWinBalls(2);

        assertEquals("Thirty-Love", game.getScore());
    }

    @Test
    public void test_S3_ThirtyLove() throws Exception
    {
        serverWinBalls(3);

        assertEquals("Forty-Love", game.getScore());
    }

    @Test
    public void test_S4_GameToServer() throws Exception
    {
        serverWinBalls(4);

        assertEquals("Game to Naomi", game.getScore());
    }

    @Test
    public void test_R1_LoveFifteen() throws Exception
    {
        receiverWinBalls(1);

        assertEquals("Love-Fifteen", game.getScore());
    }

    @Test
    public void test_R2_LoveThirty() throws Exception
    {
        receiverWinBalls(2);

        assertEquals("Love-Thirty", game.getScore());
    }

    @Test
    public void test_R3_LoveForty() throws Exception
    {
        receiverWinBalls(3);

        assertEquals("Love-Forty", game.getScore());
    }

    @Test
    public void test_R4_GameToReceiver() throws Exception
    {
        receiverWinBalls(4);

        assertEquals("Game to Serena", game.getScore());
    }

    @Test
    public void test_R1S1_LoveFifteen() throws Exception
    {
        receiverWinBalls(1);
        serverWinBalls(1);

        assertEquals("Fifteen-All", game.getScore());
    }

    @Test
    public void test_R3S1_FifteenForty() throws Exception
    {
        receiverWinBalls(3);
        serverWinBalls(1);

        assertEquals("Fifteen-Forty", game.getScore());
    }

    @Test
    public void test_S3R3_Deuce() throws Exception
    {
        serverWinBalls(3);
        receiverWinBalls(3);

        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void test_S1R2S2R1_Deuce() throws Exception
    {
        serverWinBalls(1);
        receiverWinBalls(2);
        serverWinBalls(2);
        receiverWinBalls(1);

        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void test_S3R3S1R1_Deuce() throws Exception
    {
        serverWinBalls(3);
        receiverWinBalls(3);
        serverWinBalls(1);
        receiverWinBalls(1);

        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void test_S3R3S1_AdvantageServer() throws Exception
    {
        serverWinBalls(3);
        receiverWinBalls(3);
        serverWinBalls(1);

        assertEquals("Advantage Naomi", game.getScore());
    }

    @Test
    public void test_S1R2S2R1S1_AdvantageServer() throws Exception
    {
        serverWinBalls(1);
        receiverWinBalls(2);
        serverWinBalls(2);
        receiverWinBalls(1);
        serverWinBalls(1);

        assertEquals("Advantage Naomi", game.getScore());
    }

    @Test
    public void test_S3R4_AdvantageReceiver() throws Exception
    {
        serverWinBalls(3);
        receiverWinBalls(4);

        assertEquals("Advantage Serena", game.getScore());
    }

    @Test
    public void test_S1R2S2R2_AdvantageReceiver() throws Exception
    {
        serverWinBalls(1);
        receiverWinBalls(2);
        serverWinBalls(2);
        receiverWinBalls(2);

        assertEquals("Advantage Serena", game.getScore());
    }

    @Test
    public void test_S1R2S2R1S2_GameToServer() throws Exception
    {
        serverWinBalls(1);
        receiverWinBalls(2);
        serverWinBalls(2);
        receiverWinBalls(1);
        serverWinBalls(2);

        assertEquals("Game to Naomi", game.getScore());
    }

    @Test
    public void test_S3R3S1R3_GameToReceiver() throws Exception
    {
        serverWinBalls(3);
        receiverWinBalls(3);
        serverWinBalls(1);
        receiverWinBalls(3);

        assertEquals("Game to Serena", game.getScore());
    }

    @Test
    public void test_S4R1_GameOver() throws Exception
    {
        serverWinBalls(4);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, this::receiverWinBall);
        assertEquals("Game over", thrown.getMessage());
    }

    @Test
    public void test_S5_GameOver() throws Exception
    {
        serverWinBalls(4);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, this::serverWinBall);
        assertEquals("Game over", thrown.getMessage());
    }

    @Test
    public void test_R4S1_GameOver() throws Exception
    {
        receiverWinBalls(4);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, this::serverWinBall);
        assertEquals("Game over", thrown.getMessage());
    }

    @Test
    public void test_S3R3S1R3S1_GameOver() throws Exception
    {
        serverWinBalls(3);
        receiverWinBalls(3);
        serverWinBalls(1);
        receiverWinBalls(3);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, this::serverWinBall);
        assertEquals("Game over", thrown.getMessage());
    }
}
