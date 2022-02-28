package hstawgame;

import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import hstawgame.screens.StartScreen;
import hstawgame.screens.Screen;


public class ApplicationMain extends JFrame implements KeyListener {
	private static final long serialVersionUID = 8789768;
	
	private AsciiPanel terminal;
	private Screen screen;
	
	public ApplicationMain() {
		super();
		terminal = new AsciiPanel();
		add(terminal);
		pack();
		screen = new StartScreen();
		addKeyListener(this);
		repaint();
			}
	
	public void repaint() {
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}
	
	public void keyPressed(KeyEvent e) {
		screen = screen.respondToUserInput(e);
		repaint();
	}
	
	public void keyReleased(KeyEvent e) { }
	
	public void keyTypes(KeyEvent e) { }
	
	public static void main(String [] args) {
		ApplicationMain app = new ApplicationMain();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}


}