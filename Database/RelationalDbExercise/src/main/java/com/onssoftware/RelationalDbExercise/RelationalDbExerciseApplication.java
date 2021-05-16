package com.onssoftware.RelationalDbExercise;

import com.onssoftware.RelationalDbExercise.model.Address;
import com.onssoftware.RelationalDbExercise.model.MyUser;
import com.onssoftware.RelationalDbExercise.repository.AddressRepository;
import com.onssoftware.RelationalDbExercise.service.MyUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class RelationalDbExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationalDbExerciseApplication.class, args);
	}

	@Bean
	CommandLineRunner initDb(MyUserService myUserService, AddressRepository addressRepository) {
		return args -> {
			for (int i = 0; i < 5; i++) {
				String name = i + "";
				Address address = new Address(name, name, name);
				MyUser myUser = new MyUser(name, address);
				address.setMyUser(myUser);
				ResponseEntity<MyUser> entity = myUserService.saveUser(myUser);
				System.out.println(entity);
			}

			//myUserService.deleteById(2L);
			//addressRepository.deleteById(2L);
			System.out.println("sf");
		};
	}

}
