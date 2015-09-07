package com.userFAQ.userQuerySearch;

import java.util.ArrayList;

public class QueryHandlerTest {
	//this is a test mainmethod
	public static void main(String... args){
		String query1 = "I love the whole world recieve order place return";
		//String query2 = "be de be de";
		
		QueryHandlerTest handlerTest = new QueryHandlerTest();
		handlerTest.searchQueryKeywordsInDB(query1);
	}
	public ArrayList<String> searchQueryKeywordsInDB(String query){
		UserQueryHandler querySearch = new UserQueryHandler();
		
		//retrieve all the question indexes related to the keyword
		ArrayList<int[]> questionIndexesList = querySearch.getQuestionsIndexes(query);
		String[] queryKeys = query.split(" ");
		System.out.println(questionIndexesList.size()==queryKeys.length);
		for(int i=0;i<questionIndexesList.size();i++){
			System.out.println(queryKeys[i] +" :");
			if(questionIndexesList.get(i)!=null){
				for(int j=0;j<questionIndexesList.get(i).length;j++){
					System.out.print(questionIndexesList.get(i)[j]+"; ");
				}
			}
			System.out.println();
		}
		
		//custom function to get best indexes
		int questionNumbers = 10;
		BestRelatedQueriesIndexes bestRelatedQueriesIndexes = new BestRelatedQueriesIndexes();
		int[] questionIndexes =  bestRelatedQueriesIndexes.getIndexes(
				query,questionIndexesList,questionNumbers);
		System.out.println("-------------------------");
		for(int i=0;i<questionIndexes.length;i++){
			System.out.print(questionIndexes[i]+ "; ");
		}
		
		//fetch the corresponding questions from the db
		ArrayList<String> questions = querySearch.getQuestionFromDB(questionIndexes);
		System.out.println("\n-------------------------");
		for(int i=0;i<questions.size();i++){
			System.out.println(questions.get(i)+ "; ");
		}
		
		return questions;
		
	}
}
