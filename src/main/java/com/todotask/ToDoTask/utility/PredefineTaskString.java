package com.todotask.ToDoTask.utility;

public class PredefineTaskString {

	public static final String VAR_TASK_ID = "taskId";
	public static final String VAR_TASK_NAME = "taskName";
	
	
	/*
	 * SQL Query For Retrieve the data From The Database
	 */
	public final static String DELETE_BY_ID = "DELETE FROM Task t WHERE t.taskId = :taskId";
	public final static String UPDATE_TASK_USIN_STRING_ID = "UPDATE Task t SET t.taskName = :taskName WHERE t.taskId = :taskId";
	public final static String SEARCH_BY_ID = "FROM Task t WHERE t.taskId = :taskId";
	
	
	
	/*
	 * Message to The User
	 */
	public final static String TASK_INSERTED_SUCCESSFULLY = "Task Inserted Successfully!!";
	public final static String TASK_UPDATED = "Task Updated Successfully!!";
	public final static String TASK_DELETE =  "Task Deleted Successfully!!";

	public final static String TASK_UPDATED_ERROR_MESSAGE = "No Task Found While Updating";
	public final static String TASK_DELETE_ERROR_MESSAGE = "No Task Found While Deleting";
	public final static String ERROR_MESSAGE = "Some Thing Went Wrong!!";
}
