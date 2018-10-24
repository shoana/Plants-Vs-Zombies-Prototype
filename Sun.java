import java.util.*;


class Sun {
	
    static Timer timer; //= new Timer();
    static int seconds; //= 0;
    private String type = " ";    //Set the object type to indicate which part of the program created the sun

	 //number is suns
	public Sun() {
		
		this.type = " ";
		this.seconds = 0;
		
	}
	
	public void getSun() {
		
		Random r = new Random();
		int sun = r.nextInt(10);
		
			
	if (type == "sunflower")
    {
        //Create a new timer
        Timer timer = new Timer();
        //Set as single shot
        
    }
    else
    {
        //Start timer to drop the sun
        Timer timer= new Timer();
        //Set the timer as a single shot
       
    }
	}
}
