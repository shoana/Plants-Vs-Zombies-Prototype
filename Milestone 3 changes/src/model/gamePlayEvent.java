package model;

import java.util.ArrayList;
import java.util.EventObject;

/**
 *Event class for the MVC model which extends EventObjects
 *@author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 *@version November 25th, 2018 
 *
 */
public class gamePlayEvent extends EventObject {

	private int x;
	private int y;
	private char plantType;
	private ArrayList<Zombie> z;
	private int sunshines;
	private ArrayList<Plant> p;
	private char[][] board;
	
	/**
	 * The constructor for gamePlayEvent class
	 * @param source is a type of object 
	 * @param x is a type of interger corresponding to the coordiantes
	 * @param y is a type of integer corresponding to the coordinates
	 * @param plantType is type of character choosen for plant type
	 * @param z is a type of an array list of zombies
	 * @param sunshines is type integers for keep track of the money used
	 */
	public gamePlayEvent(Object source, int x, int y, char plantType, ArrayList<Zombie> z, int sunshines, ArrayList<Plant> p, char[][] board) {
		super(source);
		this.x = x;
		this.y = y;
		this.plantType = plantType;
		this.z = z;
		this.sunshines = sunshines;
		this.p = p;
		this.board = board;
		
	}
	
	/**
	 * This method returns plant from an array list 
	 * @return a type of array list for plants
	 */
	public ArrayList<Plant> getPeas()
	{
		return this.p;
	}
	
	/**
	 * This method returns zombies from an array list 
	 * @return a type of array list for zombies
	 */
	public ArrayList<Zombie> returnZombie()
	{
		return this.z;
	}

	/**
	 * This method gets the current state of the board
	 * @return a gird of char
	 */
	public char[][] getBoard()
	{
		return board;
	}
	
	/**
	 * This method gets the x coordinate
	 * @return a type integer x 
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * This method gets the y coordinate
	 * @return a type integer y 
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * This method gets the sunshine used for 
	 * keeping track of the money spent
	 * @return a type integer for the sunshines
	 */
	public int getSunshines()
	{
		return sunshines;
	}
	
	/**
	 * This method returns a type of char for the plant type
	 * @return a charater for the type of plant type
	 * sunflower/peashooter
	 */
	public char getPlantType()
	{
		return plantType;
	}

	
}
