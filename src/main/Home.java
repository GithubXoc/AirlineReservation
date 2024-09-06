package main;

import java.awt.BorderLayout;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;

import database.DatabaseConn;
import gui.MainFrame;
import interfaces.PanelInterface;

public class Home extends MainFrame implements PanelInterface{
	private JPanel homePanel;
	private ResultSet flights;
	
	public Home() {
		this.setHomePanel(new JPanel());
		JLabel homeLabel = new JLabel("Home label");
//		this.getHomePanel().setLayout(new BorderLayout());
		this.setFlights(DatabaseConn.fetchData("select * from airlines.flights;"));
		
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

	public ResultSet getFlights() {
		return flights;
	}

	public void setFlights(ResultSet flights) {
		this.flights = flights;
	}
}
