
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
	
	public void setLifeRemaining(int lifeRemaining){
		this.lifeRemaining = lifeRemaining;
	}
	
	public int getPositionX(){
		return positionX;
	}
	
	public void setPositionX(int positionX){
		this.positionX = positionX;
	}
	
	public int getPositionY(){
		return positionY;
	}
	
	public void setPositionY(int positionY){
		this.positionY = positionY;
	}	
	
}
