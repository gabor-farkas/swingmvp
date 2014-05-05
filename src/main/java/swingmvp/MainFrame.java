package swingmvp;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		new Application(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

}
