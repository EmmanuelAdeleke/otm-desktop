package questions;

/**
 * Created by EmmanuelAdeleke on 15/01/2016.
 */
public class OpenQuestion {
    public String _id;
    public String topic;
    public String question;
    public String[] answer;

    @Override
    public String toString() {
        return "*** " + topic + " || " + "*** " + question;
    }
}
