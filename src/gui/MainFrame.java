package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import main.Home;
import main.Login;
import main.Register;
import main.UserDetail;
import main.UserInfo;

public class MainFrame extends JFrame {
	private static JFrame mainFrame;
	private static String prevPanel = null;
	private static UserInfo userInfo = null;
	public static Login loginPanel = new Login();
	public MainFrame() {
		setTitle("Airline Booking System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
	}
	
	public void changePanel(JPanel panel, boolean showMenu, String prevPage) {
		System.out.println(prevPage);
		MainFrame.setPrevPanel(prevPage);
		if (showMenu) {
			JMenuBar menuBar = new JMenuBar();
			JButton backButton = new JButton("戻る");
			JMenu user = new JMenu("ユーザー");
	        menuBar.add(backButton);
	        menuBar.add(user);
	        JMenuItem logoutButton = new JMenuItem("ログアウト");
	        JMenuItem userDetails = new JMenuItem("情報");
	        logoutButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ev) {
	            	MainFrame.setUserInfo(null);
	            	MainFrame.getMainFrame().setJMenuBar(null);
	            	changeFunction(MainFrame.loginPanel.getLoginPanel());
	            	
	            }
	        });
	        userDetails.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ev) {
	            	UserDetail userDetail = new UserDetail();
	            	changeFunction(userDetail.getUserDetail());
	            }
	        });
	        backButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ev) {
	            	System.out.println(MainFrame.getPrevPanel());
	            	switch (MainFrame.getPrevPanel()) {
	            	case "register":
	            		Register register = new Register();
	            		changeFunction(register.getRegisterPage());
	            		break;
	            	case "home":
	            		Home home = new Home();
	            		changeFunction(home.getHomePanel());
	            		break;
	            	}
	            }
	        });
	        user.add(userDetails);
	        user.add(logoutButton);
	        MainFrame.getMainFrame().setJMenuBar(menuBar);
	        System.out.println(MainFrame.getUserInfo().toString());
		}
		changeFunction(panel);
	}
	
	public void changeFunction(JPanel panel) {
		MainFrame.getMainFrame().setContentPane(panel);
		MainFrame.getMainFrame().revalidate();
		MainFrame.getMainFrame().repaint();
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		MainFrame.setMainFrame(frame);
		MainFrame.getMainFrame().setVisible(true);
		MainFrame.setPrevPanel(null);
		frame.changePanel(MainFrame.loginPanel.getLoginPanel(), false, "home");
	}

	public static JFrame getMainFrame() {
		return mainFrame;
	}

	public static void setMainFrame(JFrame mainFrame) {
		MainFrame.mainFrame = mainFrame;
	}

	public static String getPrevPanel() {
		return prevPanel;
	}

	public static void setPrevPanel(String prevPanel) {
		MainFrame.prevPanel = prevPanel;
	}

	public static UserInfo getUserInfo() {
		return userInfo;
	}

	public static void setUserInfo(UserInfo userInfo) {
		MainFrame.userInfo = userInfo;
	}

}
