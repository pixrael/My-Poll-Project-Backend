package com.famicom.mypollproject;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.famicom.mypollproject.accessingdatamysql.EntryPoll;
import com.famicom.mypollproject.accessingdatamysql.EntryPollRepository;
import com.famicom.mypollproject.accessingdatamysql.Poll;
import com.famicom.mypollproject.accessingdatamysql.PollRepository;
import com.famicom.mypollproject.utils.PollValidator;

@RestController
public class MyPollProjectController {

	@Autowired // This means to get the bean called userRepository
	private PollRepository pollRepository;

	@Autowired // This means to get the bean called userRepository
	private EntryPollRepository entryPollRepository;

	@Autowired
	private SessionFactory sessionFactory;

	@GetMapping(path = "/getAllPolls")
	public @ResponseBody Iterable<Poll> getAllPolls() {
		// This returns a JSON or XML with the users
		return pollRepository.findAll();
	}

	@PostMapping(path = "/tryLogin", consumes = "text/plain")
	public @ResponseBody String tryLoginNewPoll(@RequestBody String loginData) throws Exception {

		/*
		 * { "login":"admin@gmail.com" "password":"1234" }
		 * 
		 */
		Session session = null;
		JSONParser parser = new JSONParser();
		JSONObject json;

		try {
			session = sessionFactory.openSession();

			Query q = session.createQuery("Select * from user");

			List list = q.list();

			for (int i = 0; i < list.size(); i++) {
				System.out.println("list result");
				System.out.println(list.get(i));
			}

			// Block of code to try
//			json = (JSONObject) parser.parse(loginData);
//
//			String login = (String) json.get("login");
//			String password = (String) json.get("password");
			return "test res";

		} catch (Exception e) {

			return "";
		}

		// verify if exist that user with that login and password

		// if exist should generate a token and return it

		// if !exist should return the response with no exist
		
	}

	@PostMapping(path = "/createPoll", consumes = "text/plain")
	public @ResponseBody String addNewPoll(@RequestBody String createdPoll) throws Exception {

		PollValidator pollValidator = new PollValidator();

		JSONParser parser = new JSONParser();

		JSONObject json;
		try {
			// Block of code to try
			json = (JSONObject) parser.parse(createdPoll);

			String pollName = (String) json.get("name");

			if (pollValidator.validatePollName(pollName)) {

				JSONArray entries = (JSONArray) json.get("entries");

				if (pollValidator.validatePollEntries(entries)) {

					String response = pollValidator.getErrorIncorrectNumberOfPollEntriesJsonResponse();

					return response;

				} else {

					Poll poll = this.createPollFromJson(pollName, entries);

					Poll savedPoll = pollRepository.save(poll);

					String response = pollValidator.getOkSavedPollJsonResponse(savedPoll.getId());
					return response;

				}

			} else {

				String response = pollValidator.getErrorIncorrectPollNameJsonResponse();
				return response;
			}

		} catch (Exception e) {

			String response = pollValidator.getErrorInvalidJsonResponse(e);
			return response;
		}

	}

	private Poll createPollFromJson(String pollName, JSONArray entries) {
		Poll poll = new Poll();
		poll.setName(pollName);

		for (int i = 0; i < entries.size(); i++) {
			JSONObject entry = (JSONObject) entries.get(i);
			EntryPoll entryPoll = new EntryPoll();
			entryPoll.setImgurl((String) entry.get("imgurl"));
			entryPoll.setTitle((String) entry.get("title"));
			entryPoll.setAuthor((String) entry.get("author"));
			entryPoll.setCreationDate((String) entry.get("creationDate"));

			EntryPoll savedEntryPoll = this.entryPollRepository.save(entryPoll);

			this.saveEntryPoll(savedEntryPoll.getId(), i, poll);
		}

		return poll;
	}

	private void saveEntryPoll(int idEntryPoll, int index, Poll poll) {
		switch (index) {
		case 0:
			poll.setId_poll_entry1(idEntryPoll);
			break;
		case 1:
			poll.setId_poll_entry2(idEntryPoll);
			break;
		case 2:
			poll.setId_poll_entry3(idEntryPoll);
			break;
		case 3:
			poll.setId_poll_entry4(idEntryPoll);
			break;
		case 4:
			poll.setId_poll_entry5(idEntryPoll);
			break;
		case 5:
			poll.setId_poll_entry6(idEntryPoll);
			break;
		case 6:
			poll.setId_poll_entry7(idEntryPoll);
			break;
		case 7:
			poll.setId_poll_entry8(idEntryPoll);
			break;
		case 8:
			poll.setId_poll_entry9(idEntryPoll);
			break;
		case 9:
			poll.setId_poll_entry10(idEntryPoll);
			break;
		}

	}

}