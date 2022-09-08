import java.awt.Graphics;

public class Brick extends Sprite {
	
	private boolean broken = false;
	
	public Brick(int x, int y) {
		// TODO: Set x using the parameter
		// TODO: Set y using the parameter
		setWidth(Settings.BALL_WIDTH); // TODO: CHECK THIS: Set the width of the brick using Settings.BRICK_WIDTH
		setHeight(Settings.BALL_HEIGHT);// TODO: CHECK THIS: Set the height of the brick using Settings.BRICK_HEIGHT
	}

	public boolean isBroken() {
		return false;	// TODO: Return the correct variable
	}
	public void setBroken(boolean b) {
		broken = true;// TODO: Check this: Set the broken variable using the parameter given
	}
	
	public void paint(Graphics g) {
		if(!broken) {
			g.fillRect(x, y, Settings.BRICK_WIDTH, Settings.BRICK_HEIGHT);
		}
	}
}
