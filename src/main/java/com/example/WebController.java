package com.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Marthandan
@RestController
public class WebController {
	
	
	@RequestMapping(value = "/marthandan", method = RequestMethod.GET)
	public String post() {
		if(1==1)
		throw new RuntimeException();
		
	    return "Marthandan requested2";
	}
	
	@RequestMapping(value = "/marthandan22", method = RequestMethod.GET)
	public String getResultSql() throws SQLException {
		boolean flag = true;
		if (flag) {
			throw new SQLException();
		}
		return "view";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String post(@RequestBody Customer cust) {
	    System.out.println("/POST request, cust: " + cust.toString());
	    
	    return "/Post Successful!";
	}
	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<Customer> get(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("age") int age) {
	    String info = String.format("/GET info: id=%d, name=%s, age=%d", id, name, age);
	    
	    System.out.println(info);
	    
	    List<HttpMethod> allowMethods = new ArrayList<>();
	    allowMethods.add(HttpMethod.GET);
	    allowMethods.add(HttpMethod.POST);
	    
	    
	    HttpHeaders headers = new HttpHeaders();
	    
	    headers.setAccessControlAllowOrigin("www.google.com");
	    headers.setAccessControlAllowMethods(allowMethods);
	    headers.setCacheControl("private, max-age=3600, must-revalidate");
	    headers.setDate(System.currentTimeMillis());
	    headers.setLastModified(System.currentTimeMillis());
	    headers.setExpires(System.currentTimeMillis()+5000);
	    
/*	    if(!originalOrigin.equalsIgnoreCase("localhost")){
	    	
	    	  return new ResponseEntity<>(new Customer(), headers, HttpStatus.UNAUTHORIZED);
	    }*/
	    
	    return new ResponseEntity<>(new Customer(id, name, age), headers, HttpStatus.OK);

	}

	@RequestMapping(value= "/put/{id}", method = RequestMethod.PUT)
	public void put(@PathVariable(value = "id") long id, @RequestBody Customer cust) {
	    String info = String.format("id = %d, custinfo = %s", id, cust.toString());
	    System.out.println("/PUT info " + info);
	}
	
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") long id) {
	    String info = String.format("/Delele info: id = %s", id);
	    System.out.println(info);
	}

	
}
