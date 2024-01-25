package com.gamingroom;

/**
 * A class to hold entity information for Game, Team, and Entity class objects
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once an entity is
 * created.
 * </p>
 * @author casey.doyle@snhu.edu
 *
 */

public class Entity {
	private long id;
	private String name;

	/*
	 * Empty Private Entity Constructor - 
	 * Prevents attempts to instantiate more than one 'Entity'.
	 */
	private Entity() { 
	}
	/*
	 * Constructor with an identifier and name
	 */
	public Entity(long id, String name) {
		this(); // establish local instance
		this.id = id; // assign object id with parameterized id
		this.name = name;// assign object name with parameterized name
	}
	/**
	 * @return the entity's id long
	 */
	public long getId() {
		return this.id; // return entity id
	}
	/**
	 * @return the entity's name string
	 */
	public String getName() {
		return this.name; // return entity name
	}
	/**
	 * @return the id and name in string format
	 */
	public String toString() {
		return "Entity [id=" + this.getId() + ", name=" + this.getName() + "]"; // return id name as string
	}
	
}
