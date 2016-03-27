package test;

import java.util.List;

public class Test {

	static int position = Report.position;
	static List<questions.ClosedQuestion> closedQuestionList = Report.closedQuestionList;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(closedQuestionList.get(position));
//		getCorrectness();
	}
	
	public int[] getCorrectness() {
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
