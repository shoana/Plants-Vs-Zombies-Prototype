package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import model.gamePlay;

/** 
 * This class sets up Controller of MVC pattern
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version December 5th, 2018
 */
public class Controller implements ActionListener {
	
	gamePlay model;
	private int x;
	private int y;
	
	/**
	 * Takes all model variables
	 * @param model is type of game play  
	 * @param x an integer for x co-ordinate
	 * @param y an integer for y co-ordinate
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
		//model.flagZombieIncoming();
		model.plantTurn(x, y); //take a plant turn
		//model.zombieTime(2); //set zombie time (from model)
		model.plantsOrZombies(); //check for wins
		
	}
	
}
