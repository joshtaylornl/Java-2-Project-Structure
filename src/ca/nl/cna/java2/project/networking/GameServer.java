package ca.nl.cna.java2.project.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Game server which will handle the client connections and create threads to handle the game
 *
 * Built to handle a dynamic number of players before starting the game. ( The number of players will be dynamic
 * but we will make it static for simplicity - i.e. we will force 3 players for example.)
 */
public class GameServer {

    //TODO test this with 3 players
    public static final int NUMBER_PLAYERS = 2;

    /**
     * Main server loop
     * @param args
     */
    public static void main(String[] args) {

        int portNumber = 4401; //Integer.parseInt(args[0]);
        boolean listening = true;

        //Track the connections
        LinkedList<Socket> clientSocketList = new LinkedList<>();

        //Wait until we have all the connections we need
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening & clientSocketList.size() < NUMBER_PLAYERS) {
                clientSocketList.add(serverSocket.accept());
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }

        //Debug - be sure you got the connections you wanted
        System.out.printf("Connections: %d", clientSocketList.size());

        //Start the game
        //TODO you need to give it the players information
        //TODO consider creating the players based on the connections above and adding them to the game protocol
        GameProtocol gameProtocol = new GameProtocol();

        //Create the threads
        for (int i = 0; i < clientSocketList.size(); i++) {
            new GameServerThread(gameProtocol, clientSocketList.get(i), "Player " + String.valueOf(i+1)).run();
        }

        //TODO do a while on the game loop

        //TODO print the results
    }


}
