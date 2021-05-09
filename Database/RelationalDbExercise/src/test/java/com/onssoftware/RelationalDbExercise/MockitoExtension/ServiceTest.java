package com.onssoftware.RelationalDbExercise.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.onssoftware.RelationalDbExercise.model.Database;
import com.onssoftware.RelationalDbExercise.repository.MyUserRepository;
import com.onssoftware.RelationalDbExercise.service.MyUserService;
import com.onssoftware.RelationalDbExercise.service.Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Mock
    Database databaseMock;

    @Test
    public void testQuery()  {
        assertNotNull(databaseMock);
        when(databaseMock.isAvailable()).thenReturn(true);
        Service t  = new Service(databaseMock);
        boolean check = t.query("* from t");
        assertTrue(check);
    }

    @Mock
    private MyUserRepository myUserRepository;

    @InjectMocks
    private MyUserService myUserService;

    @Test
    void mockTest() {
        assertNotNull(myUserRepository);
        assertNotNull(myUserService);
        assertNotNull(myUserService.myUserRepository);
//		Address address = new Address("114/2", "Borobari", "Mymensingh");
//		MyUser asd = new MyUser("asd", address);
//		when(myUserService1.saveUser(asd)).thenReturn(new ResponseEntity<>(asd, HttpStatus.OK));
//		var d = myUserService1.saveUser(asd);
//		assertThat(d.getBody().getId()).isNull();
    }
}
