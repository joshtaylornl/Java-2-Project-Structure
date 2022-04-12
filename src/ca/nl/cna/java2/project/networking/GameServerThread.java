package ca.nl.cna.java2.project.networking;

import ca.nl.cna.java2.project.cardgame.Player;
import org.w3c.dom.ls.LSOutput;

import java.net.Socket;
import java.sql.SQLOutput;

/**
 * The Game Server thread. Handles the Card playing by the player and echos the score to the player.
 *
 */
public class GameServerThread extends Thread {

    GameProtocol gameProtocol;
    Socket playerSocket;
    Player player;

    //TODO Add player object!
    public GameServerThread(GameProtocol gameProtocol, Socket playerSocket, Player player) {
        super(player.getName() + " - game thread");
        this.gameProtocol = gameProtocol;
        this.playerSocket = playerSocket;
        this.player = player;

    }

    @Override
    public void run() {
        super.run();

        // this.player.getHand();
        //TODO Pass ^ this hand to the client

        //TODO Open an ObjectOutput Stream
        //TODO Sent the hand to the client

        //TODO Then whipe the hand
        //TODO then print the hand out on the client side to be sure

        //TODO Execute the server side of the game

        //TODO Add the cards received back to the Player using this:
        //this.player.addCard(card);

        //TODO Then wait on the resolving the round using the method in the GameProtocol
        //TODO make sure the GameProtocol method waits until all players have played
        //TODO then return that string and sent it to the client and repeat

        //Get the Card from the Player in the playerSocket using an ObjectInputStream
        //Pass the Card to the Game Protocol making sure it knows which player played it
        //When the Round is over send the result of the round to the client via a text stream (use a print writer)
        //  The round result is the card played by player and the winner - just like in the RobotOneHundreds example

        //Continue until the game is completed

        //TODO Consider sleeping the thread in the game loop for a second to make the game happen in real time
        //But depending on how you do this you may want to sleep somewhere else



        //TODO Remove this after you understand how it works
        //Get the currently running thread object
        Thread thread = Thread.currentThread();
        //Demonstrate the multi threading - this will print to the GameServer console
        for(int i=0;i<10;i++){
            System.out.println( "Thread - " + thread. getName() + " -  is dormant:"+i);
            try {
                thread.sleep(500);  //Thread dormancy, delayed by one second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
