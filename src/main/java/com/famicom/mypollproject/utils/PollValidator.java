package com.famicom.mypollproject.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.famicom.mypollproject.accessingdatamysql.User;

public class PollValidator {

	public String getErrorInvalidJsonResponse(Exception e) {

		JSONObject responseJson = new JSONObject();

		responseJson.put("status", "error");
		responseJson.put("rootError", e);
		responseJson.put("description", "Please verify that the json format is correct");

		return responseJson.toString();

	}

	public String getErrorIncorrectPollNameJsonResponse() {

		JSONObject responseJson = new JSONObject();

		responseJson.put("status", "error");
		responseJson.put("rootError", "Incorrect poll name");
		responseJson.put("description",
				"Please verify that the name of the poll. Can start only with letters. Numbers can be added from the second character ahead. White spaces are allowed. Min length 5. Max length 40.");

		return responseJson.toString();

	}

	public boolean validatePollName(String pollName) {
		return pollName.matches("^[a-zA-Z][a-zA-Z0-9_ ]{4,39}$");
	}

	public boolean validatePollEntries(JSONArray entries) {
		return entries.size() < 2 || entries.size() > 4;
	}

	public String getErrorIncorrectNumberOfPollEntriesJsonResponse() {
		JSONObject responseJson = new JSONObject();

		responseJson.put("status", "error");
		responseJson.put("rootError", "Incorrect numnber of poll entries.");
		responseJson.put("description", "Number of entry polls should be between 2 to 4 entries.");

		return responseJson.toString();
	}

	public String getOkSavedPollJsonResponse(Integer id) {
		JSONObject responseJson = new JSONObject();

		responseJson.put("status", "ok");
		responseJson.put("savedId", id + "");

		return responseJson.toString();
	}

	public String getLoggedUser(User user) {

		JSONObject userJson = new JSONObject();

		userJson.put("id", user.getId());
		userJson.put("name", user.getName());
		userJson.put("lastname", user.getLastname());
		userJson.put("login", user.getLogin());
		userJson.put("password", user.getPassword());

		return userJson.toString();

	}

	public String getInvalidUserResponse() {

		JSONObject responseJson = new JSONObject();

		responseJson.put("status", "error");
		responseJson.put("rootError", "Invalid login or password.");
		responseJson.put("description", "Login and password are invalid.");

		return responseJson.toString();
	}

	/*
	 * 
	 * */

}
