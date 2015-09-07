package com.userFAQ.userQuerySearch;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.userFAQ.userQueryDAO.UserQueryDAO;
import com.userFAQ.userQueryDAO.UserQueryDAOImpl;
import com.userFAQ.userQuerydto.UserQuery;

public class UserQueryHandler {
	//query handler converts a string into query object 
	public ArrayList<int[]> getQuestionsIndexes(String query){
		UserQuery userQuery  = new UserQuery(query);
		
		UserQueryDAO daoImpl = new UserQueryDAOImpl();
		
		ArrayList<int[]> questionsList = null;
		try {
			questionsList = daoImpl.getQueryRelatedQuestions(userQuery);
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		
		try{
			if(questionsList != null){
				return questionsList;
			}
			else{
				throw new NullPointerException();
			}
		}
		catch(NullPointerException e){
			System.out.println("Error while retrieving entries");
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<String> getQuestionFromDB(int[] questionNumbers){
			UserQueryDAO daoImpl = new UserQueryDAOImpl();
			
			ArrayList<String> questionsList = null;
			try {
				questionsList = daoImpl.getQuestionFromDB(questionNumbers);
			} catch (NullPointerException e1) {
				e1.printStackTrace();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			
			try{
				if(questionsList != null){
					return questionsList;
				}
				else{
					throw new NullPointerException();
				}
			}
			catch(NullPointerException e){
				System.out.println("Error while retrieving questions");
				e.printStackTrace();
				return null;
			}
		}
}
