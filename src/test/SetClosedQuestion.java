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

public class SetClosedQuestion extends JFrame {

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
					SetClosedQuestion frame = new SetClosedQuestion();
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
	public SetClosedQuestion() {
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

		JLabel lblClosedQuestion = new JLabel("Multiple Choice");
		lblClosedQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblClosedQuestion.setFont(new Font("Lantinghei TC", Font.PLAIN, 25));
		lblClosedQuestion.setBounds(6, 6, 438, 36);
		contentPane.add(lblClosedQuestion);

		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblQuestion.setBounds(16, 44, 86, 23);
		contentPane.add(lblQuestion);

		txtQuestion = new JTextField();
		txtQuestion.setBounds(16, 69, 403, 28);
		contentPane.add(txtQuestion);
		txtQuestion.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Document find = new Document("_id", user.getId());
//				Document listItem = new Document("questions", new BasicDBObject("_id", new ObjectId()).append("topic", txtTopic.getText()).append("question", txtQuestion.getText()));
//				Document listItem = new Document("_id", objectId);
//				Document updateQuery = new Document("$push", listItem);
//				db.getCollection().updateOne(find, updateQuery);
//				db.getCollection().insertOne(new Document("_id", objectId).append("topic", txtTopic.getText()));
				
				List<String> ansList = new ArrayList<String>();
				ansList.add(txtA.getText());
				ansList.add(txtB.getText());
				ansList.add(txtC.getText());
				ansList.add(txtD.getText());
				
				Document find = new Document("_id", ClosedQuestion.objectId);
				Document listItem = new Document("questionList", new BasicDBObject("question", txtQuestion.getText())
					.append("ansOption", ansList)
					.append("A", 0)
					.append("B", 0)
					.append("C", 0)
					.append("D", 0));
				Document updateQuery = new Document("$push", listItem);
				db.getCollection().updateOne(find, updateQuery);
				txtQuestion.setText("");
				txtA.setText("");
				txtB.setText("");
				txtC.setText("");
				txtD.setText("");
			}
		});
		btnSubmit.setBounds(158, 329, 117, 29);
		contentPane.add(btnSubmit);
		
		txtA = new JTextField();
		txtA.setColumns(10);
		txtA.setBounds(53, 122, 336, 28);
		contentPane.add(txtA);
		
		JLabel lblA = new JLabel("A");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblA.setBounds(179, 99, 78, 23);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("B");
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblB.setBounds(179, 153, 78, 23);
		contentPane.add(lblB);
		
		txtB = new JTextField();
		txtB.setColumns(10);
		txtB.setBounds(53, 176, 336, 28);
		contentPane.add(txtB);
		
		JLabel lblC = new JLabel("C");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblC.setBounds(179, 209, 78, 23);
		contentPane.add(lblC);
		
		txtC = new JTextField();
		txtC.setColumns(10);
		txtC.setBounds(53, 232, 336, 28);
		contentPane.add(txtC);
		
		JLabel lblD = new JLabel("D");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		lblD.setBounds(179, 266, 78, 23);
		contentPane.add(lblD);
		
		txtD = new JTextField();
		txtD.setColumns(10);
		txtD.setBounds(53, 289, 336, 28);
		contentPane.add(txtD);
	}	
}
