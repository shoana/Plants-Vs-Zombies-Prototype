import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

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

	private JButton undo, redo, save, load;

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
		

		quitItem = new JMenuItem("Quit"); // create a menu item called "Quit"
		fileMenu.add(quitItem); // and add to our menu 

		window.getContentPane().setLayout(new BorderLayout()); // default so not required

		JPanel plantType = new JPanel();
		JPanel saveLoad = new JPanel();
		saveLoad.setLayout(new BorderLayout());
		plantType.setLayout(new BorderLayout());

		undo = new JButton("Undo");
		redo = new JButton("Redo");
		save = new JButton("Save");
		load = new JButton("Load");
		undo.setEnabled(false);
		redo.setEnabled(false);
		save.setEnabled(true);
		load.setEnabled(true);
		save.setSize(100, 50);
		load.addActionListener(e -> {
			try {
				model.load();
			} catch (ClassNotFoundException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		undo.addActionListener(e -> model.undo());
		redo.addActionListener(e -> model.redo());
		save.addActionListener(e -> {
			try {
				model.save();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		JTextField gameLegend = new JTextField();
		gameLegend.setEditable(false);
		gameLegend.setText(" X: PYLON ZOMBIE Z: NORMAL ZOMBIE F: FLAG ZOMBIE");
		gameLegend.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Zombie Types"), gameLegend.getBorder()));
		plantType.add(undo, BorderLayout.WEST);
		plantType.add(redo, BorderLayout.EAST);
		saveLoad.add(save, BorderLayout.WEST);
		saveLoad.add(load, BorderLayout.EAST);
		plantType.add(saveLoad, BorderLayout.CENTER);
		plantType.add(gameLegend, BorderLayout.SOUTH);
		window.getContentPane().add(plantType, BorderLayout.NORTH);


		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(6,6));
		window.getContentPane().add(gamePanel, BorderLayout.CENTER);		
		scoreStatus = new JLabel("Sunshines Left: 1000");
		window.getContentPane().add(scoreStatus, BorderLayout.EAST);

		board = new JButton[6][6];

		Font font = new Font("Monospaced", Font.BOLD, 30);
		
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
		char[][] grid = e.getBoard();
		undo.setEnabled(true);
		redo.setEnabled(true);
		
		ArrayList<Zombie> z = e.returnZombie();
		ArrayList<Plant> ps = e.getPeas();
		
		scoreStatus.setText("Sunshines Left: " + String.valueOf(e.getSunshines()));
		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				board[i][j].setText(String.valueOf(grid[i][j]));
			}
		}

	}
	
	public static void main(String[] args)
	{
		new View();
	}
}
