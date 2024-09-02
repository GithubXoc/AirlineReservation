package main;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.MainFrame;
import interfaces.PanelInterface;

public class Home extends MainFrame implements PanelInterface{
	private JPanel homePanel;
	
	public Home() {
		this.setHomePanel(new JPanel());
		JLabel homeLabel = new JLabel("Home label");
//		this.getHomePanel().setLayout(new BorderLayout());
		this.getHomePanel().add(homeLabel, BorderLayout.NORTH);
	}
	
	public JPanel getPanel() {
		return this.getHomePanel();
	}

	public JPanel getHomePanel() {
		return homePanel;
	}

	public void setHomePanel(JPanel homePanel) {
		this.homePanel = homePanel;
	}
}
