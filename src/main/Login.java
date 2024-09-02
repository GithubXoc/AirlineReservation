package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.MainFrame;
import interfaces.PanelInterface;

public class Login extends MainFrame implements PanelInterface{
	private JPanel loginPanel;
	
	public Login() {
		this.setLoginPanel(new JPanel());
		JLabel loginLabel = new JLabel("ログイン画面");
		
		//Buttons
		JButton loginButton = new JButton("ログイン");
		loginButton.setActionCommand("login");
		JButton registerButton = new JButton("新規登録");
		registerButton.setActionCommand("register");
		JButton passwordResetButton = new JButton("パスワード再設定");
		passwordResetButton.setActionCommand("resetPassword");
		
		//Fields
		JTextField username = new JTextField(15);
		JPasswordField password = new JPasswordField(15);
		this.getLoginPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e);
			}
		});
		this.getLoginPanel().add(loginLabel);
		this.getLoginPanel().add(username);
		this.getLoginPanel().add(password);
		this.getLoginPanel().add(loginButton);
		this.getLoginPanel().add(registerButton);
		this.getLoginPanel().add(passwordResetButton);
		
		for(Component component : this.getLoginPanel().getComponents()) {
			if (component instanceof AbstractButton) {
				((AbstractButton) component).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println(e.getActionCommand());
						switch (e.getActionCommand()) {
						case "login":
							Home homePanel = new Home();
							changePanel(homePanel.getHomePanel(), true, this);
							break;
						case "register":
							Register registerPanel = new Register();
							changePanel(registerPanel.getRegisterPage(), false, this);
							break;
						case "resetPassword":
							PasswordReset passwordResetPanel = new PasswordReset();
							changePanel(passwordResetPanel.getResetPassPage(), false, this);
							break;
						}
					}
				});
			}
		}
	}
	
	public JPanel getPanel() {
		return this.getLoginPanel();
	}

	public JPanel getLoginPanel() {
		return loginPanel;
	}

	public void setLoginPanel(JPanel loginPanel) {
		this.loginPanel = loginPanel;
	}
}
