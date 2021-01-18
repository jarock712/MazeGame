import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Mushroom extends MazeObject {
	public static BufferedImage image;
	public static BufferedImage image2;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	
	public Mushroom(int x, int y, int width, int height){
		super(x, y, width, height);
		speed = 2;
		if (needImage) {
		    loadImage ("mushroom.png");
		}
	}
	public void draw(Graphics g) {
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
	}
	public void up() {
        y-=speed;
    }
	public void down() {
        y+=speed;
    }
	public void left() {
        x-=speed;
    }
	public void right() {
        x+=speed;
    }
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	public void update() {
		if (image2.getRGB(x, y-7) == Color.black.getRGB()) {
			up = false;
		}
		else if (up && y > 25 && image2.getRGB(x, y-7) != Color.black.getRGB()) {
			up();
		}
		if (image2.getRGB(x, y+25) == Color.black.getRGB()) {
			down = false;
		}
		else if (down && y < 925 && image2.getRGB(x, y+25) != Color.black.getRGB()) {
			down();
		}
		if (image2.getRGB(x-3, y) == Color.black.getRGB()) {
			left = false;
		}
		else if (left && x > 25 && image2.getRGB(x-3, y) != Color.black.getRGB()) {
			left();
		}
		if (image2.getRGB(x+30, y) == Color.black.getRGB()) {
			right = false;
		}
		else if (right && x < 950 && image2.getRGB(x+30, y) != Color.black.getRGB()) {
			right();
		}
		super.update();
		//if (image2.getRGB(x+5, y+5) == Color.BLACK.getRGB()) {
			//MazePanel.moves = false;
		//}else {
			//MazePanel.moves = true;
		//}
	}
	public void isActive(boolean b) {
		// TODO Auto-generated method stub
		this.isActive = b;
	}
}