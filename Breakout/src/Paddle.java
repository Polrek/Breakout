import java.awt.Graphics;

public class Paddle extends Sprite {

	private int xVelocity;
	
	public Paddle() {
		setWidth(Settings.PADDLE_WIDTH); // TODO: Set width to Settings.PADDLE_WIDTH
		setHeight(Settings.PADDLE_HEIGHT); // TODO: Set width to Settings.PADDLE_HEIGHT
		resetPosition(); // TODO: Call resetPosition
	}
	
	public void resetPosition() {
		setX(Settings.INITIAL_PADDLE_X); // Set initial position x  (use INITIAL_PADDLE_X)
		setY(Settings.INITIAL_PADDLE_Y); // Set initial position  y (use INITIAL_PADDLE_Y)
	}
	
	public void update() {
		x += xVelocity;
		// TODO: Check: Prevent the paddle from moving outside (left) of the screen
		if(x <= 0) {
			x = 0;// TODO: CHECK THIS: Set x to 0 so it does not leave the screen
		}
		// TODO: Check: Prevent the paddle from moving outside (right) of the screen
		
		if(x >= Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH) {
			x = Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH; // TODO: CHECK THIS: Set x to the right edge of the screen (see the above if condition)
		}
	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, Settings.PADDLE_WIDTH, Settings.PADDLE_HEIGHT);
	}
	
	public void setXVelocity(int vel) {
		this.x = xVelocity;// TODO: Check: Set x velocity
	}
}
