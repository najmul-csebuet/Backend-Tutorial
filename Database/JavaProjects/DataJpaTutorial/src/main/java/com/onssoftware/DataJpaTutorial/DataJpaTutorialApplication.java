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

	@Bean
	@Transactional
	CommandLineRunner initDb(AccountService accountService, AddressRepository addressRepository) {
		return args -> {

			/*var address = new Address();
			address.setName("Mymensingh");

			var acc = new Account();
			acc.setName("Saad");
			acc.setAddress(address);

			accountService.save(acc);*/

			//address.setAccount(acc);


			//addressRepository.save(address);

			Account a = accountService.findOne();
			var aa = a.getAddress();
			System.out.println(aa.getName());
			//accountService.delete(1L);
		};
	}
}
