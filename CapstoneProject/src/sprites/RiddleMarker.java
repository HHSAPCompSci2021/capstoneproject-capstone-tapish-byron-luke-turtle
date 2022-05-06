package sprites;

public class RiddleMarker extends Sprite {

	RiddleBank riddle;
	
	public RiddleMarker(double x, double y, int faceDir) {
		super(x, y, NOTAPPLICABLE);
	}
	
	public void chooseRiddle(int num) {
		riddle = new RiddleBank(num);
	}
}
