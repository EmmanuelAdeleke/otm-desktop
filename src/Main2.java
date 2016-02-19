import org.bson.BSON;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.Document;

import test.AuthUser;
import test.Database;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Main2 {

	public static void main(String[] args) throws InterruptedException {
		Database db = new Database("emmanueladeleke.ddns.net", "otm", "lecturers");
		AuthUser user = new AuthUser("mjogminaite", "mjogminaite1994");
		System.out.println(user.authUser(db));
		
//		String json = user.getJsonUser();
//		Document document = Document.parse(json);
//		System.out.println(document.getString("first_name"));
//		System.out.println(document.getString("last_name"));
		
		//System.out.println(user.getFirstName());
		
//		MongoCursor<Document> cursor = db.getCollection().find(new Document(
//				"username", "eadeleke").append("password", "eadeleke1995")).iterator();
//		try {
//		    while (cursor.hasNext()) {
//		        //System.out.println(cursor.next().toJson());
//		        user = cursor.next().toJson();
//		    }
//		} finally {
//		    cursor.close();
//		}
//		
//		System.out.println(user);
		
//		FindIterable<Document> iterable = db.getCollection().find(
//		        new Document("username", "eadeleke").append("password", "eadeleke1995"));
//		
//		iterable.forEach(new Block<Document>() {
//			
//			@Override 
//			public void apply(final Document document) {
//				// TODO Auto-generated method stub
//				System.out.println(document.toJson());
//			}
//			
//		});
		
	}

}
