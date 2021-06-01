package com.onssoftware.OneToOneMapping;

import com.onssoftware.OneToOneMapping.model.Account;
import com.onssoftware.OneToOneMapping.model.Address;
import com.onssoftware.OneToOneMapping.repository.AccountRepository;
import com.onssoftware.OneToOneMapping.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingApplication.class, args);
	}

	@Bean
	CommandLineRunner initDb(AccountService accountService) {
		return args -> {

			/*var address = new Address();
			address.setName("Mymensingh");

			var acc = new Account();
			acc.setName("Saad");
			acc.setAddress(address);

			accountService.save(acc);*/
			Account a = accountService.findOne();
			accountService.delete(a.getId());
		};
	}
}
