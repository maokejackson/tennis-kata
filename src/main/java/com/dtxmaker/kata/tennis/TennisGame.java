package com.dtxmaker.kata.tennis;

import java.util.HashMap;
import java.util.Map;

public class TennisGame
{
    private int serverScore;
    private int receiverScore;

    public void serverScores()
    {
        ensureGameNotOver();
        serverScore++;
    }

    public void receiverScores()
    {
        ensureGameNotOver();
        receiverScore++;
    }

    private void ensureGameNotOver()
    {
        if (isGame()) throw new IllegalStateException("Game over");
    }

    private boolean isTie()
    {
        return serverScore >= 3 && receiverScore >= 3;
    }

    private boolean isDeuce()
    {
        return isTie() && serverScore == receiverScore;
    }

    private boolean isAdvantage()
    {
        return isTie() && Math.abs(serverScore - receiverScore) == 1;
    }

    private boolean isGame()
    {
        if (isTie())
        {
            return Math.abs(serverScore - receiverScore) == 2;
        }
        else
        {
            return serverScore > 3 || receiverScore > 3;
        }
    }

    public String getScore()
    {
        if (isGame() && serverScore > receiverScore) return "Game to Server";
        if (isGame() && receiverScore > serverScore) return "Game to Receiver";
        if (isDeuce()) return "Deuce";
        if (isAdvantage() && serverScore > receiverScore) return "Advantage Server";
        if (isAdvantage() && receiverScore > serverScore) return "Advantage Receiver";
        if (serverScore == receiverScore) return SCORES.get(serverScore) + " All";
        return SCORES.get(serverScore) + " " + SCORES.get(receiverScore);
    }

    private static final Map<Integer, String> SCORES = new HashMap<>();

    static
    {
        SCORES.put(0, "Love");
        SCORES.put(1, "Fifteen");
        SCORES.put(2, "Thirty");
        SCORES.put(3, "Forty");
    }
}
