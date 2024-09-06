package main;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.MainFrame;

public class UserDetail {
	private JPanel userDetail;
	
	public UserDetail() {
		this.setUserDetail(new JPanel());
		JLabel detailLabel = new JLabel("DETAIL");
		JTextField email = new JTextField(MainFrame.getUserInfo().getEmail());
		JTextField username = new JTextField(MainFrame.getUserInfo().getUsername());
		JPasswordField password = new JPasswordField(15);
		this.getUserDetail().add(detailLabel);
		this.getUserDetail().add(email);
		this.getUserDetail().add(username);
		this.getUserDetail().add(password);
	}
	
	public JPanel getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(JPanel userDetail) {
		this.userDetail = userDetail;
	}
	

}
