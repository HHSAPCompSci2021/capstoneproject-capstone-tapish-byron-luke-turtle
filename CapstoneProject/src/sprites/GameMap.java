package sprites;

import java.util.ArrayList;

/**
 * This represents the map storing the obstacles and chests. 
 * @author Byron Tam, Luke Yang
 * @version 5/21/22
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
	Gate gate;
	
	/**
	 * constructor for creating the map. Sets the difficulty upon instantiation (true = easy, false = hard)
	 * @param diff difficulty(true for easy, false for hard)
	 */
	public GameMap() {
		//room 1
		obs1.add(new Obstacle(450, 300, 50, 50, 1));
		obs1.add(new Obstacle(400, 300, 50, 50, 1));
		obs1.add(new Obstacle(350, 300, 50, 50, 1));
		obs1.add(new Obstacle(200, 250, 50, 50, 1));
		obs1.add(new Obstacle(250, 250, 50, 50, 1));
		obs1.add(new Obstacle(300, 250, 50, 50, 1));
		obs1.add(new Obstacle(150, 200, 50, 50, 1));
		obs1.add(new Obstacle(100, 200, 50, 50, 1));
		obs1.add(new Obstacle(600, 350, 50, 50, 1));
		obs1.add(new Obstacle(600, 400, 50, 50, 1));
		obs1.add(new Obstacle(600, 450, 50, 50, 1));
		obs1.add(new Obstacle(600, 500, 50, 50, 1));
		obs1.add(new Obstacle(600, 550, 50, 50, 1));
		obs1.add(new Obstacle(550, 350, 50, 50, 1));
		obs1.add(new Obstacle(500, 350, 50, 50, 1));
		obs1.add(new Obstacle(50, 200, 50, 50, 1));
		obs1.add(new Obstacle(0, 200, 50, 50, 1));
		obs1.add(new Obstacle(200, 350, 50, 50, 0));
		obs1.add(new Obstacle(100, 400, 50, 50, 0));
		enemy1.add(new Enemy(250, 100, 50, 50, true));
		enemy1.add(new Enemy(400, 100, 50, 50, true));
		enemy1.add(new Enemy(550, 100, 50, 50, true));
		enemy1.add(new Enemy(250, 450, 50, 50, false));
		enemy1.add(new Enemy(400, 500, 50, 50, false));
		enemy1.add(new Enemy(550, 550, 50, 50, false));
		chest1.add(new Chest(50, 100, 80, 60));
		chest1.add(new Chest(50, 300, 80, 60));
		
		//room 2
		gate = new Gate(375, 200, 150, 250);
		
		//room3 
		chest3.add(new Chest(400, 300, 80, 60));
		obs3.add(new Obstacle(200, 50, 50, 50, 0));
		obs3.add(new Obstacle(300, 200, 50, 50, 0));
		obs3.add(new Obstacle(500, 400, 50, 50, 0));
		obs3.add(new Obstacle(150, 450, 50, 50, 0));
		obs3.add(new Obstacle(800, 200, 50, 50, 0));
		obs3.add(new Obstacle(400, 200, 50, 50, 0));
		obs3.add(new Obstacle(600, 500, 50, 50, 0));
		obs3.add(new Obstacle(200, 275, 50, 50, 0));
		obs3.add(new Obstacle(550, 300, 50, 50, 0));
		obs3.add(new Obstacle(250, 500, 50, 50, 0));
		obs3.add(new Obstacle(325, 400, 50, 50, 0));
		obs3.add(new Obstacle(400, 500, 50, 50, 0));
		obs3.add(new Obstacle(650, 300, 50, 50, 0));
		
		// room 4
		chest4.add(new Chest(750, 550, 80, 60));	
		
		//room 5
		chest5.add(new Chest(750, 550, 80, 60));
		chest5.add(new Chest(60, 100, 80, 60));
		obs5.add(new Obstacle(850, 450, 50, 50, 1));
		obs5.add(new Obstacle(800, 450, 50, 50, 1));
		obs5.add(new Obstacle(750, 450, 50, 50, 1));
		obs5.add(new Obstacle(700, 450, 50, 50, 1));
		obs5.add(new Obstacle(650, 450, 50, 50, 1));
		obs5.add(new Obstacle(650, 450, 50, 50, 1));
		obs5.add(new Obstacle(650, 500, 50, 50, 1));
		obs5.add(new Obstacle(650, 550, 50, 50, 1));
		obs5.add(new Obstacle(650, 600, 50, 50, 1));
		obs5.add(new Obstacle(650, 650, 50, 50, 1));
		obs5.add(new Obstacle(650, 450, 50, 50, 1));
		obs5.add(new Obstacle(650, 500, 50, 50, 1));
		obs5.add(new Obstacle(650, 550, 50, 50, 1));
		obs5.add(new Obstacle(650, 600, 50, 50, 1));
		obs5.add(new Obstacle(700, 650, 50, 50, 1));
		obs5.add(new Obstacle(750, 650, 50, 50, 1));
		obs5.add(new Obstacle(800, 650, 50, 50, 1));
		obs5.add(new Obstacle(850, 650, 50, 50, 1));
		enemy5.add(new Enemy(400, 500, 50, 50, false));
		enemy5.add(new Enemy(750, 300, 50, 50, true));
		

		
		obs4.add(new Obstacle(600, 450, 50, 50, 1));
		obs4.add(new Obstacle(300, 450, 50, 50, 1));
		obs4.add(new Obstacle(300, 450, 50, 50, 1));
		obs4.add(new Obstacle(200, 300, 50, 50, 1));
		obs4.add(new Obstacle(500, 280, 50, 50, 1));
		obs4.add(new Obstacle(500, 200, 50, 50, 1));
		obs4.add(new Obstacle(270, 450, 50, 50, 1));
		obs4.add(new Obstacle(600, 450, 50, 50, 1));
		obs4.add(new Obstacle(100, 300, 50, 50, 1));
		obs4.add(new Obstacle(40, 450, 50, 50, 1));
		enemy4.add(new Enemy(500, 500, 50, 50, true));
		enemy4.add(new Enemy(700, 200, 50, 50, false));
		enemy4.add(new Enemy(300, 100, 50, 50, true));
		enemy4.add(new Enemy(400, 300, 50, 50, false));
		enemy4.add(new Enemy(600, 700, 50, 50, false));
		obs4.add(new Obstacle(500, 200, 50, 50, 1));

		//room4
		
		//room 6
		obs6.add(new Obstacle(0, 450, 50, 50, 1));
		obs6.add(new Obstacle(50, 450, 50, 50, 1));
		obs6.add(new Obstacle(100, 450, 50, 50, 1));
		obs6.add(new Obstacle(0, 650, 50, 50, 1));
		obs6.add(new Obstacle(50, 650, 50, 50, 1));
		obs6.add(new Obstacle(100, 650, 50, 50, 1));
		obs6.add(new Obstacle(150, 450, 50, 50, 1));
		obs6.add(new Obstacle(150, 650, 50, 50, 1));
		obs6.add(new Obstacle(150, 500, 50, 50, 0));
		obs6.add(new Obstacle(0, 600, 50, 50, 0));
		obs6.add(new Obstacle(200, 650, 50, 50, 1));
		obs6.add(new Obstacle(250, 650, 50, 50, 1));
		obs6.add(new Obstacle(300, 600, 50, 50, 1));
		obs6.add(new Obstacle(350, 550, 50, 50, 1));
		obs6.add(new Obstacle(400, 500, 50, 50, 1));
		obs6.add(new Obstacle(200, 350, 50, 50, 1));
		obs6.add(new Obstacle(150, 400, 50, 50, 1));
		obs6.add(new Obstacle(250, 300, 50, 50, 1));
		obs6.add(new Obstacle(300, 250, 50, 50, 1));
		obs6.add(new Obstacle(350, 200, 50, 50, 1));
		obs6.add(new Obstacle(400, 150, 50, 50, 1));

		
		//room 6
		obs6.add(new Obstacle(350, 450, 50, 50, 1));
		obs6.add(new Obstacle(100, 450, 50, 50, 0));
		obs6.add(new Obstacle(300, 450, 50, 50, 1));
		obs6.add(new Obstacle(200, 270, 50, 50, 0));
		obs6.add(new Obstacle(600, 280, 50, 50, 1));
		obs6.add(new Obstacle(500, 200, 50, 50, 0));
		obs6.add(new Obstacle(270, 450, 50, 50, 1));
		obs6.add(new Obstacle(500, 350, 50, 50, 0));
		obs6.add(new Obstacle(100, 300, 50, 50, 1));
		obs6.add(new Obstacle(40, 500, 50, 50, 1));
		enemy6.add(new Enemy(500, 500, 50, 50, true));
		enemy6.add(new Enemy(700, 200, 50, 50, false));
		enemy6.add(new Enemy(300, 100, 50, 50, true));
		enemy6.add(new Enemy(400, 300, 50, 50, false));
		enemy6.add(new Enemy(600, 700, 50, 50, false));
		
		//room 7
		obs7.add(new Obstacle(350, 0, 50, 50, 1));
		obs7.add(new Obstacle(350, 50, 50, 50, 1));
		obs7.add(new Obstacle(350, 100, 50, 50, 1));
		obs7.add(new Obstacle(350, 150, 50, 50, 1));
		obs7.add(new Obstacle(350, 200, 50, 50, 1));
		obs7.add(new Obstacle(350, 250, 50, 50, 1));
		obs7.add(new Obstacle(350, 300, 50, 50, 1));
		obs7.add(new Obstacle(350, 350, 50, 50, 1));
		obs7.add(new Obstacle(350, 400, 50, 50, 1));
		obs7.add(new Obstacle(350, 450, 50, 50, 1));
		obs7.add(new Obstacle(350, 500, 50, 50, 1));
		obs7.add(new Obstacle(350, 550, 50, 50, 1));
		obs7.add(new Obstacle(350, 600, 50, 50, 1));
		obs7.add(new Obstacle(350, 650, 50, 50, 0));
		obs7.add(new Obstacle(450, 0, 50, 50, 1));
		obs7.add(new Obstacle(450, 50, 50, 50, 1));
		obs7.add(new Obstacle(450, 100, 50, 50, 1));
		obs7.add(new Obstacle(450, 150, 50, 50, 1));
		obs7.add(new Obstacle(450, 200, 50, 50, 1));
		obs7.add(new Obstacle(450, 250, 50, 50, 1));
		obs7.add(new Obstacle(450, 300, 50, 50, 1));
		obs7.add(new Obstacle(450, 350, 50, 50, 1));
		obs7.add(new Obstacle(450, 400, 50, 50, 1));
		obs7.add(new Obstacle(450, 450, 50, 50, 1));
		obs7.add(new Obstacle(450, 500, 50, 50, 1));
		obs7.add(new Obstacle(450, 550, 50, 50, 1));
		
		//room 8
		enemy8.add(new Enemy(100, 500, 50, 50, true));
		enemy8.add(new Enemy(700, 200, 50, 50, false));
		enemy8.add(new Enemy(370, 100, 50, 50, true));
		enemy8.add(new Enemy(400, 300, 50, 50, false));
		enemy8.add(new Enemy(600, 700, 50, 50, false));
		enemy8.add(new Enemy(550, 500, 50, 50, true));
		enemy8.add(new Enemy(30, 200, 50, 50, false));
		enemy8.add(new Enemy(300, 509, 50, 50, true));
		enemy8.add(new Enemy(80, 300, 50, 50, false));
		enemy8.add(new Enemy(500, 700, 50, 50, false));
		
		//room 9 
		enemy9.add(new Enemy(500, 500, 50, 50, true));
		enemy9.add(new Enemy(700, 200, 50, 50, false));
		enemy9.add(new Enemy(300, 100, 50, 50, true));
		enemy9.add(new Enemy(400, 300, 50, 50, false));
		enemy9.add(new Enemy(600, 580, 50, 50, false));
		enemy9.add(new Enemy(500, 500, 50, 50, true));
		enemy9.add(new Enemy(400, 100, 50, 50, false));
		enemy9.add(new Enemy(300, 100, 50, 50, true));
		enemy9.add(new Enemy(478, 670, 50, 50, false));
		enemy9.add(new Enemy(437, 700, 50, 50, false));
		
	}
	
	/**
	 * Sets up the map based on the difficulty
	 * @param diff the difficulty selected by the user
	 */
	public void setMapDiff(boolean diff) {
		if(!diff) {
			enemy6.add(new Enemy(600, 400, 50, 50, false));
			enemy6.add(new Enemy(400, 200, 50, 50, false));
			enemy6.add(new Enemy(500, 500, 50, 50, false));
			enemy6.add(new Enemy(300, 300, 50, 50, true));
		}
	}
	
	/**
	 * Fetches the obstacle that corresponds to the current room
	 * @param roomNum number of room that the player is currently in
	 * @return list of obstacles
	 */
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
	
	/**
	 * Fetches the current enemy corresponding to the room
	 * @param roomNum number of room that the player is currently in
	 * @return list of enemies
	 */
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
	
	/**
	 * Fetches the current chest corresponding to the room
	 * @param roomNum number of room that the player is currently in
	 * @return list of chests
	 */
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
	public Sprite getCurrentGate(int roomNum) {
		if(roomNum == 2) return gate;
		return null;
	}
	
	
}
