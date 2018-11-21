import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JDialog;
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

	private gameEnum gameState; // holds the state of the game
	private static int sunshine; // sunshine to be used as currency to purchase sunflowers, peashooters
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
	public gameEnum plantTurn(int row, int column)
	{
		nTurns++;
		System.out.println(nTurns);
		if(nTurns == 1)
		{
			moveZombies();
			nTurns = 0;
		}
		gameState = gameEnum.PLANT_TIME;
		Scanner scanner = new Scanner(System.in);
		
		Object[] options = {"Peashooter", "Sunflower"};
		int n = JOptionPane.showOptionDialog(null, "Choose your plant type!", "Choice", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		
		if(n == JOptionPane.YES_OPTION)
		{
			plantType = 'p';
		}
		
		if(n == JOptionPane.NO_OPTION)
		{
			plantType = 's';
		}
		
		if(sunshine >= 50) {
			if(plantType == 'p' && sunshine >= 100) {
				sunshine -= 100;
				Peashooter p = new Peashooter(100, row, column, false); 
				peashooters.add(p); //Add a peashooter to the array list
			}

			if(plantType == 's' && sunshine >= 50) {
				if(plantType == 's' && sunshine >= 50) {
					   JDialog.setDefaultLookAndFeelDecorated(true);
					      int response = JOptionPane.showConfirmDialog(null, "Do you want to collect the sun? It gives you 25 sunshines!", "Confirm",
					          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					      if (response == JOptionPane.NO_OPTION) {
					        System.out.println("No button clicked");
					      } else if (response == JOptionPane.YES_OPTION) {
					        System.out.println("Yes button clicked");
					        sunshine += 25;
					      } else if (response == JOptionPane.CLOSED_OPTION) {
					       System.out.println("JOptionPane closed");
					      }
				}
				
				sunshine -= 50;
				
				
				
				Sunflower s = new Sunflower(50, row, column, false);
				sunflowers.add(s); //Add a sunflower to the array list
			}
		}

		
		gamePlayEvent e = new gamePlayEvent (this, row, column, plantType, zombies, sunshine, peashooters);
        for (gamePlayListener tttl: gameListeners) tttl.handleGameEvent(e);
        
        
		return this.gameState;
	}
	
	/**
	 * This method keeps track of the affects on zombie when the game state
	 * is zombie time.
	 * @param numZombies the number of zombies in the game at that moment
	 */
	public void zombieTime(int numZombies) {

		//Random variable for placing zombies at a random grid space
		Random r = new Random();

		if(zombies.size() < numZombies && zombiesEaten == 0) { //We want to make sure zombies are placed at the beginning of the game
			for(int i = 0; i < numZombies; i++) {
				int random = r.nextInt(nRows);
				Zombie z = new Zombie(random, (nRows -1), false);
				zombies.add(z);
			}
		}
		
	}

	/**
	 * Finding if the plant is less than  2 away from the zombie
	 * If plant is less than 2 away, then the zombie will get killed 
	 * @return gameEnum the gameState
	 */
	public gameEnum plantOrZombie() {
		//Keeping track of how many zombies and plants have died for game play

		//Moving the zombie one space when there is nothing ahead of it.
		for(Zombie z : zombies) {
			//If they reach the end, zombies win
			if(z.getPositionY() == 0) { 
				System.out.println("Zombies reached the house. Plants LOSE");
				JOptionPane.showMessageDialog(null,"Zombies reached the house! \n ZOMBIES WON");
				System.exit(-1);
				return gameEnum.ZOMBIES_WIN;
			}
		}

		//If there are no zombies left, peashooters automatically win
		if(zombies.size() == 0 && zombiesEaten > numZombies) {
			System.out.println("Plants defeated the zombies! Plants WIN");
			JOptionPane.showMessageDialog(null,"Plants defeated the zombies! \n YOU WON");
			System.exit(-1);
			return gameEnum.PLANTS_WIN;
		}

		for(Iterator<Peashooter> it = peashooters.iterator(); it.hasNext();) {
			Peashooter p = it.next();

			for(Iterator<Zombie> it2 = zombies.iterator(); it2.hasNext();) {							
				Zombie b = it2.next();

				if((p.getPositionX() == b.getPositionX())) {

					if((b.getPositionY() - p.getPositionY()) < 3) {
						p.setEaten();
						System.out.println(p.getEaten());
						plantsEaten++;

						if(b.getPositionY() == 0) {
							System.out.println("Zombies reached the house. Plants LOSE!");
							JOptionPane.showMessageDialog(null,"Zombies reached the house! \n ZOMBIES WON");
							System.exit(-1);
							return gameEnum.ZOMBIES_WIN;
						}
						//it.remove();
						break; //Break statement so the iterator doesn't remove twice
					}
					else {
						zombiesEaten++;
						b.setEaten();
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
					JOptionPane.showMessageDialog(null,"Zombies Reached The House!");
					System.exit(-1);
					return gameEnum.ZOMBIES_WIN;
				}

				if((p.getPositionX() ==  b.getPositionX() )) {

					if((b.getPositionY() - p.getPositionY()) < 3) {
						//it3.remove();
						plantsEaten++;
						p.setEaten();
					}
				}
			}
		}

		//We need to check the edge cases again since the zombies have moved positions. 
		if(zombies.size() == 0 && zombiesEaten > numZombies) {
			
			System.out.println("Plants defeated the zombies! Plants WIN!");
			JOptionPane.showMessageDialog(null,"Plants defeated the zombies! \n YOU WON");
			System.exit(-1);
			return gameEnum.PLANTS_WIN;
		}

		//If you run out of money to buy new plants
		if (sunshine <= 25) {
			System.out.println("YOU LOST THE GAME! YOU DON'T HAVE ENOUGH SUNSHINE TO GET NEW PLANTS AND THE ZOMBIES ESCAPED!");
			JOptionPane.showMessageDialog(null,"YOU DON'T HAVE ENOUGH SUNSHINE TO GET NEW PLANTS AND THE ZOMBIES ESCAPED! \n ZOMBIES WON");
			System.exit(-1);
			return gameEnum.ZOMBIES_WIN;
		}

		System.out.println(plantsEaten + " Plants have been eaten!");
		System.out.println(zombiesEaten + " Zombies have been destroyed!");

		//No winner, keep playing and zombies move up
		return gameEnum.PLANT_TIME;

	}
	
	public void moveZombies()
	{
		for(Zombie p: zombies)
		{
			p.move();
			System.out.println("Zombie @: " + p.getPositionY());
		}
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


	
}
