import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.color.*;
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
	private JMenuItem one, two, three;
	private ImageIcon grassIcon = new ImageIcon("Background1.jpg");

	private static final String peashooter = "P";
	private static final String zombie = "S";
	private static final String sunshine = "S";
	private static final String EMPTY = "";
	private int nTurns = 0; //Number of turns the user has taken
	private JButton peashooterButton, sunshineButton;

	private JButton undo, redo, save, load;
	private gamePlay model;
	private List <JMenuItem> menu = new ArrayList<JMenuItem>();

	/**
	 * Constructs the View
	 */

	public View()
	{
		model = new gamePlay(6,6, 800);
		model.addGamePlayListener(this);

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
				updateBoard();
			} catch (ClassNotFoundException | IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});

		undo.addActionListener(e -> 
		{
			model.undo();
			updateBoard();
		});

		redo.addActionListener(e -> { model.redo(); updateBoard(); });
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

		JTextField zombieLife = new JTextField();
		JPanel zl = new JPanel();
		zl.setLayout(new BorderLayout());
		zl.add(zombieLife, BorderLayout.SOUTH);
		zombieLife.setEditable(false);
		zombieLife.setText(" Zombie Life Left: ");
		zombieLife.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Zombie Life"), zombieLife.getBorder()));
		window.getContentPane().add(zombieLife, BorderLayout.SOUTH);


		Font font = new Font("AR DARLING", Font.PLAIN, 30);

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				board[i][j] = new JButton();
				board[i][j].setFont(font);
				board[i][j].setBackground(Color.GREEN);
				gamePanel.add(board[i][j]);
				board[i][j].setEnabled(true);
				board[i][j].addActionListener(new Controller(model, i, j));
			}
		}

		window.setSize(500,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Game");


		one = new JMenuItem("Level 1");
		one.addActionListener(e -> {
			enableAll();
			model.lvlOne();
			updateBoard();
		});
		fileMenu.add(one); // and add to our menu 
		
		//if ((model.getLvl1())) { 
		two = new JMenuItem("Level 2"); 
		two.setEnabled(true);
		two.addActionListener(e -> {
			model.lvlTwo();
			updateBoard();
		});
		fileMenu.add(two); // and add to our menu 
		//	}

		//if ((model.getLvl2())) {
		three = new JMenuItem("Level 3");
		three.setEnabled(true);
		three.addActionListener(e -> {
			model.zombieTime(3);
			updateBoard();
		});
		fileMenu.add(three);
		//}

		menuBar.add(fileMenu);
		window.setJMenuBar(menuBar);
		disableAll();
		window.setVisible(true);

	}

	/**
	 * Disables all buttons (game over)
	 */
	public void disableAll() {

		int i, j;
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				board[i][j].setEnabled(false);
			}
		}
	}

	/**
	 * Enables all buttons
	 */
	public void enableAll()
	{
		int i, j;
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				board[i][j].setEnabled(true);
			}
		}
	}

	public void updateBoard()
	{
		char grid[][] = model.getBoard();
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				board[i][j].setText(String.valueOf(grid[i][j]));
			}
		}
	}

	/**
	 * Game event Handler
	 */
	@Override
	public void handleGameEvent(gamePlayEvent e) {

		/*if((model.getLvl1())) {
			System.out.println("WON");
			two.setEnabled(true);
		}
		if(model.getLvl1() && model.getLvl2()) {
			three.setEnabled(true);
		}*/
		
		if(model.getLvl2()) {
			//System.out.println("WON");
			two.setEnabled(true);
		}
		if(model.getLvl3()) {
			three.setEnabled(true);
		}

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

	public static void main(String[] args) {
		new View();
		JOptionPane.showMessageDialog(null,"Press on 'Game' and Level 1 to start the game!");

	}
}
