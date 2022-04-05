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

            //TODO replace all this
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;

                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
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


