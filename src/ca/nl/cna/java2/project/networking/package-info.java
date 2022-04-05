package ca.nl.cna.java2.project.networking;

/**
 * The networking component of the project. This package will provide a game server that enables multiple clients
 * to connect to play the card game noted in the card game package (100s)
 *
 * Proposed classes:
 *      GameServer - Handles the all the client connections (similar to KKMultiServer from class notes)
*           This server will spin off the multi threads
 *      GameClient - Handles the client connection to the server
 *      GameServerThread - Handles each client connection
 *      GameProtocol - synchronizes the game between all the clients
 *
 * @author Josh
 */