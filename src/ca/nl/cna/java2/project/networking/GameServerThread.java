package ca.nl.cna.java2.project.networking;

import java.net.Socket;

public class GameServerThread extends Thread {

    GameProtocol gameProtocol;
    Socket playerSocket;

    //TODO Add player information!
    public GameServerThread(GameProtocol gameProtocol, Socket playerSocket, String playerName) {
        super("GameServerThread - " + playerName);
        this.gameProtocol = gameProtocol;
        this.playerSocket = playerSocket;

    }

    @Override
    public void run() {
        super.run();

        //print out the thread name
        System.out.printf("Running: %s", this.getName());

        
    }
}
