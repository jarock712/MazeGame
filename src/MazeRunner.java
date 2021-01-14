import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MazeRunner {
	JFrame mazeFrame = new JFrame();
	public static final int HEIGHT = 600;
	public static final int WIDTH = 600;
	MazePanel gamePanel = new MazePanel();
	public void setup() {
		mazeFrame.add(gamePanel);
		mazeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mazeFrame.setVisible(true);
		mazeFrame.setSize(WIDTH, HEIGHT);
		mazeFrame.addKeyListener(gamePanel);
		mazeFrame.addMouseListener(gamePanel);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				MazeRunner maze = new MazeRunner();
				maze.setup();
			}
		});
	}
}