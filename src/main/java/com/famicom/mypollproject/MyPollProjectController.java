package com.famicom.mypollproject;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.famicom.mypollproject.accessingdatamysql.Poll;
import com.famicom.mypollproject.accessingdatamysql.PollRepository;

@RestController
public class MyPollProjectController {

	@Autowired // This means to get the bean called userRepository
	private PollRepository pollRepository;

	@GetMapping(path = "/getAllPolls")
	public @ResponseBody Iterable<Poll> getAllPolls() {
		// This returns a JSON or XML with the users
		return pollRepository.findAll();
	}

	@PostMapping(path = "/createPoll", consumes = "text/plain") // Map ONLY POST
																// Requests
	public @ResponseBody String addNewPoll(@RequestBody String createdPoll) throws Exception {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request
		
		JSONParser parser = new JSONParser(); 
		JSONObject json = (JSONObject) parser.parse(createdPoll);


		System.out.println("=>: " + createdPoll);
		System.out.println( "name= " + json.get("name") );

		// for(Integer i = 0;i <cp.getEntries().length;i++){
		// System.out.println( i + "entry title:" +
		// cp.getEntries()[i].getTitle() );
		// System.out.println( i + "entry author:" +
		// cp.getEntries()[i].getAuthor() );
		// System.out.println( i + "entry creation date:" +
		// cp.getEntries()[i].getCreationDate() );
		// System.out.println( i + "entry img url:" +
		// cp.getEntries()[i].getImgurl() );
		// }

		// User n = new User();
		// n.setName(name);
		// n.setEmail(email);
		// userRepository.save(n);
		return "Saved";
	}

}