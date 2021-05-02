package com.onssoftware.RelationalDbExercise;

import com.onssoftware.RelationalDbExercise.model.MyUser;
import com.onssoftware.RelationalDbExercise.service.MyUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
//@DataJpaTest
class RelationalDbExerciseApplicationTests {

	@Autowired
	private MyUserService myUserService;

	@Test
	void contextLoads() {
		var d = myUserService.saveUser(new MyUser("asd", null));
		assertThat(d.getBody().getId()).isNull();
	}

}
