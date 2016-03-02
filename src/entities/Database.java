package entities;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Database {
	
	private MongoClient client;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	public Database(String mClient, String mDatabase, String mCollection) {
		client = new MongoClient(mClient);
		database = client.getDatabase(mDatabase);
		collection = database.getCollection(mCollection);
	}
	
	public MongoClient getClient() {
		return client;
	}

	public MongoDatabase getDatabase() {
		return database;
	}

	public MongoCollection<Document> getCollection() {
		return collection;
	}
	
}
