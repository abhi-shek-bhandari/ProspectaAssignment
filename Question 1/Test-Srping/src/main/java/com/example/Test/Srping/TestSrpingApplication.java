package com.example.Test.Srping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestSrpingApplication implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(TestSrpingApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();//creating and Initializing the Rest Template

		String url = "https://api.publicapis.org/categories"; //URL

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class); //getting response

		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode jsonNode = objectMapper.readTree(response.getBody()); //here we create JSON NODE Object
		// so that we can extract count and categories

//		System.out.println(jsonNode);

		int count = jsonNode.get("count").asInt();// getting count from jsonnode object

		List<String> categories = new ArrayList<>();
		JsonNode categoriesNode = jsonNode.get("categories");//getting categories from node object

		if (categoriesNode.isArray()) {
			for (JsonNode categoryNode : categoriesNode) { //passing array values to List
				categories.add(categoryNode.asText());
			}
		}

		//Display

		System.out.println("Count: " + count);
		System.out.println("Categories: " + categories);
	}
}
