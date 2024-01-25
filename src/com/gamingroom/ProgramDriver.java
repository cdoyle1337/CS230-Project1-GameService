package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author casey.doyle@snhu.edu
 * 
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		/* Obtain reference to the singleton instance */
		GameService service = GameService.getInstance(); // replace null with ???
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		Game game3 = service.addGame("Game #1");
		System.out.println(game3);
		
		Team team1 = game1.addTeam("Team #1");
		System.out.println(team1);
		Team team2 = game1.addTeam("Team #2");
		System.out.println(team2);
		Team team3 = game1.addTeam("Team #1");
		System.out.println(team3);
		
		Player player1 = team1.addPlayer("Melanie");
		System.out.println(player1);
		Player player2 = team1.addPlayer("Ralph");
		System.out.println(player2);
		Player player3 = team2.addPlayer("Samantha");
		System.out.println(player3);
		Player player4 = team2.addPlayer("Roger");
		System.out.println(player4);
		Player player5 = team2.addPlayer("Roger");
		System.out.println(player5);
		
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
