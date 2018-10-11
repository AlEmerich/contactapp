package com.calinfo.contactapp;

import com.calinfo.contactapp.model.Contact;
import com.calinfo.contactapp.model.User;
import com.calinfo.contactapp.repository.ContactRepository;
import com.calinfo.contactapp.service.CustomPrincipalUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;

@SpringBootApplication
public class ContactappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactappApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ContactRepository repository)
	{
		return args -> {
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("user", "user", new ArrayList<>()));
			String current = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			System.out.println(current);
			//repository.save(new Contact("Alan", "Guitard", "guitard-alan@laposte.net",current));
		};
	}
}
