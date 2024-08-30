package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Login;

public class MainFrame extends JFrame {
	private static JFrame mainFrame;
	public MainFrame() {
		setTitle("Airline Booking System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
	}
	
	public void changePanel(JPanel panel) {
		MainFrame.getMainFrame().setContentPane(panel);;
		MainFrame.getMainFrame().revalidate();
		MainFrame.getMainFrame().repaint();
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		MainFrame.setMainFrame(frame);
		MainFrame.getMainFrame().setVisible(true);
		Login homePanel = new Login();
		frame.changePanel(homePanel.getLoginPanel());
	}

	public static JFrame getMainFrame() {
		return mainFrame;
	}

	public static void setMainFrame(JFrame mainFrame) {
		MainFrame.mainFrame = mainFrame;
	}
}
