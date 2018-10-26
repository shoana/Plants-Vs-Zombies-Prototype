import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class gamePlay {
	
	private int nRows, nColumns; //GRID DIMENSIONS
	private char grid[][]; //EMPTY, PLANT, SUNFLOWER OR ZOMBIE
	private gameEnum gameState;
	private static int sunshine; // sunshine to be used as currency to purchase sunflowers, peashooters
	private static final int plantToZombieLength = 3; //Plant must be >= 3 steps away from zombie or else it will eat it.
	private static char plantType;
	private static int nTurns = 0;
	private static ArrayList<Peashooter> peashooters = new ArrayList<Peashooter>();
	private static ArrayList<Sunflower> sunflowers = new ArrayList<Sunflower>();
	private static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	private int plantsEaten = 0; 
	private static int zombiesEaten = 0;
	private static int numZombies;
	
	
	/**
	 * Constructor for the game play
	 * @param nRows
	 * @param nColumns
	 * @param sunshine
	 */
	public gamePlay(int nRows, int nColumns, int sunshine)
	{
		if (nRows < 0 || nColumns < 0) 
            throw new IllegalArgumentException("Grid must be a positive size");
		
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
	 * Reset the game back to original parameters.
	 */
	public void reset()
	{
		for (int r=0;r<nRows; r++) {
            for (int c=0; c<nColumns; c++) {
                this.grid[r][c] = ' ';
            }
        }
		
		gamePlay.sunshine = 0;
		this.gameState = gameEnum.PLANT_TIME;
	}
	
	/**
	 * Code for the plant's turn 
	 * @param row
	 * @param column
	 * @param plantType
	 * @return
	 */
	public gameEnum plantTurn(int row, int column, char plantType)
	{
		gameState = gameEnum.PLANT_TIME;
		Scanner scanner = new Scanner(System.in);
			
			if(sunshine >= 100) {
				this.grid[row][column] = plantType;
				nTurns++;
				System.out.println(toString());
				
				if(plantType == 'p')
				{
					sunshine -= 100;
					Peashooter p = new Peashooter(100, row, column);
					peashooters.add(p);
					
					
				}
				if(plantType == 's')
				{
					System.out.println(" Do you want to collect the sun? (y/n) ");
					char sun = scanner.next().charAt(0);
					if(sun == 'y'){
						sunshine += 100;
					}
					sunshine -= 50;
					Sunflower s = new Sunflower(200, row, column);
					sunflowers.add(s);
				}
				
				
			}
			else {
				System.out.println("You don't have enough sunshine");
			}
			
		gameState = plantOrZombie();
		return this.gameState;
	}
	
	public void zombieTime(int numZombies)
	{
		
		System.out.println(" ");
		System.out.println("=======================");
		System.out.println("ZOMBIES ARE ATTACKING!");
		System.out.println("Peashooters are shooting!");
		System.out.println("=======================");
		System.out.println(" ");
		Random r = new Random();
		
		if(zombiesEaten == 0) { //Need to fix this: Stop generating zombies
			for(int i = 0; i <= numZombies; i++)
			{
				System.out.println(zombies.size());
				int random = r.nextInt(nRows);
				grid[random][(nRows - 1)] = 'z';
				Zombie z = new Zombie(random, (nRows -1)); //Add a new zombie to the list
				zombies.add(z);
			}
		}
		
			
		System.out.println(toString());
		gameState = plantOrZombie();
		
	}
	
	/**
	 * Finding if the plant is < 2 away from the zombie
	 * If plant is < 2 away, then the zombie will get killed
	 * @param row
	 * @param column
	 * @return
	 */
	public gameEnum plantOrZombie()
	{
		
		//Keeping track of how many zombies and plants have died for game play
		
		
		//EDGE CASES:
		//If there are no peashooters left and zombies are still left, zombies win
		if((peashooters.size() == 0 && sunflowers.size() == 0 && zombies.size() > 0))
		{
			System.out.println("Zombies ate all your plants! Plants LOSE");
			return gameEnum.ZOMBIES_WIN;
		}
		
		//Moving the zombie one space when there is nothing ahead of it.
		for(Zombie z : zombies)
		{
			if(grid[z.getPositionX()][(z.getPositionY() - 1)] == ' ')
			{
				grid[z.getPositionX()][z.getPositionY()] = ' ';
				z.setPositionY(z.getPositionY() - 1);
				grid[z.getPositionX()][z.getPositionY()] = 'z';
			}
			if(z.getPositionY() == 0) //If they reach the end, zombies win
			{
				System.out.println("Zombies reached the house. Plants LOSE");
				return gameEnum.ZOMBIES_WIN;
			}
		}
		
		//If there are no zombies left, peashooters automatically win
		if(zombiesEaten > numZombies)
		{
			//System.out.println("sadjasd");
			System.out.println(toString());
			System.out.println("Plants defeated the zombies! Plants WIN");
			return gameEnum.PLANTS_WIN;
		}
		
				for(Iterator<Peashooter> it = peashooters.iterator(); it.hasNext();)
				{
					Peashooter p = it.next();
					
					
					for(Iterator<Zombie> it2 = zombies.iterator(); it2.hasNext();)
					{							
							Zombie b = it2.next();
							if((p.getPositionX() == b.getPositionX()))
							{
								if(((b.getPositionY() - p.getPositionY())) < 3)
								{
									grid[p.getPositionX()][p.getPositionY()] = ' ';
									grid[b.getPositionX()][b.getPositionY()] = ' ';
									b.setPositionY(b.getPositionY() - 1);
									grid[b.getPositionX()][b.getPositionY()] = 'z';
									plantsEaten++;
									if(b.getPositionY() == 0)
									{
										System.out.println("Zombies reached the house. Plants LOSE!");
										System.out.println(toString());
										return gameEnum.ZOMBIES_WIN;
									}
									it.remove();
									break; //Break statement so the iterator doesn't remove twice
								}
								else
								{
									
									grid[b.getPositionX()][b.getPositionY()] = ' ';
									zombiesEaten++;
									it2.remove(); //Changed here 
									break; //Break statement so iterator doesn't remove twice
								}
						
						
							}
				}
			}
				
				Iterator<Sunflower> it3 = sunflowers.iterator();
				Iterator<Zombie> it4 = zombies.iterator();
						
				while(it3.hasNext()) {
					Sunflower p = it3.next();
				
					while(it4.hasNext())
					{
						
						Zombie b = it4.next();
						
						if(b.getPositionY() == 0)
						{
							return gameEnum.ZOMBIES_WIN;
						}
						
						if((p.getPositionX() ==  b.getPositionX() ))
						{
							if(((b.getPositionY() - p.getPositionY())) < 3)
							{
								it3.remove();
								grid[p.getPositionX()][p.getPositionY()] = ' ';
								b.setPositionY(p.getPositionY());
								grid[b.getPositionX()][b.getPositionY()] = 'z';
								plantsEaten++;
							}
						}
					}
				}
				
				
		if(zombiesEaten > numZombies)
		{
			
			System.out.println(toString());
			System.out.println("Plants defeated the zombies! Plants WIN!");
			return gameEnum.PLANTS_WIN;
		}
		
		//EDGE CASES:
		//If there are no peashooters left and zombies are still left, zombies win
		if((peashooters.size() == 0 && sunflowers.size() == 0 && zombies.size() > 0))
		{
			System.out.println("Zombies ate all your plants! Plants LOSE");
			return gameEnum.ZOMBIES_WIN;
		}
					
					
		System.out.println(plantsEaten + " Plants have been eaten!");
		System.out.println(zombiesEaten + " Zombies have been destroyed!");
		
		
		
		//No winner, keep playing and zombies move up
		return gameEnum.PLANT_TIME;
		
	}
	
	 public static char getPlantType() {
	   return plantType;
	 }
	 
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
	 
	 public void setPlantType(char s)
	 {
		 this.plantType = s;
	 }
	 
	 public gameEnum getGameState() {
	    return this.gameState;
	 }
	 
	 public void setGameState(gameEnum g) {
		 this.gameState = g;
	 }
	 
	 /**
	  * ToString method for textual representation of the game board
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
			
			gamePlay game = new gamePlay(6,6,1000);
	
	        do { 
	        		
				System.out.println("Sunshine: " + sunshine + "\nPEASHOOTER PRICE: 100 -  SUNFLOWER PRICE: 200" );
				System.out.println("Choose your plant type. You have " + sunshine + " Sunshines");
				char plantType = scanner.next().charAt(0);
				if(plantType == 's' || plantType == 'p')
				{
					game.setPlantType(plantType);
				
				
					System.out.println("Where do you want to put your " + game.charToPlantType(plantType) +"? Enter row column");
					int row = scanner.nextInt();
					int column = scanner.nextInt();
					scanner.nextLine();
	            
					if(row < 6 && row >= 0 && column < 6 && column >= 0) {
	            			game.plantTurn(row, column, plantType);
	            			if(nTurns - 2 == 0)
	            			{
	            				game.zombieTime(numZombies);
	            				nTurns = 0;
	            			}
	            			
	            		
					}
					else
					{
						System.out.println("Invalid input. please choose another location");
					}
					}
				
				else {
					System.out.println("Invalid input. Please choose 'p' or 's'");
				}
	            
	        } while (game.getGameState() == gameEnum.PLANT_TIME);
	        System.out.println( game.getGameState());
	       
	    }
	 
	 
	 
}
