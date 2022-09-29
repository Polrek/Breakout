import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BreakoutPanel extends JPanel implements ActionListener, KeyListener {
	
	static final long serialVersionUID = 2L;

	private boolean gameRunning = true;
	private int livesLeft = 3;
	private String screenMessage = "";
	private Ball ball;
	private Paddle paddle;
	private Brick bricks[];
	
	public BreakoutPanel(Breakout game) {
		
		addKeyListener(this); //makes the key press instructions below work
		setFocusable(true); //the window is set to focusable
		
		Timer timer = new Timer(5, this);
		timer.start(); //starts the timer which means it can start sending key press events to the listener
		
		ball = new Ball();//  Create a new ball object and assign it to the appropriate variable
		paddle = new Paddle();// Create a new paddle object and assign it to the appropriate variable
		bricks = new Brick[Settings.TOTAL_BRICKS];//  Create a new bricks array (Use Settings.TOTAL_BRICKS)
		createBricks();// Call the createBricks() method
	}
	
	private void createBricks() {
		int counter = 0;
		int x_space = 0;
		int y_space = 0;
		for(int x = 0; x < 4; x++) { //loops through to create 4 columns of bricks
			for(int y = 0; y < 5; y++) { //loops through to create 5 rows of bricks
				bricks[counter] = new Brick((x * Settings.BRICK_WIDTH) + Settings.BRICK_HORI_PADDING + x_space, (y * Settings.BRICK_HEIGHT) + Settings.BRICK_VERT_PADDING + y_space);
				counter++;
				y_space++;
			}
			x_space++;
			y_space = 0;
		}
	}
	
	private void paintBricks(Graphics g) {
		for (int i=0;i<bricks.length;i++) {
			bricks[i].paint(g);// Loop through the bricks and call the paint() method. This draws the bricks on the screen
		}
	}
	
	private void update() {
		if(gameRunning) {
			ball.update(); // Update the ball
			paddle.update();// Update the paddle
			collisions();
			repaint();
		}
	}
	
	private void gameOver() {
		screenMessage = "Game over!"; //Set screen message for loss condition
		stopGame();
	}
	
	private void gameWon() {
		screenMessage = "You won!"; //Set screen message for win condition
		stopGame();
	}
	
	private void stopGame() {
		gameRunning = false;
	}
	
	private void collisions() {
		// Check for loss (ball goes all the way to the bottom, below the paddle and collides with the bottom)
		if(ball.y > 450) {
			livesLeft--;
			if(livesLeft <= 0) { // Game over if no lives left
				gameOver();
				return;
			} else {
				ball.resetPosition(); // still have lives left. reset the ball to the reset position
				ball.setYVelocity(-1); // make the ball go the opposite way to what it was doing (it was going down, so send it back up)
			}
		}
		
		// Check for win
		boolean bricksLeft = false; 
		for(int i = 0; i < bricks.length; i++) {
			// Check if there are any bricks left
			if(!bricks[i].isBroken()) {
				// Brick was found, close loop
				bricksLeft = true;
				break;
			}
		}
		if(!bricksLeft) { //if all the bricks are gone
			gameWon(); //call gameWon (you won!)
			return;
		}
		
		// Check collisions
		if(ball.getRectangle().intersects(paddle.getRectangle())) {
			// Simplified touching of paddle
			// Proper game would change angle of ball depending on where it hit the paddle
			ball.setYVelocity(-1);
		}
		//checks for the ball intersecting a brick
		for(int i = 0; i < bricks.length; i++) {
			if (ball.getRectangle().intersects(bricks[i].getRectangle())) {
				int ballLeft = (int) ball.getRectangle().getMinX();
	            int ballHeight = (int) ball.getRectangle().getHeight();
	            int ballWidth = (int) ball.getRectangle().getWidth();
	            int ballTop = (int) ball.getRectangle().getMinY();

	            Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
	            Point pointLeft = new Point(ballLeft - 1, ballTop);
	            Point pointTop = new Point(ballLeft, ballTop - 1);
	            Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);
	             	
	            //if the ball intersects the right side of the brick, make the ball bounce left. 
	            //if the ball intersects the left side of the brick, make the ball bounce right
	            if (!bricks[i].isBroken()) { 
	                if (bricks[i].getRectangle().contains(pointRight)) {
	                    ball.setXVelocity(-1);
	                } else if (bricks[i].getRectangle().contains(pointLeft)) {
	                    ball.setXVelocity(1);
	                }
	           //if the ball intersects the top of a brick, make it bounce up
	           //if the ball intersects the bottom of a brick, make it bounce down
	                if (bricks[i].getRectangle().contains(pointTop)) {
	                    ball.setYVelocity(1);
	                } else if (bricks[i].getRectangle().contains(pointBottom)) {
	                    ball.setYVelocity(-1);
	                }
	                bricks[i].setBroken(true); //set broken to true for the particular brick that was intersected.
	            }
			}
		}
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ball.paint(g);
        paddle.paint(g);
        paintBricks(g);
        
        // Draw lives left
        // Draw lives left in the top left hand corner
        g.setFont(new Font("Arial", Font.BOLD, 15));
        if (livesLeft > 1 || livesLeft == 0) {
        	g.drawString(livesLeft+" lives remaining", (Settings.LIVES_POSITION_X), (Settings.LIVES_POSITION_Y));
        }
        else {
        	g.drawString(livesLeft+" life remaining", (Settings.LIVES_POSITION_X), (Settings.LIVES_POSITION_Y));
        }
        
        // Draw screen message
        if(screenMessage != null) {
        	g.setFont(new Font("Arial", Font.BOLD, 18));
        	int messageWidth = g.getFontMetrics().stringWidth(screenMessage);
        	g.drawString(screenMessage, (Settings.WINDOW_WIDTH / 2) - (messageWidth / 2), Settings.MESSAGE_POSITION);
        }
    }

	@Override
	public void keyPressed(KeyEvent e) { //set the action when left button on kb is pressed
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddle.setXVelocity(-1);//  Set the velocity of the paddle depending on whether the player is pressing left or right
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { //set the action when right button on kb is pressed
			paddle.setXVelocity(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { //sets the action performed when the left or right button is released
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle.setXVelocity(0);//  Set the velocity of the paddle after the player has released the keys
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) { //not used
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update(); //calls the update method for the paddle when the key action is performed
	}

}
