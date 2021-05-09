package com.onssoftware.RelationalDbExercise.DataJpaTest;

import com.onssoftware.RelationalDbExercise.model.Address;
import com.onssoftware.RelationalDbExercise.model.MyUser;
import com.onssoftware.RelationalDbExercise.repository.MyUserRepository;
import com.onssoftware.RelationalDbExercise.service.MyUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

//@ActiveProfiles("test")
@DataJpaTest
//@SpringBootTest
@Import(MyUserService.class)
//@ExtendWith(MockitoExtension.class)
class RelationalDbExerciseApplicationTests {

	@Autowired
	private MyUserService myUserService;

	@Autowired
	private MyUserRepository myUserRepository;

	@Test
	void contextLoads() {
		assertNotNull(myUserRepository);
		assertNotNull(myUserService);
		assertNotNull(myUserService.myUserRepository);

		Address address = new Address("114/2", "Borobari", "Mymensingh");
		MyUser asd = new MyUser("asd", address);
		/*asd = myUserRepository.save(asd);
		assertThat(asd.getId()).isNotNull();*/
		var d = myUserService.saveUser(asd);
		assertThat(d.getBody().getId()).isNotNull();
	}
}
