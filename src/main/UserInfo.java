package main;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserInfo {
	private JPanel userInfoPanel;
	
	public UserInfo() {
		this.setUserInfoPanel(new JPanel());
		JLabel infoLabel = new JLabel("INFO LABEL");
		this.getUserInfoPanel().add(infoLabel);
	}

	public JPanel getUserInfoPanel() {
		return userInfoPanel;
	}

	public void setUserInfoPanel(JPanel userInfoPanel) {
		this.userInfoPanel = userInfoPanel;
	}
}
