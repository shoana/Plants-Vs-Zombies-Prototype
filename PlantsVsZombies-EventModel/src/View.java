import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


public class View extends JFrame implements gamePlayListener {

	
	private String player;
	private String winner;
	private JButton board[][];
	private JFrame window = new JFrame("Plants vs. Zombies"); //JBUTTONS FOR GRID
	private JLabel gameStatus;
	private JLabel scoreStatus;
	private JMenuItem resetItem, quitItem;

	private static final String peashooter = "P";
	private static final String zombie = "S";
	private static final String sunshine = "S";
	private static final String EMPTY = "";
	private int nTurns = 0; //Number of turns the user has taken
	private JButton peashooterButton, sunshineButton;

	private List <JMenuItem> menu = new ArrayList<JMenuItem>();

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

		//add peashooter actionlistener
		peashooterButton = new JButton("Peashooter");
		//peashooterButton.addActionListener(this);

		//add sunshine actionlistener
		sunshineButton = new JButton("Sunshine");
		//sunshineButton.addActionListener(this);


		peashooterButton.setSize(10, 50);
		sunshineButton.setSize(10,50);

		plantType.add(peashooterButton, BorderLayout.EAST);
		plantType.add(sunshineButton, BorderLayout.WEST);

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
				board[i][j] = new JButton(EMPTY);
				board[i][j].setFont(font);
				gamePanel.add(board[i][j]);
				board[i][j].addActionListener(new Controller(model, i, j));
			}
		}


		window.setVisible(true);

	}

	
	

	public JButton[][] getBoard()
	{
		return board;
	}

	public JLabel getGameStatusLabel()
	{
		return gameStatus;
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

	@Override
	public void handleGameEvent(gamePlayEvent e) {
		int x = e.getX();
		int y = e.getY();
		char plant = e.getPlantType();
		gameEnum s = e.getGameEnum();
		ArrayList<Zombie> z = e.returnZombie();
		
		board[x][y].setText(String.valueOf(plant));
		scoreStatus.setText("Sunshines Left: " + String.valueOf(e.getSunshines()));
		
		for(Zombie zed: z)
		{
			board[zed.getPositionX()][zed.getPositionY()].setText("z");;
		}
		
		if(s == gameEnum.PLANT_TIME) return;
		if(s == gameEnum.ZOMBIE_TIME) {
			System.out.println("ZOMBIE TIME");
			for(int i = 0; i < 6; i++)
			{
				for(int j = 0; j < 6; j++)
				{
					
				}
			}
		}
		if(s == gameEnum.PLANTS_WIN) {
			PLANTS_WIN: JOptionPane.showMessageDialog(this, "PLANTS WON");
		}
		if(s == gameEnum.ZOMBIES_WIN)
		{
			JOptionPane.showMessageDialog(this, "ZOMBIES WON");
		}		
	}
	
	public static void main(String[] args)
	{
		new View();
	}
}
