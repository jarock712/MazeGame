import java.awt.Graphics;

public class MushroomManager{
	Mushroom mush;

public MushroomManager(Mushroom mush) {
	this.mush = mush;
}
public void update() {
	
}
public void draw(Graphics g) {
	mush.draw(g);
}
}