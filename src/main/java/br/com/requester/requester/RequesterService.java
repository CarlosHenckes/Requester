package br.com.requester.requester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RequesterService {
	
	@Autowired
	CallbackProxy proxy;
	
	private String response = "sem conteudo";

	public ResponseEntity<String> primeiroCaminho() {
		proxy.req();
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	public void getTheCallback(String body) {
		this.response = body;
	}
}
