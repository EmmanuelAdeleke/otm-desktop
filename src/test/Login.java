package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private static final String SERVER_ADDRESS = "emmanueladeleke.ddns.net";
	private static final String DATABASE = "OtMC";
	private static final String COLLECTION = "lecturer";
	private static Database db;
	private static AuthUser user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setResizable(false);
					
					frame.getContentPane().setBackground(new Color(21, 51, 99));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		db = new Database(SERVER_ADDRESS, DATABASE, COLLECTION);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsername = new JTextField();
		txtUsername.setBounds(158, 110, 134, 28);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(158, 167, 134, 28);
		contentPane.add(passwordField);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(158, 93, 68, 16);
		lblUsername.setForeground(new Color(255, 255, 255));
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(158, 150, 61, 16);
		lblPassword.setForeground(new Color(255, 255, 255));
		contentPane.add(lblPassword);

		JLabel lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(158, 242, 134, 16);
		lblStatus.setForeground(new Color(255, 255, 255));
		contentPane.add(lblStatus);
		
		JButton btnAuthenticate = new JButton("Authenticate");
		btnAuthenticate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = new AuthUser(txtUsername.getText(), passwordField.getText());
				//System.out.println("Connected: " + user.authUser(db));
				
				if(user.authUser(db)) {
					user.createFile();
					lblStatus.setText("");
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
					exitLogin();
				}
				else if (txtUsername.getText().trim().equals("") ||
						passwordField.getText().trim().equals("")) {
					lblStatus.setText("Enter login details!");
				}
				else {
					lblStatus.setText("User not found!");
				}
			}
		});
		btnAuthenticate.setBounds(168, 207, 117, 29);
		contentPane.add(btnAuthenticate);
		
		JLabel label = new JLabel("");
		
		Image img = new ImageIcon(this.getClass().getResource("/otmtitle2.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(168, 33, 117, 45);
		contentPane.add(label);		
	}

	public void exitLogin(){
		this.dispose();
	}
	
	
}

