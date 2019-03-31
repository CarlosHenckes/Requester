package br.com.requester.requester;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "proxy", url = "http://192.168.99.100:8000")
public interface CallbackProxy {

	@PutMapping(path = "/v1/firstcall")
	public ResponseEntity<String> req();
	
}
