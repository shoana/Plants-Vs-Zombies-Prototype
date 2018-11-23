
public class NormalZombie extends Zombie {

	public NormalZombie(int positionX, int positionY, boolean isEaten, int damagePoints) {
		super(positionX, positionY, isEaten, damagePoints);
		// TODO Auto-generated constructor stub
	}
	
	public void move()
	{
		super.setPositionY(super.getPositionY() - 1);
	}

}
