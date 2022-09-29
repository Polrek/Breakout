import java.awt.Color;

import javax.swing.JFrame;

public class Breakout extends JFrame{
	
	static final long serialVersionUID = 1L;
	
	private BreakoutPanel panel;
	
	public Breakout() {
		setSize(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT); //Set the size of the screen
		setTitle(Settings.WINDOW_NAME); //Set the title
		setBackground(Color.WHITE);// Set the background colour to white
		setResizable(false);// Set resizable to false
        setDefaultCloseOperation(EXIT_ON_CLOSE); //sets the default close operation (what happens to the program when you press X)
        panel = new BreakoutPanel(this); //initialises the panel variable
        add(panel);
        setVisible(true); //Set visible to true (important if you want to be able to see the game when playing it)
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 new Breakout();	
	         }
		});

	}
}
