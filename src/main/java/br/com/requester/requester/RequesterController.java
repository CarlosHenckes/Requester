package br.com.requester.requester;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequesterController {
	
	final static Logger LOGGER = Logger.getLogger(RequesterController.class.getName());
	
	@Autowired
	RequesterService service;

	@GetMapping(path = "/v1/vai")
	public Callable<ResponseEntity<String>> makeARequest(){
		LOGGER.info("Requester-Controller-chamando-callback");
		ResponseEntity<String> response = service.primeiroCaminho();
		return () -> ResponseEntity.status(HttpStatus.OK).body(response.getBody());
	}
	
	@PostMapping(path = "/v1/requester")
	public ResponseEntity<String> callback(@RequestBody String body){
		LOGGER.info("Resquester-Controller-recebendo-retorno-callback");
		LOGGER.info("body: " + body);
		service.getTheCallback(body);
		return ResponseEntity.ok("callback response - body: " + body);
	}
}
