package com.calinfo.contactapp;

import com.calinfo.contactapp.model.AppUser;
import com.calinfo.contactapp.model.Contact;
import com.calinfo.contactapp.repository.ContactRepository;
import com.calinfo.contactapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ContactappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactappApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public CommandLineRunner loadData(ContactRepository repository, UserRepository userRepository)
//	{
//		return args -> {
//			//String current = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			//System.out.println(current);
//			repository.save(new Contact("Alan", "Guitard", "guitard-alan@laposte.net"));
//		};
//	}
}
