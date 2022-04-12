package ca.nl.cna.java2.project.testclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Simple Server to receive cards and send cards to a single client
 *
 */
public class SimpleServerCardTest {

    public static void main(String[] args) throws IOException {

        System.out.println("Fun with Sockets");

        String hostName = "localhost";
        int portNumber = 8800;

        try (
                //Connect to the server
                Socket echoSocket = new Socket(hostName, portNumber);

                //Create a PrintWrite to write to the Server
                PrintWriter outputToServer = new PrintWriter(echoSocket.getOutputStream(), true);

                //Create a BufferedReader to read from the Server
                BufferedReader inputFromServer = new BufferedReader(
                        new InputStreamReader(echoSocket.getInputStream()));

                //Create a BufferedReader for the keyboard on the Client side
                BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            //As long as the user on the client is typing, sent it to the Server PrintWriter
            while ((userInput = keyboardInput.readLine()) != null) {
                outputToServer.println(userInput);
                System.out.println("echo: " + inputFromServer.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }

}
