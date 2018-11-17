import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controller class
 */
public class Controller implements ActionListener {
	
	gamePlay model;
	int x;
	int y;
	
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
		model.plantTurn(x, y);
		model.zombieTime(2);
	}
	
}
