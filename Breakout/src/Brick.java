import java.awt.Graphics;

public class Brick extends Sprite {
	
	private boolean broken = false;
	
	public Brick(int x, int y) {
		this.setX(x);// TODO: Set x using the parameter
		this.setY(y);// TODO: Set y using the parameter
		setWidth(Settings.BRICK_WIDTH); // TODO: CHECK THIS: Set the width of the brick using Settings.BRICK_WIDTH
		setHeight(Settings.BRICK_HEIGHT);// TODO: CHECK THIS: Set the height of the brick using Settings.BRICK_HEIGHT
	}

	public boolean isBroken() {
		return false;	// TODO: Check this: Return the correct variable
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
