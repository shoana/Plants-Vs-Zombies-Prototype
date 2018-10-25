
public class Peashooter {
	private int cost;
	private int damage;
	private int positionX;
	private int positionY;
	
	public Peashooter(int cost, int positionX, int positionY)
	{
		this.cost = cost;
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
