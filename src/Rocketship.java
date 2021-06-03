import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 7;

	}
	
	public void move() {
		super.update();
		if (down) {
			y += speed;
		}
		if (up) {
			y -= speed;
		}
		if (right) {
			x += speed;
		}
		if (left) {
			x -= speed;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}

}
