import java.util.ArrayList;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Game Play class to represent the game being played
 * @author sarahlamonica
 *
 */
public class gamePlay {
	private ArrayList<Plant> plants = new ArrayList<Plant>();
	private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	private static char plantType;
	private int nTurns = 0;
	private boolean isAllZombiesDead = true;
	private ArrayList<gamePlayListener> gameListeners;
	private boolean startGame = false;
	private int nRows, nColumns, sunshine;
	
	/**
	 * Constructor
	 * @param nRows
	 * @param nColumns
	 * @param sunshine
	 */
	public gamePlay(int nRows, int nColumns, int sunshine)
	{
		this.nRows = nRows;
		this.nColumns = nColumns;
		this.sunshine = sunshine;
		plantType = 'p';
		gameListeners = new ArrayList<gamePlayListener>();
	}
	
	/**
	 * Gameplay event model method
	 * @param tttl
	 */
	public void addGamePlayListener(gamePlayListener tttl) {
        gameListeners.add(tttl);
    }
	
	/**
	 * place a plant in the space
	 * @param row
	 * @param column
	 */
	public void plantTurn(int row, int column)
	{
		nTurns++;
		System.out.println(nTurns);
		if(nTurns == 1)
		{
			moveZombies();
			nTurns = 0;
		}
		
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
				plants.add(p); //Add a peashooter to the array list
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
				plants.add(s); //Add a sunflower to the array list
			}
		}
		

		gamePlayEvent e = new gamePlayEvent (this, row, column, plantType, zombies, sunshine, plants);
        for (gamePlayListener tttl: gameListeners) tttl.handleGameEvent(e);
	}
	
	/**
	 * Checks if the plants or zombies win
	 */
	public void plantsOrZombies()
	{
				isAllZombiesDead = true;
				for(Zombie z : zombies) {
					//If they reach the house, zombies win
					if(z.getPositionY() == 0) { 
						System.out.println("Zombies reached the house. Plants LOSE");
						JOptionPane.showMessageDialog(null,"Zombies reached the house! \n ZOMBIES WON");
						System.exit(-1);
					}
					if(z.getDmg() > 0)
					{
						isAllZombiesDead = false;
					}
				}
				
				for(Zombie z : zombies)
				{
					for(Plant p : plants)
					{
						if(z.getPositionX() == p.getPositionX())
						{
							z.setDmg(z.getDmg() - 100);
							if(z.getPositionY() == p.getPositionY())
							{
								p.setEaten();
							}
						}
					}
				}
				
				if(isAllZombiesDead)
				{
					JOptionPane.showMessageDialog(null,"Plants defeated all the zombies! \n PLANTS WON");
					System.exit(-1);
				}
				
	}
	
	/**
	 * Moves every zombie one space 
	 */
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
	 * This method keeps track of the affects on zombie when the game state
	 * is zombie time.
	 * @param numZombies the number of zombies in the game at that moment
	 */
	public void zombieTime(int numZombies) {

		//Random variable for placing zombies at a random grid space
		Random r = new Random();

		if(!startGame) {
			for(int i = 0; i < numZombies; i++) {
				int random = r.nextInt(nRows);
				PylonZombie z = new PylonZombie(random, (nRows -1), false, 200);
				zombies.add(z);
			}
			
			startGame = true;
		}
	}
	
	/**
	 * CLR THE ARRAY OF ALL PLANTS AND ZOMBIES
	 */
	public void clr()
	{
		plants.removeAll(plants); 
		zombies.removeAll(zombies);
	}


}
