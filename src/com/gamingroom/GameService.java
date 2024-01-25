package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * The singleton design pattern makes sure that only one instance 
 * of a class can be instantiated, yet that the data is still accessible 
 * externally.
 * The iterator pattern has several benefits in that it can give 
 * access to an object's data without exposing the container type. 
 * different objects may store data in different container types,
 * ArrayList, list, etc...
 * Iterator maintains the data encapsulation principle by
 * abstracting the data structure type, while still providing
 * access to the data in a secured method 
 * @author casey.doyle@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	/* 
	 * Holds the next Game identifier */
	private static long nextPlayerId = 1;
	/* 
	 * Holds the next Team identifier */
	private static long nextTeamId = 1;
	/* 
	 * Singleton instance 'service' of type GameService */
	private static GameService service;
	/*
	 * Empty Private GameService Constructor - 
	 * Prevents attempts to instantiate more than one 'service'.
	 */
	private GameService() { 
	}
	/**
	 * Public GameService Constructor 
	 * 
	 * @return the service instance
	 */
	public static GameService getInstance() { 
		if (service == null) {
			service = new GameService();
		} 
		return service;
	}
		
	
	/*  
	 * Your client has requested that the game and team names be unique to allow
	 * users to check whether a name is in use when choosing a team name. Referring
	 * back to the Project One Milestone, be sure that you use the iterator pattern
	 * to complete the addGame() and getGame() methods.
	 */	
	
	/**
	 * Add a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance
	 */
	public Game addGame(String name) {

		// instantiate a null local game instance
		Game game = null;
	
		/*
		 * Instantiate Iterator - to look for existing game with same name 
		 * if found, simply return the existing instance. */
		Iterator<Game> myIterator = games.iterator(); 
		while (myIterator.hasNext()) {
			game = (Game) myIterator.next(); // setup game iterator
			if (game.getName() == name) { // if names match
				return null; // return instance of game object
			} else {
				game = null; // reset game object to null if not
			}
		}
		
		if (game == null) { // if not found, make new game instance and add to list
			game = new Game(nextGameId++, name);
			games.add(game);
		}
		return game; // return the game instance to the caller
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		
		/*
		 * Uses iterator to look for existing game with same id if found, simply assign 
		 * that instance to the local variable. */
		Iterator<Game> myIterator = games.iterator(); 
		while (myIterator.hasNext()) { // while games list hasNext
			game = (Game) myIterator.next(); // setup game iterator
			if (game.getId() == id) { // if ids match
				return game; // return game object
			}
		}
		game = null; // reset to null
		return game; // return the game instance to the caller
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		/*
		 * Use iterator to look for existing game with same name if found, simply assign
		 * that instance to the local variable. */
		Iterator<Game> myIterator = games.iterator(); 
		while (myIterator.hasNext()) { // while games list hasNext
			game = (Game) myIterator.next(); // setup game iterator
			if (game.getName() == name) { // if names match
				return game; // return game object
			}
		}
		game = null; // reset to null
		return game; // return the game instance to the caller
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	/**
	 * Increments and Returns the NextPlayerId
	 * 
	 * @return the NextPlayerId
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	/**
	 * Increments and Returns the nextTeamId
	 * 
	 * @return the nextTeamId
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
}
