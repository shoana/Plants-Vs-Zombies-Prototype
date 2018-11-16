
public class App {
	
	public static void main(String[] args)
	{
		//Set up MVC
		Controller controller = new Controller();
		View view = new View(controller);
		controller.setGamePlayView(view);
	}

}
