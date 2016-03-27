package test;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChart_AWT extends JFrame {
	
	static int position = Report.position;
	static List<questions.ClosedQuestion> closedQuestionList = Report.closedQuestionList;
	
	public PieChart_AWT( String title ) {
		super(title); 
		setContentPane(createDemoPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblQuestion2 = new JLabel("");
		lblQuestion2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Open Question");
//				Report.this.dispose();

				try {
					Report frame;
					frame = new Report();
					frame.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				PieChart_AWT.this.dispose();
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
		lblQuestion2.setBounds(10, 10, 86, 72);
		getContentPane().add(lblQuestion2);
	}
	
	private static PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
//		dataset.setValue("IPhone 5s", new Double(200));
//		dataset.setValue("SamSung Grand", new Double(20));
//		dataset.setValue("MotoG", new Double(40));
//		dataset.setValue("Nokia Lumia", new Double(10));
		
		dataset.setValue("Correct", new Double(getCorrectness()[0]));
		dataset.setValue("Wrong", new Double(getCorrectness()[1]));
		return dataset;         
	}
	
	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart(Report.closedQuestionList.get(Report.position).topic, dataset, true, false, false);
		
		return chart;
	}
	
	public static JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());  
		return new ChartPanel(chart); 
	}
	
	public static void main() {
		
		PieChart_AWT demo = new PieChart_AWT("Pie Chart");  
		demo.setSize(500, 500);    
		RefineryUtilities.centerFrameOnScreen(demo);    
		demo.setVisible(true);
	}
	
	public static int[] getCorrectness() {
		int correct = 0;
		int wrong = 0;
		int total = 0;
		int easiest = 0;
		int hardest = 0;
		
		for (int i = 0; i < closedQuestionList.get(position).questionList.size(); i++) {
//			System.out.println(closedQuestionList.get(position).questionList.get(i).correctAnswer);
			
			if(closedQuestionList.get(position).questionList.get(i).ansOption[0].equals(closedQuestionList.get(position).questionList.get(i).correctAnswer)) {
				correct += (int) closedQuestionList.get(position).questionList.get(i).A;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).B;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).C;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).D;
			}
			else if(closedQuestionList.get(position).questionList.get(i).ansOption[1].equals(closedQuestionList.get(position).questionList.get(i).correctAnswer)) {
				correct += (int) closedQuestionList.get(position).questionList.get(i).B;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).A;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).C;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).D;
			}
			else if(closedQuestionList.get(position).questionList.get(i).ansOption[2].equals(closedQuestionList.get(position).questionList.get(i).correctAnswer)) {
				correct += (int) closedQuestionList.get(position).questionList.get(i).C;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).A;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).B;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).D;
			}
			else if(closedQuestionList.get(position).questionList.get(i).ansOption[3].equals(closedQuestionList.get(position).questionList.get(i).correctAnswer)) {
				correct += (int) closedQuestionList.get(position).questionList.get(i).D;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).A;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).B;
				wrong += (int) closedQuestionList.get(position).questionList.get(i).C;
			}
//			System.out.println(closedQuestionList.get(position).questionList.get(i));	
		}
		
		
		total = correct + wrong;
		System.out.println("CORRECT: " + correct);
		System.out.println("WRONG: " + wrong);
		System.out.println("TOTAL: " + total);
		
		return new int[] {correct, wrong, total};
	}
}