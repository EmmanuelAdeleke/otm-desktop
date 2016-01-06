package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OpenQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenQuestion frame = new OpenQuestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OpenQuestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOpenQuestion = new JLabel("Open Question");
		lblOpenQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpenQuestion.setFont(new Font("Lantinghei TC", Font.PLAIN, 25));
		lblOpenQuestion.setBounds(6, 6, 438, 36);
		contentPane.add(lblOpenQuestion);
		
		JLabel lblTopic = new JLabel("Topic");
		lblTopic.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblTopic.setBounds(16, 44, 43, 23);
		contentPane.add(lblTopic);
		
		textField = new JTextField();
		textField.setBounds(16, 69, 403, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblQuestion.setBounds(16, 109, 79, 23);
		contentPane.add(lblQuestion);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(16, 140, 403, 28);
		contentPane.add(textField_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(166, 180, 117, 29);
		contentPane.add(btnSubmit);
	}
}
