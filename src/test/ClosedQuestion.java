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

import entities.Database;
import entities.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ClosedQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField txtTopic;
	private static final String SERVER_ADDRESS = "emmanueladeleke.ddns.net";
	private static final String DATABASE = "OtMC";
	private static final String COLLECTION = "closedquestion";
	private static final String COLLECTION2 = "lecturer";
	private static Database db;
	private static Database db2;
	private static User user;
	static ObjectId objectId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws UnknownHostException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClosedQuestion frame = new ClosedQuestion();
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
	public ClosedQuestion() {
		objectId = new ObjectId();
		user = new User();
		db = new Database(SERVER_ADDRESS, DATABASE, COLLECTION);
		db2 = new Database(SERVER_ADDRESS, DATABASE, COLLECTION2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)(Login.width / 2) - (450 / 2), (int)(Login.height / 2) - 300, 450, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQuestion2 = new JLabel("");
		lblQuestion2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Open Question");

				UserLogin userLogin = new UserLogin();
				userLogin.setVisible(true);
				
				ClosedQuestion.this.dispose();
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

		JLabel lblClosedQuestion = new JLabel("Multiple Choice");
		lblClosedQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblClosedQuestion.setFont(new Font("Lantinghei TC", Font.PLAIN, 25));
		lblClosedQuestion.setBounds(6, 6, 438, 36);
		contentPane.add(lblClosedQuestion);

		JLabel lblTopic = new JLabel("Topic");
		lblTopic.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblTopic.setBounds(16, 44, 43, 23);
		contentPane.add(lblTopic);

		txtTopic = new JTextField();
		txtTopic.setBounds(16, 69, 403, 28);
		contentPane.add(txtTopic);
		txtTopic.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Document find = new Document("_id", user.getId());
//				Document listItem = new Document("questions", new BasicDBObject("_id", new ObjectId()).append("topic", txtTopic.getText()).append("question", txtQuestion.getText()));
//				Document listItem = new Document("_id", objectId);
//				Document updateQuery = new Document("$push", listItem);
//				db.getCollection().updateOne(find, updateQuery);
				
				db.getCollection().insertOne(new Document("_id", objectId).append("topic", txtTopic.getText())
						.append("lecturerId", user.getId()));
				
				DBObject listItem = new BasicDBObject("questionList", objectId);
				Document updateQuery = new Document("$push", listItem);
				
				Document find = new Document("_id", user.getId());
//				db2.getCollection().insertOne(new Document("questionList", objectId));
				
				db2.getCollection().updateOne(find, updateQuery);
				
				txtTopic.setText("");
				SetClosedQuestion frame = new SetClosedQuestion();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnSubmit.setBounds(161, 109, 117, 29);
		contentPane.add(btnSubmit);
		
		this.setResizable(false);
		
	}	
	
}
