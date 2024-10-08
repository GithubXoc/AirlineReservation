package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.DatabaseConn;
import gui.MainFrame;
import interfaces.PanelInterface;

public class Register extends MainFrame implements PanelInterface{
	private JPanel registerPage;
	
	public Register() {
		this.setRegisterPage(new JPanel());
		JLabel registerLabel = new JLabel("Register");
		JButton register = new JButton("登録する");
		//Fields
		JTextField username = new JTextField(15);
		JPasswordField password = new JPasswordField(15);
		JTextField email = new JTextField(20);
		
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(this);
				int response = DatabaseConn.registerNewUser(username.getText(), new String(password.getPassword()), email.getText());
				if (response==1) changePanel(MainFrame.loginPanel.getLoginPanel(), false, "register");
			}
		});
		
		this.getRegisterPage().add(registerLabel, BorderLayout.NORTH);
		this.getRegisterPage().add(username);
		this.getRegisterPage().add(email);
		this.getRegisterPage().add(password);
		this.getRegisterPage().add(register);		
		
	}
	
	public JPanel getPanel() {
		return this.getRegisterPage();
	}

	public JPanel getRegisterPage() {
		return registerPage;
	}

	public void setRegisterPage(JPanel registerPage) {
		this.registerPage = registerPage;
	}

}
