package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.credential.Credentials;
import com.revature.services.CredentialService;

@CrossOrigin
@RestController
@RequestMapping("credential")
public class CredentialController {

	@Autowired
	CredentialService cs;
	
	@PostMapping("login")
	public List<Credentials> findByUsernameAndPassword(@RequestBody Credential c) {
		System.out.println("Login Called");
		return cs.findByUsernameAndPassword(c.getUsername(), c.getPassword());
	}
}
