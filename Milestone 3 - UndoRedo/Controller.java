import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
/**
 * Controller class
 * @author sarahlamonica
 *
 */
public class Controller implements ActionListener {
	
	gamePlay model;
	private int x;
	private int y;
	
	
	/**
	 * Takes all model variables
	 * @param model
	 * @param x
	 * @param y
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
		//model.moveZombies();
		model.copyGame(); //copy the current game 
		model.flagZombieIncoming();
		model.plantTurn(x, y); //take a plant turn
		model.zombieTime(2); //set zombie time (from model)
		model.plantsOrZombies();
		JButton o = (JButton) e.getSource();
	}
	
}
