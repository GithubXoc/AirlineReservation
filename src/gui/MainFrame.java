package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Login;
import main.UserInfo;

public class MainFrame extends JFrame {
	private static JFrame mainFrame;
	private static JPanel prevPanel;
	private static UserInfo userInfo = null;
	public static Login loginPanel = new Login();
	public MainFrame() {
		setTitle("Airline Booking System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
	}
	
	public void changePanel(JPanel panel, boolean showMenu, Object prevPage) {
		System.out.println(prevPage);
//		if (prevPage!=null) {
//			System.out.println(((PanelInterface) prevPage).getPanel());
//		}
		if (showMenu) {
			JMenuBar menuBar = new JMenuBar();
			JButton backButton = new JButton("back");
			JMenu menu = new JMenu("Menu");
			menu.setHorizontalTextPosition(SwingConstants.CENTER);
	        menu.setVerticalTextPosition(SwingConstants.BOTTOM);
	        menuBar.add(backButton);
	        menuBar.add(menu);
	        JMenuItem item = new JMenuItem("Test Item");
	        menu.add(item);
	        menu.add(backButton);
	        MainFrame.getMainFrame().setJMenuBar(menuBar);
//			JPanel headerPanel = new JPanel();
//			UserInfo userInfo = new UserInfo();
//			JPanel userInfoPanel = userInfo.getUserInfoPanel();
//			JLabel header = new JLabel("header");
//			headerPanel.add(header);
//			panel.add(userInfoPanel, BorderLayout.NORTH);
//			panel.add(headerPanel, BorderLayout.NORTH);
		}
		MainFrame.getMainFrame().setContentPane(panel);
		MainFrame.getMainFrame().revalidate();
		MainFrame.getMainFrame().repaint();
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		MainFrame.setMainFrame(frame);
		MainFrame.getMainFrame().setVisible(true);
		MainFrame.setPrevPanel(null);
		frame.changePanel(MainFrame.loginPanel.getLoginPanel(), false, null);
	}

	public static JFrame getMainFrame() {
		return mainFrame;
	}

	public static void setMainFrame(JFrame mainFrame) {
		MainFrame.mainFrame = mainFrame;
	}

	public static JPanel getPrevPanel() {
		return prevPanel;
	}

	public static void setPrevPanel(JPanel prevPanel) {
		MainFrame.prevPanel = prevPanel;
	}

	public static UserInfo getUserInfo() {
		return userInfo;
	}

	public static void setUserInfo(UserInfo userInfo) {
		MainFrame.userInfo = userInfo;
	}

}
