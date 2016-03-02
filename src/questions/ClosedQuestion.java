package questions;

import java.util.List;

/**
 * Created by EmmanuelAdeleke on 11/02/2016.
 */
public class ClosedQuestion {
    public String _id;
    public String topic;
    public String lecturerId;
    public List<SingleClosedQuestion> questionList;
    public int size;

    public int getSize() {
        size = questionList.size();
        return size;
    }

    public String toString() {
        return " *** " + topic;
    }
}