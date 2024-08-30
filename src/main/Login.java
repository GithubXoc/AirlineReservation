package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.MainFrame;

public class Login extends MainFrame{
	private JPanel loginPanel;
	
	public Login() {
		this.setLoginPanel(new JPanel());
		JLabel loginLabel = new JLabel("空港剣予約");
		this.getLoginPanel().setLayout(new BorderLayout());
		this.getLoginPanel().add(loginLabel, BorderLayout.NORTH);
		
		JButton loginButton = new JButton("ログイン");
		JButton registerButton = new JButton("新規登録");
		JButton passwordResetButton = new JButton("パスワード再設定");
		this.getLoginPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e);
			}
		});
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("LOGIN BUTTON");
				Home homePanel = new Home();
				changePanel(homePanel.getHomePanel());
			}
		});
		loginButton.setPreferredSize(new Dimension(100, 10));
		registerButton.setPreferredSize(new Dimension(100, 10));
		passwordResetButton.setPreferredSize(new Dimension(100, 10));
		this.getLoginPanel().add(loginButton, BorderLayout.WEST);
		this.getLoginPanel().add(registerButton, BorderLayout.CENTER);
		this.getLoginPanel().add(passwordResetButton, BorderLayout.EAST);
	}

	public JPanel getLoginPanel() {
		return loginPanel;
	}

	public void setLoginPanel(JPanel loginPanel) {
		this.loginPanel = loginPanel;
	}
}
