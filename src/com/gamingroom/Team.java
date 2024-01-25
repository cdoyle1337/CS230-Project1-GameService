package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author casey.doyle@snhu.edu
 *
 */
public class Team extends Entity {
	
	/**
	 * A list of the active players
	 */
	private static List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name); // reference inherited superclass constructor
	}

	/**
	 * Construct a new player instance
	 * 
	 * @param name the unique name of the desired player
	 * @return the player instance 
	 * 
	 * Every team and player must have a unique name by searching for the supplied name 
	 * prior to adding the new instance. Use the iterator pattern
	 */
	public Player addPlayer(String name) {

		// instantiate a local Player instance
		Player player = null;
	
		/*
		 * Instantiate Iterator - to look for existing player with same name 
		 * if found, simply return the existing instance.*/
		Iterator<Player> myIterator = players.iterator(); 
		while (myIterator.hasNext()) { // while players exist in the list
			player = (Player) myIterator.next(); // set temp player iterator object
			if (player.getName() == name) { // if player names match
				return null; // return player object
			} else {
				player = null; // reset player to null
			}
		} // if not found, make a new player instance and add to list of players
		player = null; // reset player to null
		if (player == null) {
			player = new Player(com.gamingroom.GameService.getInstance().getNextPlayerId(), name);
			players.add(player);
		}
		return player; // return the player object to caller
	}
	
	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + "]";
	}
}
