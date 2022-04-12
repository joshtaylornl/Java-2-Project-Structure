package ca.nl.cna.java2.project.networking;

import ca.nl.cna.java2.project.cardgame.CardDeck;
import ca.nl.cna.java2.project.cardgame.Player;

import java.util.LinkedList;

/**
 * This is the object that manages the game between all the threads.
 *
 * It's VERY important that this is synchronized. (See class examples for concurrency)
 *
 * Every game has a beginning, middle and end. Beginning is before it starts. Middle is while play is ongoing. End is
 * when the game is over and there are no more cards to play.
 *
 * TODO Add the game loop. Make sure that you are saving everything for debugging.
 *
 */
public class GameProtocol {

    private Status gameStatus;
    private CardDeck cardDeck;
    private LinkedList<Player> playerList;

    //TODO Make a method that's just like RobotOneHundreds roundWinner
    //It will use the players in this player list
    //TODO be careful that the player has a card at the round - you are playing on the EDGE of the list

    public enum Status{
        NOT_STARTED, PLAY_IN_PROGRESS, GAME_OVER
    }


    public GameProtocol(CardDeck cardDeck, LinkedList<Player> playerList) {
        this.cardDeck = cardDeck;
        this.playerList = playerList;
        this.gameStatus = Status.NOT_STARTED;
        this.cardDeck.deal(this.playerList);
    }

    /**
     * Get the Game Status
     * @return
     */
    public Status getGameStatus() {
        return gameStatus;
    }

    /**
     * Determines if the game is over
     * @return
     */
    public boolean isGameOver(){
        return this.gameStatus == Status.GAME_OVER;
    }

}
