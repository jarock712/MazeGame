import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
public class MazePanel extends JPanel implements ActionListener, KeyListener, MouseListener{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    static final int BLACK = 0;
    int currentState = MENU;
    Font titleFont = new Font("Times New Roman", Font.BOLD, 48);
    Font titleFont2 = new Font("Times New Roman", Font.BOLD, 24);
    Font font1 = new Font("Quicksand", Font.BOLD, 24);
    Timer frameDraw;
    Mushroom mush = new Mushroom(35, 410, 25, 25);
    MushroomManager manager = new MushroomManager(mush);
    public MazePanel() {
    	if (needImage) {
		    loadImage ("maze.png");
		    Mushroom.image2 = image;
		}
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	}
    public void updateMenuState() {
    	
    }
    public void updateGameState() {
    	mush.update();
    	manager.update();
    	if (mush.isActive == false) {
			currentState = END;
		}
    }
    public void updateEndState() {
    	
    }
    
    public void drawMenuState(Graphics g) {
    	g.setColor(Color.YELLOW);
    	g.fillRect(0, 0, MazeRunner.WIDTH, MazeRunner.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.BLACK);
    	g.drawString("Maze Game", 60, 100);
    	g.setFont(titleFont2);
    	g.drawString("Press ENTER to start!", 150, 350);
    	g.setFont(titleFont2);
    	g.drawString("Press SHIFT for instructions.", 135, 450);
    }
    public void drawGameState(Graphics g) {
    	g.setColor(Color.WHITE);
    	g.fillRect(0, 0, MazeRunner.WIDTH, MazeRunner.HEIGHT);
    	g.drawImage(image, 0, 0, null);
    	manager.draw(g);
    }
    public void drawEndState(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, MazeRunner.WIDTH, MazeRunner.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.RED);
    	g.drawString("GAME OVER", 100, 100);
    	g.setFont(titleFont2);
    	g.setColor(Color.RED);
    	g.drawString("Press ENTER to restart!", 100, 350);
    }
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}
	public static boolean moves = true;
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_SHIFT) {
			JOptionPane.showMessageDialog(null, "Use the ARROW KEYS to maneuver to the end of the maze!");
			JOptionPane.showMessageDialog(null, "If you get stuck you can press ENTER 2 TIMES to restart!");
		}
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			startGame();
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_UP){
			mush.up();
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_DOWN){
		    mush.down();
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_LEFT){
		    mush.left();
		}
		if (moves == true && e.getKeyCode()==KeyEvent.VK_RIGHT){
		    mush.right();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
	public void startGame() {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(image.getRGB(e.getX(), e.getY()));
		System.out.println(e.getX() + " " + e.getY());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}