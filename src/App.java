import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strJson = null;
        URL url;
        BufferedReader in = null;
        try {
            // Get query (username & password)
            url = new URL("http://emmanueladeleke.ddns.net:3000/OtMC/closedquestion");
            in = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
//http://emmanueladeleke.ddns.net:3000/OtMC/lecturer?query={"studentList":{"_id":"56ae251e27bb4013ea26f48c"}}
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
        
        System.out.println(builder.toString());
        
        Gson gson = new Gson();
        
        ClosedQuestion[] x = gson.fromJson(builder.toString(), ClosedQuestion[].class);
        
        for (int i = 0; i < x.length; i++) {
        	System.out.println(x[i]);
        }
        
//        Lecturer[] lecturer = gson.fromJson(strJson, Lecturer[].class);
		

	}
}

class ClosedQuestion {
	String _id;
	String topic;
	String lecturerId;
	ArrayList<SingleClosedQuestion> questionList;
	
	public String toString() {
		return _id + " " + topic + " " + lecturerId + " " + questionList;
	}
}

class SingleClosedQuestion {
	    String question;
	    String[] ansOption;
	    int A;
	    int B;
	    int C;
	    int D;
	    
	    public String toString() {
	    	return question.toString() + " " + Arrays.toString(ansOption);
	    }
}

class Student {
    private String _id;
    private String firstName;
    private String lastName;
    private String username;
    private String emailAddress;
    private String password;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public String toString() {
        return "ID: " + _id + "\n" +
                "Name :" + firstName + " " + lastName + "\n" +
                "Email: " + emailAddress + "\n";
    }

}

