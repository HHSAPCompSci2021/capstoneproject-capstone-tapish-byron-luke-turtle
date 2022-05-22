package sprites;

import java.util.ArrayList;

/**
 * This represents the map storing the obstacles and chests. 
 * @author Byron Tam, Tapish Singh
 * @version 5/14/22
 */
public class GameMap {
	ArrayList<Obstacle> obs1 = new ArrayList<>();
	ArrayList<Obstacle> obs2 = new ArrayList<>();
	ArrayList<Obstacle> obs3 = new ArrayList<>();
	ArrayList<Obstacle> obs4 = new ArrayList<>();
	ArrayList<Obstacle> obs5 = new ArrayList<>();
	ArrayList<Obstacle> obs6 = new ArrayList<>();
	ArrayList<Obstacle> obs7 = new ArrayList<>();
	ArrayList<Obstacle> obs8 = new ArrayList<>();
	ArrayList<Obstacle> obs9 = new ArrayList<>();
	ArrayList<Enemy> enemy1 = new ArrayList<>();
	ArrayList<Enemy> enemy2 = new ArrayList<>();
	ArrayList<Enemy> enemy3 = new ArrayList<>();
	ArrayList<Enemy> enemy4 = new ArrayList<>();
	ArrayList<Enemy> enemy5 = new ArrayList<>();
	ArrayList<Enemy> enemy6 = new ArrayList<>();
	ArrayList<Enemy> enemy7 = new ArrayList<>();
	ArrayList<Enemy> enemy8 = new ArrayList<>();
	ArrayList<Enemy> enemy9 = new ArrayList<>();
	ArrayList<Chest> chest1 = new ArrayList<>();
	ArrayList<Chest> chest2 = new ArrayList<>();
	ArrayList<Chest> chest3 = new ArrayList<>();
	ArrayList<Chest> chest4 = new ArrayList<>();
	ArrayList<Chest> chest5 = new ArrayList<>();
	ArrayList<Chest> chest6 = new ArrayList<>();
	ArrayList<Chest> chest7 = new ArrayList<>();
	ArrayList<Chest> chest8 = new ArrayList<>();
	ArrayList<Chest> chest9 = new ArrayList<>();
	
	/**
	 * constructor for creating the map. Sets the difficulty upon instantiation (true = easy, false = hard)
	 * @param diff difficulty(true for easy, false for hard)
	 */
	public GameMap() {
		chest5.add(new Chest(700, 550, 80, 60));
		obs5.add(new Obstacle(600, 450, 50, 50, 1));
		obs5.add(new Obstacle(300, 450, 50, 50, 1));
		obs5.add(new Obstacle(100, 450, 50, 50, 1));
		obs5.add(new Obstacle(200, 240, 50, 50, 1));
		obs5.add(new Obstacle(500, 280, 50, 50, 1));
		obs5.add(new Obstacle(250, 450, 50, 50, 1));
		obs5.add(new Obstacle(270, 450, 50, 50, 1));
		obs5.add(new Obstacle(600, 450, 50, 50, 1));
		obs5.add(new Obstacle(360, 450, 50, 50, 1));
		obs5.add(new Obstacle(750, 450, 50, 50, 1));
		enemy5.add(new Enemy(500, 500, 50, 50, true));
		enemy5.add(new Enemy(700, 200, 50, 50, false));
		enemy5.add(new Enemy(300, 100, 50, 50, true));
		enemy5.add(new Enemy(400, 300, 50, 50, false));
		enemy5.add(new Enemy(600, 700, 50, 50, false));
		obs5.add(new Obstacle(500, 200, 50, 50, 1));
	}
	
	public void setMapDiff(boolean diff) {
			chest5.add(new Chest(700, 550, 80, 60));
			obs5.add(new Obstacle(600, 450, 50, 50, 1));
			obs5.add(new Obstacle(300, 450, 50, 50, 1));
			obs5.add(new Obstacle(100, 450, 50, 50, 1));
			obs5.add(new Obstacle(200, 240, 50, 50, 1));
			obs5.add(new Obstacle(500, 280, 50, 50, 1));
			obs5.add(new Obstacle(250, 450, 50, 50, 1));
			obs5.add(new Obstacle(270, 450, 50, 50, 1));
			obs5.add(new Obstacle(600, 450, 50, 50, 1));
			obs5.add(new Obstacle(360, 450, 50, 50, 1));
			obs5.add(new Obstacle(750, 450, 50, 50, 1));
			enemy5.add(new Enemy(500, 500, 50, 50, true));
			enemy5.add(new Enemy(700, 200, 50, 50, false));
			enemy5.add(new Enemy(300, 100, 50, 50, true));
			enemy5.add(new Enemy(400, 300, 50, 50, false));
			enemy5.add(new Enemy(600, 700, 50, 50, false));
			obs5.add(new Obstacle(500, 200, 50, 50, 1));
	}
	public ArrayList<Obstacle> getCurrentObstacle(int roomNum) {
		if (roomNum == 1) return obs1;
		if (roomNum == 2) return obs2;
		if (roomNum == 3) return obs3;
		if (roomNum == 4) return obs4;
		if (roomNum == 5) return obs5;
		if (roomNum == 6) return obs6;
		if (roomNum == 7) return obs7;
		if (roomNum == 8) return obs8;
		if (roomNum == 9) return obs9;
		return null;
	}
	public ArrayList<Enemy> getCurrentEnemy(int roomNum) {
		if (roomNum == 1) return enemy1;
		if (roomNum == 2) return enemy2;
		if (roomNum == 3) return enemy3;
		if (roomNum == 4) return enemy4;
		if (roomNum == 5) return enemy5;
		if (roomNum == 6) return enemy6;
		if (roomNum == 7) return enemy7;
		if (roomNum == 8) return enemy8;
		if (roomNum == 9) return enemy9;
		return null;
	}
	public ArrayList<Chest> getCurrentChest(int roomNum) {
		if (roomNum == 1) return chest1;
		if (roomNum == 2) return chest2;
		if (roomNum == 3) return chest3;
		if (roomNum == 4) return chest4;
		if (roomNum == 5) return chest5;
		if (roomNum == 6) return chest6;
		if (roomNum == 7) return chest7;
		if (roomNum == 8) return chest8;
		if (roomNum == 9) return chest9;
		return null;
	}
	
	
}
