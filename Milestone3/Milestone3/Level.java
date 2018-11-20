import java.util.ArrayList;

public class Level {
	
	public static ArrayList<Plant> allPlantTypes; 
	private static ArrayList<Peashooter> peashooters; // = new ArrayList<Peashooter>(); 
	private static ArrayList<Sunflower> sunflowers; // = new ArrayList<Sunflower>();
	private static ArrayList<Zombie> allZombies; 
	static int numOfZombies = 0;
	
	
	public static boolean isEmpty() {
		return (allZombies.isEmpty());
	}
	

	public static void level1() {	
		startLevel();
		numOfZombies = 2;

		sunflowers.add(new Sunflower());
		peashooters.add(new Peashooter());

		for (int i = 0; i < numOfZombies; i++)
			allZombies.add(new Zombie()); 
	}
	
	
	public static void startLevel() {
		allZombies = new ArrayList<Zombie>();
		allPlantTypes = new ArrayList<Plant>();
	}
	
	public static ArrayList<Zombie> getAllZombies(){
		return allZombies;
	}
	
	public static void setAllZombies(ArrayList<Zombie> zombies) {
		allZombies = zombies;
	}
	
}