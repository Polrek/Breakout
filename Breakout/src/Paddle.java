import java.awt.Graphics;

public class Paddle extends Sprite {

	private int xVelocity;
	
	public Paddle() {
		setWidth(Settings.PADDLE_WIDTH); // Set width to Settings.PADDLE_WIDTH
		setHeight(Settings.PADDLE_HEIGHT); // Set width to Settings.PADDLE_HEIGHT
		resetPosition(); // Call resetPosition
	}
	
	public void resetPosition() {
		setX(Settings.INITIAL_PADDLE_X); // Set initial position x  (use INITIAL_PADDLE_X)
		setY(Settings.INITIAL_PADDLE_Y); // Set initial position y (use INITIAL_PADDLE_Y)
	}
	
	public void update() {
		x += xVelocity;
		
		if(x <= 0) { // Prevent the paddle from moving outside (left) of the screen
			x = 0; // Set x to 0 so it does not leave the screen
		}
		// Prevent the paddle from moving outside (right) of the screen
		
		if(x >= Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH-15) { //-15 because this is a minimum viable product and it's good enough
			x = Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH-15; // Set x to the right edge of the screen (see the above if condition)
		} //note for future dev: You probably need to pass the JPanel's width and height into the paddle update() method to make this better
	}
	
	public void paint(Graphics g) { //paints the paddle on the screen
		g.fillRect(x, y, Settings.PADDLE_WIDTH, Settings.PADDLE_HEIGHT);
	}
	
	public void setXVelocity(int vel) {
		this.xVelocity = vel;//  Sets the x velocity
	}
}
