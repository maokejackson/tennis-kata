package com.dtxmaker.kata.tennis;

import com.dtxmaker.kata.TennisGame;

import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame
{
    private Player server;
    private Player receiver;

    public TennisGame1(String serverName, String receiverName)
    {
        server = new Player(serverName);
        receiver = new Player(receiverName);
    }

    @Override
    public void winBall(String playerName)
    {
        ensureGameNotOver();
        if (server.name.equals(playerName)) server.score++;
        else if (receiver.name.equals(playerName)) receiver.score++;
        else throw new IllegalArgumentException("Player does not exist");
    }

    private void ensureGameNotOver()
    {
        if (isGame()) throw new IllegalStateException("Game over");
    }

    private boolean isTie()
    {
        return server.score == receiver.score;
    }

    private boolean isDeuce()
    {
        return isTie() && server.score >= 3;
    }

    private boolean isAdvantage()
    {
        return server.score >= 3 && receiver.score >= 3 && Math.abs(server.score - receiver.score) == 1;
    }

    private boolean isGame()
    {
        return (server.score >= 4 || receiver.score >= 4) && Math.abs(server.score - receiver.score) >= 2;
    }

    private Player getLeadingPlayer()
    {
        return server.score >= receiver.score ? server : receiver;
    }

    private String getLeadingPlayerName()
    {
        return getLeadingPlayer().name;
    }

    @Override
    public String getScore()
    {
        if (isGame()) return "Game to " + getLeadingPlayerName();
        if (isAdvantage()) return "Advantage " + getLeadingPlayerName();
        if (isDeuce()) return "Deuce";
        if (isTie()) return SCORES.get(server.score) + "-All";
        return SCORES.get(server.score) + "-" + SCORES.get(receiver.score);
    }

    private static final Map<Integer, String> SCORES = new HashMap<>();

    static
    {
        SCORES.put(0, "Love");
        SCORES.put(1, "Fifteen");
        SCORES.put(2, "Thirty");
        SCORES.put(3, "Forty");
    }

    private class Player
    {
        private final String name;
        private       int    score;

        private Player(String name)
        {
            this.name = name;
        }
    }
}
