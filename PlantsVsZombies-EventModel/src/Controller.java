import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *Controller class for the MVC model
 *@author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 *@version November 16th, 2018 
 *
 */
public class Controller implements ActionListener {
	
	gamePlay model;
	int x;
	int y;
	
	/**
	 * Takes all model variables
	 * @param model a type gamePlay 
	 * @param x is an type of integers coordiantes
	 * @param y is an type of integers corordinates
	 */
	public Controller(gamePlay model, int x, int y)
	{
		this.model = model;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Action performed method will delegate to the model
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		model.plantTurn(x, y);
		model.zombieTime(2);
	}
	
}
