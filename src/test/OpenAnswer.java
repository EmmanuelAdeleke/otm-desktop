package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class OpenAnswer extends JFrame {

	private JPanel contentPane;
	JLabel lblOpenQuestion;
	JLabel lblAnswer;
	private static int answerPosition = 0;
	private int answerLimit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenAnswer frame = new OpenAnswer();
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
	public OpenAnswer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(21, 51, 99));

		answerLimit = OpenResult.openQuestionList.get(OpenResult.position).answer.length;

		lblAnswer = new JLabel("New label");
		lblAnswer.setForeground(Color.WHITE);
		lblAnswer.setText("<html> <body style=\"text-align: center\">" + OpenResult.openQuestionList.get(OpenResult.position).answer[answerPosition] + "</body> </html>");
		lblAnswer.setFont(new Font("Lantinghei TC", Font.PLAIN, 27));
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setBounds(123, 136, 852, 374);
		contentPane.add(lblAnswer);

		JLabel lblQuestion2 = new JLabel("");
		lblQuestion2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (answerPosition < 0) {
					answerPosition--;
					lblAnswer.setText("<html> <body style=\"text-align: center\">" + OpenResult.openQuestionList.get(OpenResult.position).answer[answerPosition] + "</body> </html>");
				}
				else {
					answerPosition = 0;
					try {
						OpenResult frame = new OpenResult();
						frame.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					OpenAnswer.this.dispose();
				}
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
		Image imgOpenQuestion = new ImageIcon(this.getClass().getResource("/play-arrow-back2.png")).getImage();
		lblQuestion2.setIcon(new ImageIcon(imgOpenQuestion));
		lblQuestion2.setBounds(42, 286, 37, 72);
		getContentPane().add(lblQuestion2);

		JLabel lblQuestion3 = new JLabel("");
		lblQuestion3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (answerPosition != answerLimit - 1) {
					answerPosition++;
					lblAnswer.setText("<html> <body style=\"text-align: center\">" + OpenResult.openQuestionList.get(OpenResult.position).answer[answerPosition] + "</body> </html>");
				}
				else {
					answerPosition = 0;
					try {
						OpenResult frame = new OpenResult();
						frame.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					OpenAnswer.this.dispose();
				}
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
		Image imgOpenQuestion2 = new ImageIcon(this.getClass().getResource("/play-arrow-forward2.png")).getImage();
		lblQuestion3.setIcon(new ImageIcon(imgOpenQuestion2));
		lblQuestion3.setBounds(1026, 286, 37, 72);
		getContentPane().add(lblQuestion3);

		lblOpenQuestion = new JLabel("New label");
		lblOpenQuestion.setForeground(Color.WHITE);
		lblOpenQuestion.setText("<html> <body style=\"text-align: center\">" + OpenResult.openQuestionList.get(OpenResult.position).question + "</body> </html>");
		lblOpenQuestion.setFont(new Font("Lantinghei TC", Font.PLAIN, 31));
		lblOpenQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpenQuestion.setBounds(123, 26, 852, 92);
		contentPane.add(lblOpenQuestion);

		JLabel lblNewLabel = new JLabel("total");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setText("Total: " + OpenResult.openQuestionList.get(OpenResult.position).answer.length);
		lblNewLabel.setFont(new Font("Bangla Sangam MN", Font.PLAIN, 22));
		lblNewLabel.setBounds(17, 50, 102, 48);
		contentPane.add(lblNewLabel);
	}
}
