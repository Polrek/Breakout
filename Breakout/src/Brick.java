import java.awt.Graphics;

public class Brick extends Sprite {
	
	private boolean broken = false;
	
	//brick constructor
	public Brick(int x, int y) {
		this.setX(x);// Set x using the parameter
		this.setY(y);// Set y using the parameter
		setWidth(Settings.BRICK_WIDTH); //  Set the width of the brick using Settings.BRICK_WIDTH
		setHeight(Settings.BRICK_HEIGHT);//  Set the height of the brick using Settings.BRICK_HEIGHT
	}

	public boolean isBroken() {
		return broken;	// Return broken if the brick is broken
	}
	public void setBroken(boolean b) {
		broken = b;// Set the broken variable using the parameter given
	}
	
	public void paint(Graphics g) {
		if(!broken) { //if the brick is not broken, draw the brick on the screen. if the brick is broken, don't draw the brick
			g.fillRect(x, y, Settings.BRICK_WIDTH, Settings.BRICK_HEIGHT);
		}
	}
}
