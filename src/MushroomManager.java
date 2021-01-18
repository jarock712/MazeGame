import java.awt.Graphics;

public class MushroomManager{
	Mushroom mush;
	Star end;

public MushroomManager(Mushroom mush, Star end) {
	this.mush = mush;
	this.end = end;
}
public void update() {
	if (mush.collisionBox.intersects(end.collisionBox)) {
		MazePanel.currentState = MazePanel.END;
	}
}
public void draw(Graphics g) {
	mush.draw(g);
	end.draw(g);
}
}