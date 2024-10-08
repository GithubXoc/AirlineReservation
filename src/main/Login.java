package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.DatabaseConn;
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
							try {
//								changePanel(homePanel.getHomePanel(), true, this);
								ResultSet userData = DatabaseConn.authenticate(username.getText(), new String(password.getPassword()));
								if (userData != null) {
									System.out.println(userData);
									MainFrame.setUserInfo(new UserInfo(userData.getString("username") ,userData.getLong(1), userData.getString("email"))); 
									changePanel(homePanel.getHomePanel(), true, "home");
								} else {
									throw new Exception("ユーザー名またはパスワードに誤差があります！\n再び確認してください。");
								}
							} catch (Exception exceptionLogin) {
								JOptionPane.showMessageDialog(MainFrame.getMainFrame(), exceptionLogin.getMessage());
							}
							break;
						case "register":
							Register registerPanel = new Register();
							changePanel(registerPanel.getRegisterPage(), false, "login");
							break;
						case "resetPassword":
							PasswordReset passwordResetPanel = new PasswordReset();
							changePanel(passwordResetPanel.getResetPassPage(), false, "login");
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
