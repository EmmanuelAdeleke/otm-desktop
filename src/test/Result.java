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
import java.rmi.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Result extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuestion;
	private static final String SERVER_ADDRESS = "emmanueladeleke.ddns.net";
	private static final String DATABASE = "OtMC";
	private static final String COLLECTION = "closedquestion";
	private static Database db;
	private static User user;
	public static ObjectId objectId = new ObjectId();
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
	public Result() {
		user = new User();
		db = new Database(SERVER_ADDRESS, DATABASE, COLLECTION);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQuestion2 = new JLabel("");
		lblQuestion2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("BACK");
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
		
		JLabel lblCheckResults = new JLabel("Check Results");
		lblCheckResults.setFont(new Font("Lantinghei TC", Font.PLAIN, 21));
		lblCheckResults.setBounds(151, 18, 158, 30);
		contentPane.add(lblCheckResults);
		
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
		Image imgOpenQuestion2 = new ImageIcon(this.getClass().getResource("/openquestion.png")).getImage();
		
		lblQuestion.setIcon(new ImageIcon(imgOpenQuestion2));
		lblQuestion.setBounds(143, 141, 86, 72);
		getContentPane().add(lblQuestion2);
		
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

	}	
}
