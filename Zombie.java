public class Zombie {
	private int positionX; // zombie position
	private int positionY;  // zombie position
	
	
	public Zombie(int positionX, int positionY) {

		this.positionX = positionX;
		this.positionY = positionY;
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
