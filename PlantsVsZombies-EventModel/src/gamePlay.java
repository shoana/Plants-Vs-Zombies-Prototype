import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * The gamePlay is where all the methods used for 'playing' the game are included.
 * The main function in this class allows this game to be user interactive. Plants are killed 
 * by the Zombies if they are not strategically placed on the grid by the user and visa-versa.
 *
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version October 27th, 2018 
 *
 */

public class gamePlay {

	private int nRows, nColumns; //GRID DIMENSIONS
	private char grid[][]; //EMPTY, PLANT, SUNFLOWER OR ZOMBIE
	private gameEnum gameState; // holds the state of the game
	private static int sunshine; // sunshine to be used as currency to purchase sunflowers, peashooters
	private static final int plantToZombieLength = 3; //Plant must be >= 3 steps away from zombie or else it will eat it.
	private static final int startSunshine = 300; //starting money 
	private static char plantType; //Type of plant. Used for user input
	private static int nTurns = 0; //Tracks # of turns
	
	//ARRAY LISTS for Plants & Zombies
	private static ArrayList<Peashooter> peashooters = new ArrayList<Peashooter>(); 
	private static ArrayList<Sunflower> sunflowers = new ArrayList<Sunflower>();
	private static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	private ArrayList<gamePlayListener> gameListeners;

	
	//Keeps track of plants eaten, zombies eaten, and the number of zombies on the grid
	private int plantsEaten = 0; 
	private static int zombiesEaten = 0;
	private static int numZombies = 0;


	/**
	 * Constructor for the game play
	 * @param nRows is an int that sets the row on the gird
	 * @param nColumns is an int that sets the column on the grid
	 * @param sunshine is an int that shows the sunshine left in the game
	 */
	public gamePlay(int nRows, int nColumns, int sunshine)
	{
		if (nRows < 0 || nColumns < 0) 
			throw new IllegalArgumentException("Grid must be a positive size"); //Exception checker
		
		//ADD GAME LISTENER
		gameListeners = new ArrayList<gamePlayListener>();
		
		//Instantiating required values
		this.nRows = nRows;
		this.nColumns = nColumns;
		gamePlay.sunshine = sunshine;
		plantType = 'p';
		this.gameState = gameEnum.PLANT_TIME;
		this.grid = new char[nRows][nColumns];

		//Setting up the grid to contain spaces.
		for(int i = 0; i < nRows; i++)
		{
			for(int j = 0; j < nColumns; j++)
			{
				grid[i][j] = ' ';
			}
		}
	}

	/**
	 * Resets the game back to original parameters.
	 */
	public void reset()
	{
		for (int r=0;r<nRows; r++) {
			for (int c=0; c<nColumns; c++) {
				this.grid[r][c] = ' '; //Reset back to original (spaces, no grid is occupied)
			}
		}
		sunshine = 0;
		this.gameState = gameEnum.PLANT_TIME;
	}
	
	public void addGamePlayListener(gamePlayListener tttl) {
        gameListeners.add(tttl);
    }
	
	
	/**
	 * Code for the plant's turn 
	 * @param row is an int sets the row on the gird when the plant is placed
	 * @param column is an int sets the column on the grid where the plant is placed
	 * @param plantType is an int could be a sunflower or a peashooter
	 * @return gameEnum the gameState
	 */
	public gameEnum plantTurn(int row, int column, char plantType)
	{
		gameState = gameEnum.PLANT_TIME;
		Scanner scanner = new Scanner(System.in);

		if(sunshine >= 50) {
			if(plantType == 'p' && sunshine >= 100) {
				sunshine -= 100;
				this.grid[row][column] = plantType; //Place a plant at this grid space
				nTurns++; //increase turns
				System.out.println(toString()); // show the user the current state of the game
				Peashooter p = new Peashooter(100, row, column); 
				peashooters.add(p); //Add a peashooter to the array list
			}

			if(plantType == 's' && sunshine >= 50) {
				System.out.println("Do you want to collect the sun? It gives you 25 sunshines! (y/n) ");
				char sun = scanner.next().charAt(0);
				if(sun == 'y'){
					sunshine += 25; //Add more sunshine
				}
				sunshine -= 50;
				this.grid[row][column] = plantType; //Place a plant at this grid space
				nTurns++;
				System.out.println(toString()); //Show the user the current state of the game
				Sunflower s = new Sunflower(50, row, column);
				sunflowers.add(s); //Add a sunflower to the array list
			}
		}

		else {
			System.out.println("You don't have enough sunshine");
		}

		
        
        
		gameState = plantOrZombie(); //Find if the zombies win, or plants win, or if the game can continue
		
		gamePlayEvent e = new gamePlayEvent (this, row, column, plantType, zombies, sunshine);
        for (gamePlayListener tttl: gameListeners) tttl.handleGameEvent(e);
        
		return this.gameState;
	}
	/**
	 * This method keeps track of the affects on zombie when the game state
	 * is zombie time.
	 * @param numZombies the number of zombies in the game at that moment
	 */
	public void zombieTime(int numZombies) {

		System.out.println(" ");
		System.out.println("========================");
		System.out.println("ZOMBIES ARE ATTACKING!");
		System.out.println("Peashooters are shooting!");
		System.out.println("========================");
		System.out.println(" ");
		
		//Random variable for placing zombies at a random grid space
		Random r = new Random();

		if(zombies.size() < numZombies && zombiesEaten == 0) { //We want to make sure zombies are placed at the beginning of the game
			for(int i = 0; i < numZombies; i++) {
				int random = r.nextInt(nRows);
				grid[random][(nRows - 1)] = 'z'; //Place zombie @ random grid space
				Zombie z = new Zombie(random, (nRows -1));
				zombies.add(z);
			}
		}
		System.out.println(toString()); //Update the user
		gameState = plantOrZombie();
		
		//zombieEvent e = new zombieEvent (this, zombies);
       // for (ZombieListener zl: zombieListeners) zl.handleZombieEvent(e);
        
		//gamePlayEvent e = new gamePlayEvent (this, gameState, peashooters, sunflowers, zombies);
        //for (gamePlayListener tttl: gameListeners) tttl.handleGameEvent(e);
	}

	/**
	 * Finding if the plant is less than  2 away from the zombie
	 * If plant is less than 2 away, then the zombie will get killed 
	 * @return gameEnum the gameState
	 */
	public gameEnum plantOrZombie() {
		//Keeping track of how many zombies and plants have died for game play

		//EDGE CASES:
		//If there are no peashooters left and zombies are still left, zombies win
		if((peashooters.size() == 0 && sunflowers.size() == 0 && zombies.size() > 0)) {
			System.out.println("Zombies ate all your plants! Plants LOSE");
			JOptionPane.showMessageDialog(null,"ZOMBIES WON");
			System.exit(-1);
			return gameEnum.ZOMBIES_WIN;
		}

		//Moving the zombie one space when there is nothing ahead of it.
		for(Zombie z : zombies) {
			if(grid[z.getPositionX()][(z.getPositionY() - 1)] == ' ' && z.getPositionY() != 0) {
				grid[z.getPositionX()][z.getPositionY()] = ' ';
				z.setPositionY(z.getPositionY() - 1);
				grid[z.getPositionX()][z.getPositionY()] = 'z';
			}
			//If they reach the end, zombies win
			if(z.getPositionY() == 0) { 
				System.out.println("Zombies reached the house. Plants LOSE");
				JOptionPane.showMessageDialog(null,"ZOMBIES WON");
				System.exit(-1);
				return gameEnum.ZOMBIES_WIN;
			}
		}

		//If there are no zombies left, peashooters automatically win
		if(zombies.size() == 0 && zombiesEaten > numZombies) {
			System.out.println(toString());
			System.out.println("456 Plants defeated the zombies! Plants WIN");
			JOptionPane.showMessageDialog(null,"PLANTS WON");
			System.exit(-1);
			return gameEnum.PLANTS_WIN;
		}

		for(Iterator<Peashooter> it = peashooters.iterator(); it.hasNext();) {
			Peashooter p = it.next();

			for(Iterator<Zombie> it2 = zombies.iterator(); it2.hasNext();) {							
				Zombie b = it2.next();

				if((p.getPositionX() == b.getPositionX())) {

					if((b.getPositionY() - p.getPositionY()) < 3) {

						grid[p.getPositionX()][p.getPositionY()] = ' ';
						grid[b.getPositionX()][b.getPositionY()] = ' ';
						b.setPositionY(b.getPositionY() - 1);
						grid[b.getPositionX()][b.getPositionY()] = 'z';
						plantsEaten++;

						if(b.getPositionY() == 0) {
							System.out.println("Zombies reached the house. Plants LOSE!");
							System.out.println(toString());
							JOptionPane.showMessageDialog(null,"ZOMBIES WON");
							System.exit(-1);
							return gameEnum.ZOMBIES_WIN;
						}
						it.remove();
						break; //Break statement so the iterator doesn't remove twice
					}
					else {
						grid[b.getPositionX()][b.getPositionY()] = ' ';
						zombiesEaten++;
						it2.remove(); //Changed here 
						break; //Break statement so iterator doesn't remove twice
					}
				}
			}
		}

		Iterator<Sunflower> it3 = sunflowers.iterator(); //Sunflower arraylist
		Iterator<Zombie> it4 = zombies.iterator(); //Zombie arraylist 

		while(it3.hasNext()) {
			Sunflower p = it3.next();

			while(it4.hasNext()) {
				Zombie b = it4.next();
				if(b.getPositionY() == 0) {
					JOptionPane.showMessageDialog(null,"ZOMBIES WON");
					System.exit(-1);
					return gameEnum.ZOMBIES_WIN;
				}

				if((p.getPositionX() ==  b.getPositionX() )) {

					if((b.getPositionY() - p.getPositionY()) < 3) {
						it3.remove();
						grid[p.getPositionX()][p.getPositionY()] = ' ';
						b.setPositionY(p.getPositionY());
						grid[b.getPositionX()][b.getPositionY()] = 'z';
						plantsEaten++;
					}
				}
			}
		}

		//We need to check the edge cases again since the zombies have moved positions. 
		if(zombies.size() == 0 && zombiesEaten > numZombies) {
			System.out.println(toString());
			System.out.println("Plants defeated the zombies! Plants WIN!");
			JOptionPane.showMessageDialog(null,"PLANTS WON");
			System.exit(-1);
			return gameEnum.PLANTS_WIN;
		}

		//EDGE CASES:
		//If there are no peashooters left and zombies are still left, zombies win
		if((peashooters.size() == 0 && sunflowers.size() == 0 && zombies.size() > 0)) {
			System.out.println("Zombies ate all your plants! Plants LOSE");
			JOptionPane.showMessageDialog(null, "PLANTS WON");
			System.exit(-1);
			return gameEnum.ZOMBIES_WIN;
		}

		//If you run out of money to buy new plants
		if (sunshine <= 25) {
			System.out.println("YOU LOST THE GAME! YOU DON'T HAVE ENOUGH SUNSHINE TO GET NEW PLANTS AND THE ZOMBIES ESCAPED!");
			JOptionPane.showMessageDialog(null,"Zombies Win");
			System.exit(-1);
			return gameEnum.ZOMBIES_WIN;
		}

		System.out.println(plantsEaten + " Plants have been eaten!");
		System.out.println(zombiesEaten + " Zombies have been destroyed!");

		//No winner, keep playing and zombies move up
		return gameEnum.PLANT_TIME;

	}

	/**
	 * A getter to get the type of plant that is being placed into the grid
	 * @return char containing a peashooter or a sunflower
	 */
	public static char getPlantType() {
		return plantType;
	}

	/**
	 * a setter for the plant type
	 * @param char s
	 */
	public void setPlantType(char s)
	{
		this.plantType = s;
	}

	/**
	 * it changes the plant type from a char to a string 
	 * @param s is char that sets the type of plant
	 * @return String s or p depending on the plant type
	 */
	public String charToPlantType(char s)
	{
		String plant = "";
		if(s == 's')
		{
			plant += "Sunflower";
		}

		if(s == 'p')
		{
			plant += "Peashooter";
		}

		return plant;
	}

	/**
	 * A getter to get the state of the game
	 * @return gameEnum the game state
	 */
	public gameEnum getGameState() {
		return this.gameState;
	}

	/**
	 * a setter to set the state of the game
	 * @param g is a gameEnum which refers to the state of the game
	 */
	public void setGameState(gameEnum g) {
		this.gameState = g;
	}

	/**
	 * ToString method for textual representation of the game board
	 * @return String of the gird and the contents contained in the grid
	 */
	public String toString() {
		String s = ("===========================\n");
		for (int r=0;r < nRows; r++ ) {
			for (int c=0; c < nColumns; c++) {

				s += grid[r][c] + " | ";
			}
			s += "\n";
		}
		s += ("\n===========================");
		return s;

	}


	public static void main(String args[]) {
		//CLIENT CODE. Main Game Loop
		Scanner scanner = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("===================================================");
		System.out.println("               PLANTS VS. ZOMBIES                  ");
		System.out.println("You will be attacking Normal Zombies in this level.");
		System.out.println("===================================================");
		System.out.println("How many zombies would you like to attack?");

		numZombies = scanner.nextInt();
		System.out.println(" ");
		System.out.println("===================================================");
		System.out.println("               PLANTS VS. ZOMBIES                  ");
		System.out.println("Begin by placing a plant. Type 'p' for peashooter  ");
		System.out.println("           and Type 's' for Sunflower              ");
		System.out.println("===================================================");
		System.out.println(" ");

		gamePlay game = new gamePlay(6,6,startSunshine);
		do { 

			System.out.println("Sunshine: " + sunshine + "\nPEASHOOTER PRICE: 100\nSUNFLOWER PRICE: 50" );
			System.out.println("Choose your plant type. You have " + sunshine + " Sunshines");
			char plantType = scanner.next().charAt(0);
			if((plantType == 's' && sunshine >= 50) || (plantType == 'p' && sunshine >= 100))
			{
				game.setPlantType(plantType);

				System.out.println("Where do you want to put your " + game.charToPlantType(plantType) +"? Enter row column");
				int row = scanner.nextInt();
				int column = scanner.nextInt();
				scanner.nextLine();

				if(row < 6 && row >= 0 && column < 6 && column >= 0) {
					game.plantTurn(row, column, plantType);
					if(nTurns - 2 == 0) {
						game.zombieTime(numZombies);
						nTurns = 0;
					}
				} else {
					System.out.println("Invalid input. please choose another location");
				}
			}

			else {
				if ((plantType == 's' && sunshine < 50) || (plantType == 'p' && sunshine < 100)) {
					System.out.println("You don't have enough sunshine to buy the plant you want!");
				} else {
					System.out.println("Invalid input: Please choose 'p' or 's'");
				}
			}
		} while (game.getGameState() == gameEnum.PLANT_TIME);

		System.out.println( game.getGameState());
	}
}
