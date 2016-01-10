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
import java.util.Locale;

public class OpenQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField txtTopic;
	private JTextField txtQuestion;
	private static final String SERVER_ADDRESS = "emmanueladeleke.ddns.net";
	private static final String DATABASE = "otm";
	private static final String COLLECTION = "lecturer";
	private static Database db;
	private static User user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws UnknownHostException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenQuestion frame = new OpenQuestion();
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
	public OpenQuestion() {
		user = new User();
		db = new Database(SERVER_ADDRESS, DATABASE, COLLECTION);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
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

		JLabel lblOpenQuestion = new JLabel("Open Question");
		lblOpenQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpenQuestion.setFont(new Font("Lantinghei TC", Font.PLAIN, 25));
		lblOpenQuestion.setBounds(6, 6, 438, 36);
		contentPane.add(lblOpenQuestion);

		JLabel lblTopic = new JLabel("Topic");
		lblTopic.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblTopic.setBounds(16, 44, 43, 23);
		contentPane.add(lblTopic);

		txtTopic = new JTextField();
		txtTopic.setBounds(16, 69, 403, 28);
		contentPane.add(txtTopic);
		txtTopic.setColumns(10);

		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblQuestion.setBounds(16, 109, 79, 23);
		contentPane.add(lblQuestion);

		txtQuestion = new JTextField();
		txtQuestion.setColumns(10);
		txtQuestion.setBounds(16, 140, 403, 28);
		contentPane.add(txtQuestion);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document find = new Document("_id", user.getId());
				Document listItem = new Document("questions", new BasicDBObject("_id", new ObjectId()).append("topic", txtTopic.getText()).append("question", txtQuestion.getText()));
				Document updateQuery = new Document("$push", listItem);
				db.getCollection().updateOne(find, updateQuery);
			}
		});
		btnSubmit.setBounds(166, 180, 117, 29);
		contentPane.add(btnSubmit);
		
	}	
	
}
