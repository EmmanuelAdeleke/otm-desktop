import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import com.mongodb.client.FindIterable;

import static java.util.Arrays.asList;

public class Main {

	public static void main(String[] args) throws UnknownHostException, InterruptedException {
		// TODO Auto-generated method stub

		//MongoDatabase mongo = new MongoClient("emmanueladeleke.ddns.net");
//		MongoClient client = new MongoClient("emmanueladeleke.ddns.net");
//		MongoDatabase database = client.getDatabase("otm");
//		MongoCollection<Document> users = database.getCollection("lecturer");
		
		MongoClient client = new MongoClient("emmanueladeleke.ddns.net");
		MongoDatabase database = client.getDatabase("OtMC");
		MongoCollection<Document> users = database.getCollection("lecture");
		
		FindIterable<Document> iterable = database.getCollection("closedquestion").find();

		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        System.out.println(document.toJson());
		    }
		});
		
		
		//System.out.println(users.find().first().toJson());
		
//		MongoCursor<Document> cursor = users.find().iterator();
//		try {
//		    while (cursor.hasNext()) {
//		        System.out.println(cursor.next().toJson());
//		    }
//		} finally {
//		    cursor.close();
//		}
		
		//FindIterable<Document> iterable = users.find();
		
//		iterable.forEach(new Block<Document>() {
//
//			@Override
//			public void apply(final Document document) {
//				// TODO Auto-generated method stub
//				System.out.println(document);
//			}
//			
//		});
	
//		FindIterable<Document> iterable = users.find(
//		        new Document("username", "eadeleke"));
		

	}

}
