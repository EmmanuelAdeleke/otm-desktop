package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bson.Document;

public class User {

	private String strJson;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private int id;
	
	public User() {
		loadData();
		fetchDetails();
	}
	
	private void loadData() {
		try {
			strJson = FileUtils.readFileToString(new File("user.json"));
			System.out.println(strJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void fetchDetails() {
		Document document = Document.parse(strJson);
		setFirstName(document.getString("first_name"));
		setLastName(document.getString("last_name"));
		setUsername(document.getString("username"));
		setEmail(document.getString("email_address"));
		setId(document.getDouble("_id").intValue());
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
