import java.awt.Rectangle;

public class MazeObject {
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	public static int level = 1;
	boolean isActive = true;
	Rectangle collisionBox = new Rectangle();
public MazeObject(int x, int y, int width, int height) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.collisionBox = new Rectangle(x, y, width, height);
}
public void update() {
	collisionBox.setBounds(x, y, width, height);
}
}