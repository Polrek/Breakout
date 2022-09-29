import java.awt.Rectangle;

public class Sprite { //ball and paddle classes inherit this one
	
	protected int x,y,width,height;
	
	// Note: This should only set a single value, they can be done in a single statement
	public void setX(int x) {
		this.x = x; 
	}
	public void setY(int y) { 
		this.y = y;
	}
	public void setWidth(int width) { 
		this.width = width; //sets the width of the (ball or paddle)
	}
	public void setHeight(int height) { 
		this.height = height; //sets the height of the (ball or paddle)
	}
	
	public int getX() { 
		return x;	// Return correct value
	}
	public int getY() { 
		return y;	//Return correct value
	}
	public int getWidth() { 
		return width;	// Return correct value
	}
	public int getHeight() { 
		return height;	//Return correct value
	}
	
	Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
}
