package test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.UnknownHostException;

import javax.swing.SwingConstants;

public class UserLogin extends JFrame {

	public User user;
	
	public static void main(String[] args) {
//		try {
//            // Set System L&F
//        UIManager.setLookAndFeel(
//            UIManager.getSystemLookAndFeelClassName());
//    } 
//    catch (UnsupportedLookAndFeelException e) {
//       // handle exception
//    }
//    catch (ClassNotFoundException e) {
//       // handle exception
//    }
//    catch (InstantiationException e) {
//       // handle exception
//    }
//    catch (IllegalAccessException e) {
//       // handle exception
//    }
//    
//		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserLogin() {
		user = new User();
		
		setBounds(100, 100, 450, 510);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Lantinghei TC", Font.BOLD, 30));
		lblWelcome.setBounds(31, 34, 161, 29);
		getContentPane().add(lblWelcome);
		
		JLabel lblFullName = new JLabel(user.getFirstName() + " " + user.getLastName());
		lblFullName.setFont(new Font("Lantinghei TC", Font.PLAIN, 20));
		lblFullName.setBounds(31, 59, 275, 36);
		getContentPane().add(lblFullName);
		
		JLabel lblEmail = new JLabel(user.getEmail());
		lblEmail.setFont(new Font("Lantinghei TC", Font.PLAIN, 15));
		lblEmail.setBounds(31, 82, 213, 36);
		getContentPane().add(lblEmail);
		
		JButton btnSignOut = new JButton("Sign out");
		btnSignOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exitPanel();
			}
		});
		btnSignOut.setBounds(172, 440, 117, 29);
		getContentPane().add(btnSignOut);

		JLabel lblQuestion = new JLabel("");
		lblQuestion.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Open Question");
				OpenQuestion openQuestion = new OpenQuestion();
				openQuestion.setVisible(true);
				openQuestion.setResizable(false);
				
				setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		Image imgOpenQuestion = new ImageIcon(this.getClass().getResource("/openquestion.png")).getImage();
		
		lblQuestion.setIcon(new ImageIcon(imgOpenQuestion));
		lblQuestion.setBounds(143, 141, 86, 72);
		getContentPane().add(lblQuestion);
		
		JLabel lblClosedQuestion = new JLabel("");
		lblClosedQuestion.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Ask a Question");
				ClosedQuestion frame = new ClosedQuestion();
				frame.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		Image imgClosedQuestion = new ImageIcon(this.getClass().getResource("/closedquestion.png")).getImage();
		lblClosedQuestion.setIcon(new ImageIcon(imgClosedQuestion));
		lblClosedQuestion.setBounds(241, 141, 91, 72);
		getContentPane().add(lblClosedQuestion);
		
		JLabel lblReport = new JLabel("");
		lblReport.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Check Results");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		Image imgReport = new ImageIcon(this.getClass().getResource("/report2.png")).getImage();
		lblReport.setIcon(new ImageIcon(imgReport));
		lblReport.setBounds(172, 244, 117, 72);
		getContentPane().add(lblReport);
		
		JLabel lblSettings = new JLabel("");
		lblSettings.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Settings");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		Image imgSettings = new ImageIcon(this.getClass().getResource("/settings.png")).getImage();
		lblSettings.setIcon(new ImageIcon(imgSettings));
		lblSettings.setBounds(172, 349, 117, 72);
		getContentPane().add(lblSettings);
		
		JLabel lblGenerateReport = new JLabel("Check Results");
		lblGenerateReport.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblGenerateReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerateReport.setBounds(172, 225, 117, 16);
		getContentPane().add(lblGenerateReport);
		
		JLabel lblSubmitQuestions = new JLabel("Submit Questions");
		lblSubmitQuestions.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblSubmitQuestions.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmitQuestions.setBounds(172, 113, 117, 16);
		getContentPane().add(lblSubmitQuestions);
		
		JLabel lblUserSettings = new JLabel("Settings");
		lblUserSettings.setFont(new Font("Lantinghei TC", Font.PLAIN, 13));
		lblUserSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserSettings.setBounds(172, 328, 117, 16);
		getContentPane().add(lblUserSettings);
		this.setResizable(false);
		
	}
	
	public void exitPanel(){
		Login login = new Login();
		login.setVisible(true);
		login.getContentPane().setBackground(new Color(63, 81, 181));
		this.dispose();
	}
}
