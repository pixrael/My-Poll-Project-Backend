package com.famicom.mypollproject;

import javax.persistence.EntityManager;

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

@RestController
public class MyPollProjectController {

	@Autowired // This means to get the bean called userRepository
	private PollRepository pollRepository;

	@Autowired // This means to get the bean called userRepository
	private EntryPollRepository entryPollRepository;

	@GetMapping(path = "/getAllPolls")
	public @ResponseBody Iterable<Poll> getAllPolls() {
		// This returns a JSON or XML with the users
		return pollRepository.findAll();
	}

	@PostMapping(path = "/createPoll", consumes = "text/plain") // Map ONLY POST
																// Requests
	public @ResponseBody String addNewPoll(@RequestBody String createdPoll) throws Exception {
		JSONParser parser = new JSONParser();

		JSONObject json;
		try {
			// Block of code to try
			json = (JSONObject) parser.parse(createdPoll);

			Poll poll = new Poll();

			poll.setName((String) json.get("name"));

			JSONArray entries = (JSONArray) json.get("entries");

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

			Poll savedPoll = pollRepository.save(poll);

			JSONObject responseJson = new JSONObject();

			responseJson.put("status", "ok");
			responseJson.put("savedId", savedPoll.getId());

			return responseJson.toString();

		} catch (Exception e) {

			JSONObject responseJson = new JSONObject();

			responseJson.put("status", "error");
			responseJson.put("rootError", e);
			responseJson.put("description", "Please verify that the json format is correct");

			return responseJson.toString();
		}

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