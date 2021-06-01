package com.onssoftware.DataJpaTutorial.DataJpaTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@ActiveProfiles("test")
@DataJpaTest
//@SpringBootTest
//@Import(MyUserService.class)
//@ExtendWith(MockitoExtension.class)
class DataJpaTutorialApplicationTests {

	/*@Autowired
	private MyUserService myUserService;

	@Autowired
	private MyUserRepository myUserRepository;*/

	@Test
	void contextLoads() {
		/*assertNotNull(myUserRepository);
		assertNotNull(myUserService);
		assertNotNull(myUserService.myUserRepository);

		Address address = new Address("114/2", "Borobari", "Mymensingh");
		MyUser asd = new MyUser("asd", address);
		asd = myUserService.saveUser(asd).getBody();
		var d = myUserService.getUser(asd.getId());
		assertThat(d.getBody().getAddress()).isNotNull();*/
	}
}
