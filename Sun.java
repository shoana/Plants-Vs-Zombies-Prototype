import java.util.*;


class Sun{

	private static final int money = 50; //at the start of the game
	private static final int sun;
	private int positionX; 
	private int positionY;
   	//static Timer timer; //= new Timer();
    	//static int seconds; //= 0;
	//number is suns
		
	public Sun() {
		//this.type = " ";
		//this.seconds = 0
	
	}
	
	public int generateSun(int money){
		 
		for(int i; i < 50 ; i++){
			money += 25;
			sun = money/25;
			System.out.println("Now you have: " + sun + " suns!");
		}
	
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
	
	public int getSun() {
		 return sun;
	}
		
	public int outputSun(){
	
		Random outputSun = new Random();
		int (//the cordinate) = outputSun.nextInt(g);
	
	}	//Random r = new Random();
		//int sun = r.nextInt(10);
		
			
	if (isCollect() = true){ //sunflower generating the sun and the sun is being randomly generated itself
        //Create a new timer
        //Timer timer = new Timer();
        //Set as single shot
        
    }
    else //sun is being randomly generated
    {
        //Start timer to drop the sun
        Timer timer= new Timer();
        //Set the timer as a single shot
       
    }
	}
}
