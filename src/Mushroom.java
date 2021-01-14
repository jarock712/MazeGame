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
		speed = 5;
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
		if (up && y > 50) {
			up();
		}
		if (down && y < 925) {
			down();
		}
		if (left && x > 25) {
			left();
		}
		if (right && x < 950) {
			right();
		}
		super.update();
		if (image2.getRGB(x+5, y+5) == Color.BLACK.getRGB()) {
			MazePanel.moves = false;
		}else {
			MazePanel.moves = true;
		}
	}
	public void isActive(boolean b) {
		// TODO Auto-generated method stub
		this.isActive = b;
	}
}