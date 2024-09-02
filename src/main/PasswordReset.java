package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.MainFrame;
import interfaces.PanelInterface;

public class PasswordReset extends MainFrame implements PanelInterface{
	private JPanel resetPassPage;
	
	public PasswordReset() {
		this.setResetPassPage(new JPanel());
		JLabel passResetLabel = new JLabel("Password reset");
		
		JTextField username = new JTextField(15);
		JButton lookUpUser = new JButton("ユーザー検索");
		
		lookUpUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("SEARCHING");
				changePanel(MainFrame.loginPanel.getLoginPanel(), false, this);
			}
		});
		
		this.getResetPassPage().add(passResetLabel);
		this.getResetPassPage().add(username);
		this.getResetPassPage().add(lookUpUser);	
	}
	
	public JPanel getPanel() {
		return this.getResetPassPage();
	}

	public JPanel getResetPassPage() {
		return resetPassPage;
	}

	public void setResetPassPage(JPanel resetPassPage) {
		this.resetPassPage = resetPassPage;
	}

}
