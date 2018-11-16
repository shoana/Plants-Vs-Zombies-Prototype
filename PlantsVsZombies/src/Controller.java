import java.util.ArrayList;

public class Controller {

	//Instantiate model & view
	private gamePlay model;
	private View view;

	/**
	 * 
	 * @param v
	 */
	public void setGamePlayView(View v)
	{
		this.view = v;
	}

	/**
	 * 
	 * @param m
	 */
	public void setGamePlayModel(gamePlay m)
	{
		this.model = m;
	}

	public void createGame()
	{
		model = new gamePlay(6, 6, 1000);
		//view = new View();
	}

	public void setPlantType(char c)
	{
		model.setPlantType(c);
	}

	public String getGameStatus()
	{
		return "" + model.gameStatus();
	}

	public void setPlantDown(int row, int column, char plantType)
	{
		model.plantTurn(row, column, plantType);
	}

	public ArrayList<Zombie> getZombiePosition()
	{
		return model.getZombies();
	}

	public void setZombieTime(int numZombies)
	{
		model.zombieTime(numZombies);
	}	

	public char getPlantType()
	{
		return model.getPlantType();
	}
	
	public gameEnum getGameState() 
	{
		return model.getGameState();
	}
	
	public void setZombieToBoard()
	{
		view.setZombiesOnBoard();
	}
	
	public String getSunshinesLeft()
	{
		return model.sunshinesLeft();
	}
	

}
