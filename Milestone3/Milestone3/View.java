import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * View class for implementing the Plants vs. Zombies game
 * @author sarahlamonica
 */
public class View extends JFrame implements gamePlayListener {
	int startNum = 4;
	private String player;
	private String winner;
	private JButton board[][];
	private JFrame window = new JFrame("Plants vs. Zombies"); //JBUTTONS FOR GRID
	private JLabel gameStatus;
	private JLabel scoreStatus;
	private JMenuItem resetItem, quitItem;
	private ImageIcon grassIcon = new ImageIcon("Background1.jpg");

	private static final String peashooter = "P";
	private static final String zombie = "S";
	private static final String sunshine = "S";
	private static final String EMPTY = "";
	private int nTurns = 0; //Number of turns the user has taken
	private JButton peashooterButton, sunshineButton;

	

	private List <JMenuItem> menu = new ArrayList<JMenuItem>();

	/**
	 * Constructs the View
	 */
	public View()
	{
		gamePlay model = new gamePlay(6,6, 1000);
        model.addGamePlayListener(this);

		window.setSize(500,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Game");
		menuBar.add(fileMenu);

		resetItem = new JMenuItem("Reset"); // create a menu item called "Reset"
		fileMenu.add(resetItem); // and add to our menu 
		//resetItem.addActionListener(this);

		quitItem = new JMenuItem("Quit"); // create a menu item called "Quit"
		fileMenu.add(quitItem); // and add to our menu 
		//quitItem.addActionListener(this);

		window.getContentPane().setLayout(new BorderLayout()); // default so not required

		JPanel plantType = new JPanel();
		plantType.setLayout(new BorderLayout());


		window.getContentPane().add(plantType, BorderLayout.NORTH);


		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(6,6));
		window.getContentPane().add(gamePanel, BorderLayout.CENTER);

		//gameStatus = new JLabel("Game Status is Here");
		scoreStatus = new JLabel("Sunshines Left: 1000");

		//window.getContentPane().add(gameStatus, BorderLayout.SOUTH);
		window.getContentPane().add(scoreStatus, BorderLayout.EAST);

		board = new JButton[6][6];

		Font font = new Font("Dialog", Font.BOLD, 24);
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				board[i][j] = new JButton();
				board[i][j].setFont(font);
				gamePanel.add(board[i][j]);
				board[i][j].addActionListener(new Controller(model, i, j));
			}
		}


		window.setVisible(true);

	}
	
	/**
	 * Disables all buttons (game over)
	 */
	private void disableAll() {

		int i, j;
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				board[i][j].setEnabled(false);
			}
		}
	}

	/**
	 * Game event Handler
	 */
	@Override
	public void handleGameEvent(gamePlayEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		char plant = e.getPlantType();
		
		ArrayList<Zombie> z = e.returnZombie();
		ArrayList<Plant> ps = e.getPeas();
		
		board[x][y].setText(String.valueOf(plant));
		board[x][y].setEnabled(false);
		scoreStatus.setText("Sunshines Left: " + String.valueOf(e.getSunshines()));
		
		for(Zombie zed: z)
		{
			
			if(zed.getDmg() <= 0) //if the zombies reach 0 dmg points, they die
			{
				System.out.println("DMG");
				board[zed.getPositionX()][zed.getPositionY()].setText(" ");
			}
			else { //move the zombies if they are still on the grid
				board[zed.getPositionX()][zed.getPositionY()].setText("z");
				board[zed.getPositionX()][zed.getPositionY() + 1].setText(" ");
				System.out.println("ON GRID");
			}
		}
		
		for(Plant peas : ps)
		{
			if(peas.getEaten()) // if the plant is eaten then remove it off the board
			{
				board[peas.getPositionX()][peas.getPositionY()].setText(" ");
				System.out.println("PLANTS");
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		new View();
	}
}
