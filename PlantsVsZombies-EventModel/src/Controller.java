import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {
	
	gamePlay model;
	int x;
	int y;
	
	
	
	public Controller(gamePlay model, int x, int y)
	{
		this.model = model;
		this.x = x;
		this.y = y;
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.plantTurn(x, y, 'p');
		model.zombieTime(2);
	}
	
	

}
