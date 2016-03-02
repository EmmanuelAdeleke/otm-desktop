import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import entities.Database;
import test.ClosedQuestion;


public class TestClosed {

	private static final String SERVER_ADDRESS = "emmanueladeleke.ddns.net";
	private static final String DATABASE = "OtMC";
	private static final String COLLECTION = "lecturer";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient client;
		MongoDatabase database;
		MongoCollection<Document> collection;
		
		client = new MongoClient(SERVER_ADDRESS);
		database = client.getDatabase(DATABASE);
		collection = database.getCollection(COLLECTION);

		Document find = new Document("_id", new ObjectId("56ad34776a6b42310b13bb4e"))
		.append("questions.question", "Open question test");

		Document listItem = new Document("questions.$.answer", "This should work");

		Document updateQuery = new Document("$push", listItem);
		collection.updateOne(find, updateQuery);

//		Document updateQuery = new Document("$push", listItem);
	}

}
