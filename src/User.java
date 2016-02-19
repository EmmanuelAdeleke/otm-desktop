

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

public class User {

	private String strJson;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private ObjectId _id;
	
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
		setFirstName(document.getString("firstName"));
		setLastName(document.getString("lastName"));
		setUsername(document.getString("username"));
		setEmail(document.getString("emailAddress"));
		setId(document.getObjectId("_id"));
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

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
	}
	
	
}
