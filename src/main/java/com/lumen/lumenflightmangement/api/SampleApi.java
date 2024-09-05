package com.lumen.lumenflightmangement.api;

import com.lumen.lumenflightmangement.models.ResObj;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
//@RequestMapping( value = "/api/v1/sample", produces = MediaType.APPLICATION_JSON_VALUE )
@RequestMapping( "api/v1/sample")
public class SampleApi {
	@GetMapping
	public ResponseEntity<ResObj> getTestingApi(){
		ResObj resObj = new ResObj( "hello world!.");
		return ResponseEntity.ok(resObj);
	}
}
