package com.dtxmaker.kata.tennis2;

import com.dtxmaker.kata.TennisGame;

public class TennisGame2 implements TennisGame
{
    private Player server;
    private Player receiver;

    private final GameState INITIAL   = new Initial(this);
    private final GameState DEUCE     = new Deuce(this);
    private final GameState ADVANTAGE = new Advantage(this);
    private final GameState GAME_OVER = new GameOver(this);

    private GameState state = INITIAL;

    public TennisGame2(String serverName, String receiverName)
    {
        server = new Player(serverName);
        receiver = new Player(receiverName);
    }

    public int getServerScore()
    {
        return server.score;
    }

    public int getReceiverScore()
    {
        return receiver.score;
    }

    @Override
    public void serverScores()
    {
        ensureGameNotOver();
        server.score++;
        nextState();
    }

    @Override
    public void receiverScores()
    {
        ensureGameNotOver();
        receiver.score++;
        nextState();
    }

    private void ensureGameNotOver()
    {
        if (isGameOver()) throw new IllegalStateException("Game over");
    }

    private void nextState()
    {
        if (isGameOver()) state = GAME_OVER;
        else if (isAdvantage()) state = ADVANTAGE;
        else if (isDeuce()) state = DEUCE;
    }

    boolean isTie()
    {
        return server.score == receiver.score;
    }

    boolean isDeuce()
    {
        return isTie() && server.score >= 3;
    }

    boolean isAdvantage()
    {
        return server.score >= 3 && receiver.score >= 3 && Math.abs(server.score - receiver.score) == 1;
    }

    boolean isGameOver()
    {
        return (server.score >= 4 || receiver.score >= 4) && Math.abs(server.score - receiver.score) >= 2;
    }

    private Player getLeadingPlayer()
    {
        return server.score >= receiver.score ? server : receiver;
    }

    String getLeadingPlayerName()
    {
        return getLeadingPlayer().name;
    }

    @Override
    public String getScore()
    {
        return state.getScore();
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
