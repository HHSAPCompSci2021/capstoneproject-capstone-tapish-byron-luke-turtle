package sprites;

public class Obstacle extends Sprite {

	int obsType;
	
	public Obstacle(double x, double y, int faceDir) {
		super(x, y, faceDir);
	}
	
	// method below is only if we decide to make obst spawning random
	public void decideSpawnPoint() {
		
	}
}
