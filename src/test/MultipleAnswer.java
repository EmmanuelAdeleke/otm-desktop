package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;

public class MultipleAnswer extends JFrame {

	private JPanel contentPane;
	private static int questionPosition = 0;
	private static String text;
	private static JLabel lblClosedQuestionHolder;
	
	JLabel lblAnswerA;
	private JLabel lblAnsA;
	JLabel lblAnswerB;
	private JLabel lblAnsB;
	JLabel lblAnswerC;
	private JLabel lblAnsC;
	JLabel lblAnswerD;
	private JLabel lblAnsD;
	JLabel lblTotal;
	
	int total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultipleAnswer frame = new MultipleAnswer();
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
	public MultipleAnswer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(21, 51, 99));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int position = MultipleResult.position;
		List<questions.ClosedQuestion> questionList = MultipleResult.closedQuestionList;
		int questionLimitIndex = questionList.get(position).questionList.size();
		text = questionList.get(position).questionList.get(questionPosition).question;
		
		lblClosedQuestionHolder = new JLabel("<html> <body style=\"text-align: center\">" + text + "</body> </html>");
		lblClosedQuestionHolder.setForeground(Color.WHITE);
		lblClosedQuestionHolder.setHorizontalAlignment(SwingConstants.CENTER);
		lblClosedQuestionHolder.setFont(new Font("Lantinghei TC", Font.PLAIN, 25));
		lblClosedQuestionHolder.setBounds(182, 24, 708, 130);
		contentPane.add(lblClosedQuestionHolder);
		
		total = (int)(questionList.get(position).questionList.get(questionPosition).A + 
				questionList.get(position).questionList.get(questionPosition).B +
				questionList.get(position).questionList.get(questionPosition).C + 
				questionList.get(position).questionList.get(questionPosition).D);
		
		lblAnsA = new JLabel("AnswerA");
		lblAnsA.setForeground(Color.WHITE);
		lblAnsA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnsA.setFont(new Font("Sinhala Sangam MN", Font.PLAIN, 23));
		lblAnsA.setBounds(260, 180, 590, 35);
		contentPane.add(lblAnsA);
		
		lblAnsB = new JLabel("AnswerB");
		lblAnsB.setForeground(Color.WHITE);
		lblAnsB.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnsB.setFont(new Font("Sinhala Sangam MN", Font.PLAIN, 23));
		lblAnsB.setBounds(260, 215, 590, 35);
		contentPane.add(lblAnsB);
		
		lblAnsC = new JLabel("AnswerC");
		lblAnsC.setForeground(Color.WHITE);
		lblAnsC.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnsC.setFont(new Font("Sinhala Sangam MN", Font.PLAIN, 23));
		lblAnsC.setBounds(260, 249, 590, 37);
		contentPane.add(lblAnsC);
		
		lblAnsD = new JLabel("AnswerD");
		lblAnsD.setForeground(Color.WHITE);
		lblAnsD.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnsD.setFont(new Font("Sinhala Sangam MN", Font.PLAIN, 23));
		lblAnsD.setBounds(260, 285, 590, 35);
		contentPane.add(lblAnsD);
		
		lblAnsA.setText(questionList.get(position).questionList.get(questionPosition).ansOption[0]);
		lblAnsB.setText(questionList.get(position).questionList.get(questionPosition).ansOption[1]);
		lblAnsC.setText(questionList.get(position).questionList.get(questionPosition).ansOption[2]);
		lblAnsD.setText(questionList.get(position).questionList.get(questionPosition).ansOption[3]);
		
		lblTotal = new JLabel("Total: " + total);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Bangla Sangam MN", Font.PLAIN, 22));
		lblTotal.setBounds(44, 77, 111, 33);
		contentPane.add(lblTotal);
		
		lblAnswerA = new JLabel("0%");
		lblAnswerA.setForeground(Color.WHITE);
		lblAnswerA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswerA.setText(Math.round((questionList.get(position).questionList.get(questionPosition).A / total) * 100) + "%");
		lblAnswerA.setFont(new Font("Lantinghei TC", Font.PLAIN, 49));
		lblAnswerA.setBounds(81, 456, 203, 67);
		contentPane.add(lblAnswerA);
		
		lblAnswerB = new JLabel("0%");
		lblAnswerB.setForeground(Color.WHITE);
		lblAnswerB.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswerB.setText(Math.round((questionList.get(position).questionList.get(questionPosition).B / total) * 100) + "%");
		lblAnswerB.setFont(new Font("Lantinghei TC", Font.PLAIN, 49));
		lblAnswerB.setBounds(317, 456, 203, 67);
		contentPane.add(lblAnswerB);
		
		lblAnswerC = new JLabel("0%");
		lblAnswerC.setForeground(Color.WHITE);
		lblAnswerC.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswerC.setText(Math.round((questionList.get(position).questionList.get(questionPosition).C / total) * 100) + "%");
		lblAnswerC.setFont(new Font("Lantinghei TC", Font.PLAIN, 49));
		lblAnswerC.setBounds(558, 456, 203, 67);
		contentPane.add(lblAnswerC);
		
		lblAnswerD = new JLabel("0%");
		lblAnswerD.setForeground(Color.WHITE);
		lblAnswerD.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswerD.setText(Math.round((questionList.get(position).questionList.get(questionPosition).D / total) * 100) + "%");
		lblAnswerD.setFont(new Font("Lantinghei TC", Font.PLAIN, 49));
		lblAnswerD.setBounds(781, 456, 203, 67);
		contentPane.add(lblAnswerD);
		
		JLabel lblQuestion2 = new JLabel("");
		lblQuestion2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (questionPosition >= 1) {
					System.out.println(questionPosition);
					questionPosition--;
					text = questionList.get(position).questionList.get(questionPosition).question;
					
					total = (int)(questionList.get(position).questionList.get(questionPosition).A + 
							questionList.get(position).questionList.get(questionPosition).B +
							questionList.get(position).questionList.get(questionPosition).C + 
							questionList.get(position).questionList.get(questionPosition).D);
					
					lblAnswerA.setText(Math.round((questionList.get(position).questionList.get(questionPosition).A / total) * 100) + "%");
					lblAnswerB.setText(Math.round((questionList.get(position).questionList.get(questionPosition).B / total) * 100) + "%");
					lblAnswerC.setText(Math.round((questionList.get(position).questionList.get(questionPosition).C / total) * 100) + "%");
					lblAnswerD.setText(Math.round((questionList.get(position).questionList.get(questionPosition).D / total) * 100) + "%");
					lblClosedQuestionHolder.setText("<html> <body style=\"text-align: center\">" + text + "</body> </html>");
					
					lblAnsA.setText(questionList.get(position).questionList.get(questionPosition).ansOption[0]);
					lblAnsB.setText(questionList.get(position).questionList.get(questionPosition).ansOption[1]);
					lblAnsC.setText(questionList.get(position).questionList.get(questionPosition).ansOption[2]);
					lblAnsD.setText(questionList.get(position).questionList.get(questionPosition).ansOption[3]);
					
					lblTotal.setText("Total: " + total);
//					lblTotal.setText(Integer.toString(total));
				}
				else {
					MultipleResult frame = null;
					try {
						frame = new MultipleResult();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					questionPosition = 0;
					setVisible(false);
					frame.setVisible(true);
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
		lblQuestion2.setBounds(44, 219, 37, 72);
		getContentPane().add(lblQuestion2);
		
		JLabel lblQuestion3 = new JLabel("");
		lblQuestion3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (questionPosition != questionLimitIndex - 1) {
					System.out.println(questionPosition);
					questionPosition++;
					text = questionList.get(position).questionList.get(questionPosition).question;
					
					total = (int)(questionList.get(position).questionList.get(questionPosition).A + 
							questionList.get(position).questionList.get(questionPosition).B +
							questionList.get(position).questionList.get(questionPosition).C + 
							questionList.get(position).questionList.get(questionPosition).D);
					
					lblAnswerA.setText(Math.round((questionList.get(position).questionList.get(questionPosition).A / total) * 100) + "%");
					lblAnswerB.setText(Math.round((questionList.get(position).questionList.get(questionPosition).B / total) * 100) + "%");
					lblAnswerC.setText(Math.round((questionList.get(position).questionList.get(questionPosition).C / total) * 100) + "%");
					lblAnswerD.setText(Math.round((questionList.get(position).questionList.get(questionPosition).D / total) * 100) + "%");
					
					lblAnsA.setText(questionList.get(position).questionList.get(questionPosition).ansOption[0]);
					lblAnsB.setText(questionList.get(position).questionList.get(questionPosition).ansOption[1]);
					lblAnsC.setText(questionList.get(position).questionList.get(questionPosition).ansOption[2]);
					lblAnsD.setText(questionList.get(position).questionList.get(questionPosition).ansOption[3]);
					
					lblClosedQuestionHolder.setText("<html> <body style=\"text-align: center\">" + text + "</body> </html>");
					
//					System.out.println("asdasd" + Integer.toString((questionList.get(position).questionList.get(questionPosition).A / 4) * 100));
					lblTotal.setText("Total: " + total);
				}
				else {
					MultipleResult frame = null;
					try {
						frame = new MultipleResult();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					questionPosition = 0;
					setVisible(false);
					frame.setVisible(true);
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
		lblQuestion3.setBounds(1028, 219, 37, 72);
		getContentPane().add(lblQuestion3);
		
		JLabel lblA = new JLabel("A");
		lblA.setForeground(Color.WHITE);
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Lantinghei TC", Font.PLAIN, 36));
		lblA.setBounds(123, 364, 125, 67);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("B");
		lblB.setForeground(Color.WHITE);
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("Lantinghei TC", Font.PLAIN, 36));
		lblB.setBounds(354, 364, 125, 67);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("C");
		lblC.setForeground(Color.WHITE);
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("Lantinghei TC", Font.PLAIN, 36));
		lblC.setBounds(596, 364, 125, 67);
		contentPane.add(lblC);
		
		JLabel lblD = new JLabel("D");
		lblD.setForeground(Color.WHITE);
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setFont(new Font("Lantinghei TC", Font.PLAIN, 36));
		lblD.setBounds(824, 364, 125, 67);
		contentPane.add(lblD);
		
		JLabel lblA_1 = new JLabel("A:");
		lblA_1.setForeground(Color.WHITE);
		lblA_1.setFont(new Font("Sinhala Sangam MN", Font.PLAIN, 23));
		lblA_1.setBounds(223, 184, 25, 27);
		contentPane.add(lblA_1);
		
		JLabel lblB_1 = new JLabel("B:");
		lblB_1.setForeground(Color.WHITE);
		lblB_1.setFont(new Font("Sinhala Sangam MN", Font.PLAIN, 23));
		lblB_1.setBounds(223, 219, 25, 27);
		contentPane.add(lblB_1);
		
		JLabel lblC_1 = new JLabel("C:");
		lblC_1.setForeground(Color.WHITE);
		lblC_1.setFont(new Font("Sinhala Sangam MN", Font.PLAIN, 23));
		lblC_1.setBounds(223, 254, 25, 27);
		contentPane.add(lblC_1);
		
		JLabel lblD_1 = new JLabel("D:");
		lblD_1.setForeground(Color.WHITE);
		lblD_1.setFont(new Font("Sinhala Sangam MN", Font.PLAIN, 23));
		lblD_1.setBounds(223, 289, 25, 27);
		contentPane.add(lblD_1);
		
		this.setResizable(false);
	}
}
