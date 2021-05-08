package com.onssoftware.RelationalDbExercise;

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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

//@ActiveProfiles("test")
@DataJpaTest
//@SpringBootTest
@Import(MyUserService.class)
@ExtendWith(MockitoExtension.class)
class RelationalDbExerciseApplicationTests {

	@Autowired
	private MyUserService myUserService;

	@Test
	void contextLoads() {
		Address address = new Address("114/2", "Borobari", "Mymensingh");
		MyUser asd = new MyUser("asd", address);
		var d = myUserService.saveUser(asd);
		assertThat(d.getBody().getId()).isNull();
		Integer n = null;
		assertThat(n).isNull();
	}

	@Mock
	private MyUserRepository myUserRepository;

	@InjectMocks
	private MyUserService myUserService1;

	@Test
	void mockTest() {
		Address address = new Address("114/2", "Borobari", "Mymensingh");
		MyUser asd = new MyUser("asd", address);
		when(myUserService1.saveUser(asd)).thenReturn(new ResponseEntity<>(asd, HttpStatus.OK));
		var d = myUserService1.saveUser(asd);
		assertThat(d.getBody().getId()).isNull();
	}
}
