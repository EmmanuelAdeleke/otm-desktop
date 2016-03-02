package test;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.bson.BSON;
import org.bson.BSONObject;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.rmi.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Result extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuestion;
	
	
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws UnknownHostException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
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
	public Result() throws Exception {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)(Login.width / 2) - (450 / 2), (int)(Login.height / 2) - 300, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQuestion2 = new JLabel("");
		lblQuestion2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Open Question");
				setVisible(false);

				UserLogin userLogin = new UserLogin();
				userLogin.setVisible(true);
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
		Image imgOpenQuestion = new ImageIcon(this.getClass().getResource("/back.png")).getImage();

		lblQuestion2.setIcon(new ImageIcon(imgOpenQuestion));
		lblQuestion2.setBounds(16, -11, 86, 72);
		getContentPane().add(lblQuestion2);

		JLabel lblQuestion = new JLabel("");
		lblQuestion.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Check Open Questions");
				
				
				OpenResult openResult = null;
				try {
					openResult = new OpenResult();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				openResult.setVisible(true);
				
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
		Image imgOpenQuestion2 = new ImageIcon(this.getClass().getResource("/openquestion.png")).getImage();
		lblQuestion.setIcon(new ImageIcon(imgOpenQuestion2));
		lblQuestion.setBounds(291, 185, 86, 72);
		getContentPane().add(lblQuestion);
		
		JLabel lblClosedQuestion = new JLabel("");
		lblClosedQuestion.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Check multiple");
//				ClosedQuestion frame = new ClosedQuestion();
				MultipleResult frame = null;
				try {
					frame = new MultipleResult();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
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
		Image imgClosedQuestion = new ImageIcon(this.getClass().getResource("/closedquestion.png")).getImage();
		lblClosedQuestion.setIcon(new ImageIcon(imgClosedQuestion));
		lblClosedQuestion.setBounds(85, 185, 91, 72);
		getContentPane().add(lblClosedQuestion);
		
		JLabel lblCheckMultipleQuestion = new JLabel("Multiple Question");
		lblCheckMultipleQuestion.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblCheckMultipleQuestion.setBounds(51, 156, 141, 24);
		contentPane.add(lblCheckMultipleQuestion);
		
		JLabel lblOpenQuestion = new JLabel("Open Question");
		lblOpenQuestion.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblOpenQuestion.setBounds(274, 157, 125, 23);
		contentPane.add(lblOpenQuestion);
		
		JLabel lblCheckResults = new JLabel("Check Results");
		lblCheckResults.setFont(new Font("Lantinghei TC", Font.PLAIN, 26));
		lblCheckResults.setBounds(134, 62, 193, 37);
		contentPane.add(lblCheckResults);

		this.setResizable(false);
		
	}	
}
