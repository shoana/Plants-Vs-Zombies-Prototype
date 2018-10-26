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
					sunshine -= 50;
					Sunflower s = new Sunflower(50, row, column);
					System.out.println(" Do you want to collect the sun? (y/n) ");
					char sun = scanner.next().charAt(0);
					if(sun == 'y'){
						sunshine +=25;
					}
					sunflowers.add(s);
				}
				
				
			}
			else {
				System.out.println("You don't have enough sunshine");
			}
			
		setGameState(gameEnum.PLANT_TIME);
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
		
			for(int i = 0; i < numZombies; i++)
			{
				int random = 1;//r.nextInt(nRows);
				grid[random][(nRows - 1)] = 'z';
				Zombie z = new Zombie(random,(nRows -1)); //Add a new zombie to the list
				zombies.add(z);
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
		int plantsEaten = 0; 
		int zombiesEaten = 0;
		
		//EDGE CASES:
		//If there are no peashooters left and zombies are still left, zombies win
		if((peashooters.size() == 0 && zombies.size() > 0))
		{
			System.out.println("THE ZOMBIES WON! THEY ATE YOU!");
			return gameEnum.ZOMBIES_WIN;
		}
				
		//If there are no zombies left, peashooters automatically win
		if(zombies.size() == 0)
		{
			System.out.println(toString());
			System.out.println("YAY! YOU KILLED THE ALL THE ZOMBIES!");
			return gameEnum.PLANTS_WIN;
		}
		
		Iterator<Peashooter> it = peashooters.iterator();
		Iterator<Zombie> it2 = zombies.iterator();
		
				while(it.hasNext())
				{
					while(it2.hasNext())
					{
						if(it.hasNext() && it2.hasNext())
						{
							Peashooter p = it.next();
							Zombie b = it2.next();
						
						if(b.getPositionY() == 0)
						{
							return gameEnum.ZOMBIES_WIN;
						}
						
						if((p.getPositionX() == b.getPositionX()))
						{
							if(((b.getPositionY() - p.getPositionY())) < 3)
							{
								it.remove();
								grid[p.getPositionX()][p.getPositionY()] = ' ';
								b.setPositionY(b.getPositionY() - 1);
								grid[b.getPositionX()][b.getPositionY()] = 'z';
								plantsEaten++;
							}
							else
							{
								it2.remove();
								grid[b.getPositionX()][b.getPositionY()] = ' ';
								zombiesEaten++;
							}
						}
						
					}
				}
				}
				
				Iterator<Sunflower> it3 = sunflowers.iterator();
				Iterator<Zombie> it4 = zombies.iterator();
						
				while(it3.hasNext())
					while(it4.hasNext())
					{
						if(it3.hasNext() && it4.hasNext()) {
						Sunflower p = it3.next();
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
								b.setPositionY(b.getPositionY() - 1);
								grid[b.getPositionX()][b.getPositionY()] = 'z';
								plantsEaten++;
							}
							else
							{
								it4.remove();
								grid[b.getPositionX()][b.getPositionY()] = ' ';
								zombiesEaten++;
							}
						}
						
					}
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
	 
	 public String toString() {
		 
	
	  String s = "";
	  for (int r=0;r < nRows; r++ ) {
	      for (int c=0; c < nColumns; c++) {
	        s += grid[r][c] + " | ";
	      }
	       s += "\n";
	   }
	   return s;
	   
	 }
	 
	 
	 public static void main(String args[]) {
	        gamePlay game = new gamePlay(6,6,1000);
	        Scanner scanner = new Scanner(System.in);
	        
	        do { 
	        		System.out.println("Sunshine: " + sunshine + "\nPEASHOOTER PRICE: 100 -  SUNFLOWER PRICE: 200");
				System.out.println("Choose your plant type. You have " + sunshine + " Sunshines");
			
				char plantType = scanner.next().charAt(0);

				System.out.println(" Do you want to collect the sun? (y/n) ");
				char sun = scanner.next().charAt(0);
				if(sun == 'y'){
					sunshine +=25;
				}
			
				System.out.println("Now you have " + sunshine + "sunshine!");
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
	            				game.zombieTime(2);
	            				nTurns = 0;
	            			}
	            			
	            		
					}
					else
					{
						System.out.println("Invalid input. please choose another location");
					}
					}
				
				else {
					System.out.println("Invalid input. Please choose 'p' or 's' for plants and, 'y' and 'n' for collecting sunshine");
				}
	            
	        } while (game.getGameState() == gameEnum.PLANT_TIME);
	        System.out.println( game.getGameState());
	       
	    }
	 
	 
	 
}
