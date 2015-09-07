package com.userFAQ.userQueryDAO;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.userFAQ.userQuerydto.UserQuery;

public interface UserQueryDAO{
	public ArrayList<int[]> getQueryRelatedQuestions (UserQuery userQuery)
								throws NullPointerException,UnknownHostException;
	public ArrayList<String> getQuestionFromDB(int[] questionNumbers)
								throws NullPointerException, UnknownHostException;

}
