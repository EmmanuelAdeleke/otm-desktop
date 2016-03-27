package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JList;

import com.google.gson.Gson;

import entities.User;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import org.jfree.ui.RefineryUtilities;

public class Report extends JFrame {

	public static int position;
	public static List<questions.ClosedQuestion> closedQuestionList;
	public static int correct;
	public static int wrong;
	public static int total;
	Test stats;
	PieChart_AWT pie;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Report() throws IOException {
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
				Report.this.dispose();

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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, -42, 76, 42);
		
		closedQuestionList = parseJson();
		
		JList list = new JList(parseJson().toArray());
		scrollPane.setViewportView(list);
		scrollPane.setBounds(50, 100, 350, 200);
		list.setBounds(36, 39, 344, 178);
//		contentPane.add(list);
		contentPane.add(scrollPane);
		
		JLabel lblMultipleChoiceResults = new JLabel("Generate Report");
		lblMultipleChoiceResults.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultipleChoiceResults.setFont(new Font("Lantinghei TC", Font.PLAIN, 20));
		lblMultipleChoiceResults.setBounds(50, 41, 350, 29);
		contentPane.add(lblMultipleChoiceResults);

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if (evt.getClickCount() == 2) {

					// Double-click detected
					int index = list.locationToIndex(evt.getPoint());
					position = index;
					
//					MultipleAnswer frame = new MultipleAnswer();
//					frame.setVisible(true);
					
					stats = new Test();
					
					correct = stats.getCorrectness()[0];
					wrong = stats.getCorrectness()[1];
					total = stats.getCorrectness()[2];
					
					System.out.println(position + " " + closedQuestionList.get(position).questionList);
					CopyOfPieChart_AWT.main(null);
					
					try {
//						System.out.println(httpGet());
						parseJson();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Report.this.dispose();
					
				} else if (evt.getClickCount() == 3) {

					// Triple-click detected
					int index = list.locationToIndex(evt.getPoint());
				}
			}
		});	
	}

	public String httpGet() throws IOException {

		// Assign strJson to null
		String strJson = null;

		// Assign url and in
		URL url;
		BufferedReader in = null;
		try {
			// Get query (username & password)

			url = new URL("http://emmanueladeleke.ddns.net:3000/OtMC/closedquestion?query={%22lecturerId%22:{%22_id%22:%22" + new User().getId().toString() + "%22}}");
			in = new BufferedReader(new InputStreamReader(url.openStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Get input from in and store in builder
		String inputLine;
		StringBuilder builder = new StringBuilder();
		try {
			while ((inputLine = in.readLine()) != null)
				builder.append(inputLine);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) { 

		}
		try {
			if (in != null) {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Remove all white spaces in strJson
		strJson = builder.toString();

//		System.out.println(strJson);
		return strJson;
	}

	public List<questions.ClosedQuestion> parseJson() throws IOException {
		
		List<questions.ClosedQuestion> questionList = new ArrayList<questions.ClosedQuestion>();
		
		String strJson = httpGet();

		Gson gson = new Gson();

		questions.ClosedQuestion[] closedquestion = gson.fromJson(strJson, questions.ClosedQuestion[].class);
		
		questionList = Arrays.asList(closedquestion);
		
		System.out.println(questionList.toString());
		
		return questionList;

	}
}


