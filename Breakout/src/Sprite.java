import java.awt.Rectangle;

public class Sprite {
	
	protected int x,y,width,height;
	
	// Note: This should only set a single value, they can be done in a single statement
	public void setX(int x) {
		this.x = x; // TODO Check
	}
	public void setY(int y) { 
		this.y = y;// TODO Check
	}
	public void setWidth(int width) { 
		this.width = width; // TODO Check
	}
	public void setHeight(int height) { 
		this.height = height; // TODO Check
	}
	
	public int getX() { 
		return x;	// TODO: Check: Return correct value
	}
	public int getY() { 
		return y;	// TODO: Check: Return correct value
	}
	public int getWidth() { 
		return width;	// TODO: Check: Return correct value
	}
	public int getHeight() { 
		return height;	// TODO: Return correct value
	}
	
	Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
}
