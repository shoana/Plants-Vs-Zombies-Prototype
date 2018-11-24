import java.util.ArrayList;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class gamePlay {
	private ArrayList<Plant> plants = new ArrayList<Plant>();
	private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	private static char plantType;
	private int nTurns = 0;
	private boolean isAllZombiesDead = true;
	private ArrayList<gamePlayListener> gameListeners;
	private boolean startGame = false;
	private int nRows, nColumns, sunshine;
	private char[][] board;
	private CommandManager commandManager;
	char[][] tempBoard;
	
	/**
	 * Constructor
	 * @param nRows
	 * @param nColumns
	 * @param sunshine
	 */
	public gamePlay(int nRows, int nColumns, int sunshine)
	{
		commandManager = new CommandManager();
		this.nRows = nRows;
		this.nColumns = nColumns;
		this.sunshine = sunshine;
		plantType = 'p';
		gameListeners = new ArrayList<gamePlayListener>();
		board = new char[6][6];
	}
	
	/**
	 * 
	 */
	public void copyGame()
	{
		tempBoard = new char[6][6];
		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				tempBoard[i][j] = board[i][j];
			}
		}
	}
	
	public void undo()
	{
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				board[i][j] = tempBoard[i][j];
			}
		}
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
		
		Object[] options = {"Peashooter", "Sunflower","CherryBomb", "Walnut"};
		int n = JOptionPane.showOptionDialog(null, "Choose your plant type!", "Choice", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[3]);
		
		if(n == 0)
		{
			plantType = 'p';
		}
		
		if(n == 1)
		{
			plantType = 's';
		}
		if(n == 2)
		{
			plantType = 'c';
			System.out.println("CHERRYBOMB");
		}
		if(n == 3)
		{
			plantType = 'w';
			System.out.println("WALNUT");
		}
		
		
		if(sunshine >= 50) {
			if(plantType == 'p' && sunshine >= 100) {
				sunshine -= 100;
				Peashooter p = new Peashooter(100, row, column, false); 
				board[row][column] = 'p';
				commandManager.executeCommand(new placePlantCommand(this, row, column));
				//////////if ()
				plants.add(p); //Add a peashooter to the array list
			}
			if(plantType == 'c' && sunshine >= 200)
			{
				sunshine -= 200;
				CherryBomb c = new CherryBomb(200, row, column, false);
				board[row][column] = 'c';
				commandManager.executeCommand(new placePlantCommand(this, row, column));
				plants.add(c);
			}
			if(plantType == 'w' && sunshine >= 200)
			{
				sunshine -= 200;
				Walnut w = new Walnut(200, row, column, false);
				board[row][column] = 'w';
				commandManager.executeCommand(new placePlantCommand(this, row, column));
				plants.add(w);
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
				board[row][column] = 's';
				commandManager.executeCommand(new placePlantCommand(this, row, column));
				plants.add(s); //Add a sunflower to the array list
			}
		}
		

		gamePlayEvent e = new gamePlayEvent (this, row, column, plantType, zombies, sunshine, plants, board);
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
						if(p instanceof CherryBomb)
						{
							//NEED TO FIGURE OUT HOW TO CHECK if within the 4 square
							if(p.getPositionX() - z.getPositionX() == 1 || p.getPositionY() - z.getPositionY() <= 1)
							{
								System.out.println("WE HAVE A BOMB!! kill all the plants in the area");
								System.out.println("Killed: " + z.getPositionX());
								z.setDmg(0);
								p.setEaten();
							}
						}
						if(p instanceof Walnut)
						{
							if(p.getPositionX() == z.getPositionX() && p.getPositionY() == z.getPositionY())
							{
								//need to halt the zombies if in the same grid space. thinking of
								//implementing a boolean variable!
							}
						}
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
			board[p.getPositionX()][p.getPositionY()] = p.getType();
			//commandManager.executeCommand(new placeZombieCommand(this, p.getPositionX(), p.getPositionY()));
			board[p.getPositionX()][p.getPositionY() + 1] = ' ';
			System.out.println("Zombie @: " + p.getPositionY());
		}
	}
	
	public char[][] getBoard()
	{
		return board;
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
				PylonZombie z = new PylonZombie(random, (nRows -1), false, 200, 'x');
				
				board[random][nRows - 1] = 'x';
				//commandManager.executeCommand(new placeZombieCommand(this, random, (nRows - 1)));
				zombies.add(z);
			}
			
			for(int i = 0; i < numZombies; i++) {
				int random = r.nextInt(nRows);
				NormalZombie z = new NormalZombie(random, (nRows -1), false, 100, 'z');
				
				board[random][nRows - 1] = 'z';
				//commandManager.executeCommand(new placeZombieCommand(this, random, (nRows - 1)));
				zombies.add(z);
			}
			
			startGame = true;
		}
	}
	
	
	
	public void flagZombieIncoming()
	{
		if(!startGame)
		{
			FlagZombie f = new FlagZombie(2,5, false, 100, 'f');
			board[2][5] = 'f';
			//commandManager.executeCommand(new placeZombieCommand(this,2,5));
			zombies.add(f);
		}
		
	}
	
//	public void undo()
//	{
//		commandManager.undo();
//	}
//	
//	public void redo()
//	{
//		commandManager.redo();
//	}
//	
	
	
	/**
	 * CLR THE ARRAY OF ALL PLANTS AND ZOMBIES, use this for levels
	 */
	public void clr()
	{
		plants.removeAll(plants); 
		zombies.removeAll(zombies);
	}
	
	
	private class placePlantCommand implements Command{
		private gamePlay model;
		private char[][] previousGridState;
		private char[][] nextGridState;
		private int previousScore, nextScore;
		
		
		private placePlantCommand(gamePlay model, int row, int col)
		{
			this.model = model;
			previousGridState = new char[6][6];
			nextGridState = new char[6][6];
			if (plantType == 'w' || plantType == 'c') {
				previousScore = sunshine + 200;
			}
			if (plantType == 'p') {
				previousScore = sunshine + 100;
			}
			if (plantType == 's') {
				previousScore = sunshine + 50;
			}
			
			for(int i = 0; i < 6; i++)
			{
				for(int j = 0; j < 6; j++) {
					previousGridState[i][j] = model.board[i][j];
					nextGridState[i][j] = model.board[i][j];
				}
			}
			
			//figure out next grid space by applying logic
			nextGridState[row][col] = model.plantType;
		}
		
		@Override
		public void execute() {
			// TODO Auto-generated method stub
			model.board = nextGridState;
			
		}

		@Override
		public void undo() {
			// TODO Auto-generated method stub
			model.board = previousGridState;
			sunshine = previousScore;
			System.out.print("Undo");
			
		}
		
		@Override
		public void redo() {
			model.board = nextGridState;
		}
		
		
	}
	
	
	private class placeZombieCommand implements Command{
		private gamePlay model;
		private char[][] previousGridState, nextGridState;
		private int row, col;

		private placeZombieCommand(gamePlay model, int row, int col)
		{
			this.model = model;
			previousGridState = new char[6][6];
			this.row = row;
			this.col = col;
			nextGridState = new char[6][6];
			
			for(int i = 0; i < 6; i++)
			{
				for(int j = 0; j < 6; j++) {
					previousGridState[i][j] = model.board[i][j];
					nextGridState[i][j] = model.board[i][j];
				}
			}
			
			//figure out next grid space by applying logic
			nextGridState[row][col] = 'z';
		}
		
		@Override
		public void execute() {
			// TODO Auto-generated method stub
			model.board = nextGridState;
			
		}
		
		@Override
		public void undo() {
			// TODO Auto-generated method stub
			model.board = previousGridState;
			System.out.print("Undo");
			
		}
		
		@Override
		public void redo()
		{
			model.board = nextGridState;
		}
		
	}


}
