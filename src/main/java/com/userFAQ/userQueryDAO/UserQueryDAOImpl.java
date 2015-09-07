package com.userFAQ.userQueryDAO;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.userFAQ.userQuerydto.UserQuery;

public class UserQueryDAOImpl implements UserQueryDAO{
	private String QUESTIONS_COLLECTION_NAME = "temp";
	private String KEYWORDS_COLLECTION_NAME = "relevant";
	
	@SuppressWarnings("unused")
	private String IRRELEVANTKEYWORDS_COLLECTION_NAME = "";
	
	@Override
	public ArrayList<int[]> getQueryRelatedQuestions(UserQuery userQuery) throws NullPointerException, UnknownHostException{
		String queryString = userQuery.getQueryString();
		//this is for testing purpose
		System.out.println("Query String from object "+queryString);
		
		//making a connection to db
		DBFactory dbFactory = DBFactory.getDBInstance();
		DB db = dbFactory.getDBConnection();
		
		//fetch the data 
		String keyword = "keyword";
		ArrayList<int[]> questionIndexes = new ArrayList<int[]>();
		
		if(db.collectionExists(KEYWORDS_COLLECTION_NAME)){
			DBCollection dbCollection = db.getCollection(KEYWORDS_COLLECTION_NAME);
			String[] questionKeys = queryString.split(" ");
			
			
			//loop through all the keywords in question
			for(String e:questionKeys){
				BasicDBObject field = new BasicDBObject();
				field.put(keyword,e);
				//debug line
				//System.out.print(keyword + ","+e+": ");
				DBCursor cursor= dbCollection.find(field);
				
				if(!cursor.hasNext()){
					questionIndexes.add(null);
				}
				else{
						DBObject dbObject = cursor.next();
						BasicDBList dbList= (BasicDBList)dbObject.get("value");
						
						if(!dbList.isEmpty()){
							int[] localarray = new int[dbList.size()];
							for(int i=0;i<dbList.size();i++){
								Double local = (Double)dbList.get(i);
								localarray[i] = local.intValue();
								//debug line//System.out.print(localarray[i]+"; ");
							}
							questionIndexes.add(localarray);
							//debug line//System.out.println("");
						}
						else{
							//debug line
							//System.out.println("no keyword found correspond to "+e);
							throw new NullPointerException("some error "+e);
						}
					}
			}
		}
		else{
			throw new NullPointerException("Collection :"+KEYWORDS_COLLECTION_NAME+"Not Found");
		}
		
		return questionIndexes;
	}
	@Override
	public ArrayList<String> getQuestionFromDB(int[] questionNumbers)throws 
										NullPointerException,UnknownHostException{
		//making a connection to db
		DBFactory dbFactory = DBFactory.getDBInstance();
		DB db = dbFactory.getDBConnection();
		
		//fetch the data correspond to the indexes
		ArrayList<String> questions = new ArrayList<String>();
		String keyword = "question_no";
		String questionRetrieve = "question";
		if(db.collectionExists(QUESTIONS_COLLECTION_NAME)){
			DBCollection collection = db.getCollection(QUESTIONS_COLLECTION_NAME);
			for(int i=0;i<questionNumbers.length;i++){
				questions.add(getOneQuestion(collection, keyword, questionNumbers[i]+1, questionRetrieve));
			}
			return questions;
		}
		else{
			throw new NullPointerException("error while retrieving questions: no question found");
		}
	}
	private String getOneQuestion(DBCollection collection,String keyword,int question_no, String retreivalkey){
		BasicDBObject field = new BasicDBObject();
		field.put(keyword,question_no);
		DBCursor cursor= collection.find(field);
		
		String question =null;
		while(cursor.hasNext()){
			DBObject dbObject = cursor.next();
			question = (String)dbObject.get(retreivalkey);
			//debug line this will give the object details
			//System.out.println(dbObject);
		}
		return question;
	}
	public void insertQueryIntoDB(UserQuery userQuery) throws UnknownHostException{
		
		//making a connection to db
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		
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

	}

}
class DBFactory{
	public static String DB_NAME = "userTestDB";
	private static String HOST_NAME ="localhost";
	private static int PORT_NUMBER = 27017;
	private DBFactory() {
	}
	public static DBFactory getDBInstance(){
		return new DBFactory();
	}
	public DB getDBConnection() throws UnknownHostException{
		//making a connection to db
				MongoClient mongoClient = new MongoClient(HOST_NAME, PORT_NUMBER);
				DB db = mongoClient.getDB(DB_NAME);
				return db;
	}
}
