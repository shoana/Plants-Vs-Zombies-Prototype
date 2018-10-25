
public class Zombie {
	private int lifeRemaining; //Remaining life from zombie
	private int positionX; // zombie position
	private int positionY;  // zombie position
	
	
	public Zombie(int lifeRemaining, int positionX, int positionY) {

		//super();
		this.lifeRemaining = lifeRemaining;
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public int getLifeRemaining(){
		return lifeRemaining;
	}
	
	public int setLifeRemaining(){
		return this.lifeRemaining = lifeRemaining;
	}
	
	public int getPositionX(){
		return positionX;
	}
	
	public int setPositionX(){
		return this.positionX = positionX;
	}
	
	public int getPositionY(){
		return positionY;
	}
	
	public int setPositionY(){
		return this.positionY = positionY;
	}
	
	public int eat (){
		
	}
	
	public int walk (int positionX, int positionY) {
		if (this.lifeRemaining != 0) { //check if zombie is still living
			if (positionRow <= 0) { 
				return -1; // game lost
			}
			if () // check is next spot is empty
				// put zombie in new spot
				// remove zombie from old spot
				// update zombie row position (positionRow--)
				if (){ // check if positionRow <=0
					return -1; // game lost
				}
			}
			else { // next spot isn't empty
				if (){ // check what type of plant is there 
					// clear spot if zombie eats it // may have to have another method 'eat' here
				}
			}
		return 0;
		}
	}	
	
	
}
