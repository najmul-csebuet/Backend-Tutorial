package com.onssoftware.DataJpaTutorial.OneToOne;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class OneToOneMapTest {
    @Bean
    @Transactional
    CommandLineRunner initDb(AccountService accountService, AddressRepository addressRepository) {
        return args -> {

			var address = new Address();
			address.setName("Mymensingh");

			var acc = new Account();
			acc.setName("Saad");
			acc.setAddress(address);

			accountService.save(acc);

            //address.setAccount(acc);


            //addressRepository.save(address);

//            Account a = accountService.findOne();
//            var aa = a.getAddress();
//            System.out.println(aa.getName());
            //accountService.delete(1L);
        };
    }
}
