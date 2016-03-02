package questions;

import java.util.Arrays;

/**
 * Created by EmmanuelAdeleke on 18/02/2016.
 */
public class SingleClosedQuestion {
    public String question;
    public String[] ansOption;
    public String correctAnswer;
    public double A;
    public double B;
    public double C;
    public double D;

    public String toString() {
        return question.toString() + " " + correctAnswer + " " + Arrays.toString(ansOption);
    }
}
