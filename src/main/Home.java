package main;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.MainFrame;

public class Home extends MainFrame{
	private JPanel homePanel;
	
	public Home() {
		this.setHomePanel(new JPanel());
		JLabel homeLabel = new JLabel("Home label");
		this.getHomePanel().setLayout(new BorderLayout());
		this.getHomePanel().add(homeLabel, BorderLayout.NORTH);
	}

	public JPanel getHomePanel() {
		return homePanel;
	}

	public void setHomePanel(JPanel homePanel) {
		this.homePanel = homePanel;
	}
}
