package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author casey.doyle@snhu.edu
 *
 */
public class Game extends Entity {

	/**
	 * A list of the active teams
	 */
	private static List<Team> teams = new ArrayList<Team>();
	
	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name); // reference inherited superclass constructor
	}

	/**
	 * Construct a new team instance
	 * 
	 * @param name the unique name of the desired team
	 * @return the team instance 
	 * 
	 * Every player and team must have a unique name by searching for the supplied name 
	 * prior to adding the new instance. Use the iterator pattern
	 */
	public Team addTeam(String name) {

		// instantiate a local Team instance
		Team team = null;
	
		/*
		 * Instantiate Iterator - to look for existing team with same name 
		 * if found, simply return null. */
		Iterator<Team> myIterator = teams.iterator(); 
		while (myIterator.hasNext()) { // while teams exist in the list
			team = (Team) myIterator.next(); // set temp team iteration object
			if (team.getName() == name) { // if names match
				return null; // return team object to caller
			} else {
				team = null; // reset team to null
			}
		}
		
		if (team == null) { // if not found, make new team instance and add to list
			team = new Team(com.gamingroom.GameService.getInstance().
					getNextTeamId(), name);
			teams.add(team);
		}
		return team; // return team object to caller
	}
	
	@Override
	public String toString() {
		
		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}
}
