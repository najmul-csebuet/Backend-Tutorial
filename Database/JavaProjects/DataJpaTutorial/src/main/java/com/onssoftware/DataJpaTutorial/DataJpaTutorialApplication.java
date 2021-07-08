package com.onssoftware.DataJpaTutorial;

import com.onssoftware.DataJpaTutorial.OneToOne.Account;
import com.onssoftware.DataJpaTutorial.OneToOne.Address;
import com.onssoftware.DataJpaTutorial.OneToOne.AccountService;
import com.onssoftware.DataJpaTutorial.OneToOne.AddressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;

@SpringBootApplication
public class DataJpaTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaTutorialApplication.class, args);
	}
}
