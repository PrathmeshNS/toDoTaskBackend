package com.todotask.ToDoTask.utility;

public class PredefineUserString {

	public static final String VAR_ID = "id";
	public static final String VAR_NAME = "name";
	public static final String VAR_EMAIL = "email";
	public static final String VAR_PASSWORD = "password";

	/*
	 * SQL Query For Retrieve the data From The Database
	 */
	public final static String SEARCH_BY_ID = "FROM User u WHERE u.id = :id";
	public final static String SEARCH_BY_EMAIL = "FROM User u WHERE u.email = :email";
	
	
	/*
	 * Message to The User
	 */
	public final static String USER_INSERTED_SUCCESSFULLY =  " User Inserted Successfully!!";
	public final static String EMAIL_ALREADY_EXIT =  " Email Already Exits!!";
	public final static String ERROR_MESSAGE =  "Some Thing Went Wrong!!";


	
}
