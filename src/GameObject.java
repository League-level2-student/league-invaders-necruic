
public class GameObject {
int x;
int y;
int width;
int height;
int speed;
boolean isActive;

public GameObject(int x, int y, int width, int height) {
	speed = 0;
	isActive = true;
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
}
public void update() {
	
}
}
