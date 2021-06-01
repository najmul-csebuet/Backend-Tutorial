package com.onssoftware.DataJpaTutorial.MockitoExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyUserServiceTest {

    /*@Mock
    private MyUserRepository myUserRepository;

    @InjectMocks
    private MyUserService myUserService;

    @Test
    void contextLoads() {

        assertNotNull(myUserRepository);
        assertNotNull(myUserService);
        assertNotNull(myUserService.myUserRepository);

        Address address = new Address("114/2", "Borobari", "Mymensingh");
        MyUser asd = new MyUser("asd", address);

        //given(myUserService.saveUser(asd)).willReturn(ResponseEntity.badRequest().body(asd));
        //when(myUserService.saveUser(Mockito.any(MyUser.class))).thenReturn(ResponseEntity.badRequest().body(asd));
//        when(myUserService.saveUser(asd)).thenReturn(ResponseEntity.ok().body(asd));
        when(myUserRepository.save(asd)).thenReturn(asd);
//        doReturn(asd).when(myUserService.saveUserNew());
//        when(myUserService.saveUserNew()).thenReturn(asd);
        //given(myUserService.saveUser(asd)).willReturn(asd);

        var d = myUserService.saveUser(asd);
        assertThat(d.getBody().getId()).isNull();
    }*/
}
