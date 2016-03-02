package entities;
import java.io.FileWriter;
import java.io.IOException;

import org.bson.Document;

import com.mongodb.client.MongoCursor;


public class AuthUser {
	
	private String username;
	private String password;
	String jsonUser;
	
	public AuthUser(String username, String password) {
		set(username, password);
	}
	
	public void set(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean authUser(Database db) {
		String user = null;
		
		MongoCursor<Document> cursor = db.getCollection().find(new Document(
				"username", username).append("password", password)).iterator();
		try {
		    while (cursor.hasNext()) {
		        //System.out.println(cursor.next().toJson());
		        user = cursor.next().toJson();
		    }
		} finally {
			cursor.close();
		}
		
		setJson(user);
		if(user == null) return false;
		else return true;
	}
	
	public void setJson(String jsonUser) {
		this.jsonUser = jsonUser;
	}
	
	public void createFile() {
		try {
			FileWriter file = new FileWriter("user.json");
			file.write(jsonUser);
			file.close();
		} catch (IOException e) {
			System.out.println("Cannot create file");
			e.printStackTrace();
		}
	}
}
