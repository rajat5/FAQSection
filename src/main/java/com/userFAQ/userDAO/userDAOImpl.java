package com.userFAQ.userDAO;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class userDAOImpl {
	public static void main(String... args){
		try{
			dbConnectivityTest();
		}
		catch(UnknownHostException e){
			e.printStackTrace();
		}
	}
	static void dbConnectivityTest() throws UnknownHostException{
		//for older versions
		//Mongo mongo = new Mongo("localhost", 27017);
		
		//newer versions of mongodb
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		//authenticate if db in secure mode
		
		List<String> dbs = mongoClient.getDatabaseNames();
		if(dbs != null){
			System.out.println("Databases List");
			for(String dbName: dbs){
				System.out.println(dbName);
			}
		}
		else{
			System.out.println("no database present");
		}
		

		DB db = mongoClient.getDB("userTestDB");
		String DB_COLLECTION_NAME = "user";
		@SuppressWarnings("unused")
		DBCollection collection = db.getCollection(DB_COLLECTION_NAME);
		Set<String> collList = db.getCollectionNames();
		if(collList!=null){
			System.out.println("\nCollections present");
			for(String s:collList){
				System.out.println(s);
			}
		}
		BasicDBObject dbObject = new BasicDBObject();
		dbObject.put("name", "skyrim");
		//collection.insert(dbObject);
	}
}
