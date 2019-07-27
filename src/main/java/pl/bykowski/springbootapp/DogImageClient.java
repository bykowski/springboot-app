package pl.bykowski.springbootapp;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class DogImageClient {

    public String getDogImage() {
        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject("https://random.dog/woof.json", JsonNode.class);
        return jsonNode.get("url").asText();
    }
}
