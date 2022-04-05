package ca.nl.cna.java2.project.networking;

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

    public enum Status{
        NOT_STARTED, PLAY_IN_PROGRESS, GAME_OVER
    }


    //TODO fix this
    //TODO consider adding player objects
    public GameProtocol() {
        this.gameStatus = Status.NOT_STARTED;
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
