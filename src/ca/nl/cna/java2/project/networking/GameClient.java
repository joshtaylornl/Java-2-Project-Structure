package ca.nl.cna.java2.project.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client which will connect to the server. After the connection is made, the client will receive the hand of cards
 * and then proceed to play the cards as the game goes on until finished.
 *
 */
public class GameClient {

    /**
     * Main client method
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        //Game Server location
        String hostName = "localhost";
        int portNumber = 4401;

        //Connect to the game server
        try (
                Socket gameSocket = new Socket(hostName, portNumber);
                //TODO these need to be modified for objects
                PrintWriter out = new PrintWriter(gameSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(gameSocket.getInputStream()));
        ) {

            //TODO communicate with server

            //Get the hand from the Server using an ObjectInputStream. Store it locally - why not use a Player Object
            //Wait on some game loop and play your cards as needed
            //Playing a card is sending a card from the Player object to the server via an ObjectOutputStream
            //End when all the cards are played (to be determined by the game protocol)

            //TODO remove this sleep
            try {
                thread.sleep(10000);    //10 seconds
                //Thread dormancy, delayed by one second
            } catch (InterruptedException e) {
                System.out.println("Test Thread error");
            }

            //game is over
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }

    }

}


