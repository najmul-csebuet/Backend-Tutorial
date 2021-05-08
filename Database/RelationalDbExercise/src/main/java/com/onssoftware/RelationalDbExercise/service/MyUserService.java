package com.onssoftware.RelationalDbExercise.service;

import com.onssoftware.RelationalDbExercise.model.MyUser;
import com.onssoftware.RelationalDbExercise.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserService {

    public final MyUserRepository myUserRepository;

    public ResponseEntity<MyUser> saveUser(MyUser myUser) {
        if(myUser.getName().isEmpty()) {
            return new ResponseEntity<>(myUser, HttpStatus.BAD_REQUEST);
        }

        if(myUser.getAddress() == null) {
            return new ResponseEntity<>(myUser, HttpStatus.BAD_REQUEST);
        }

        myUser = myUserRepository.save(myUser);
        return new ResponseEntity<>(myUser, HttpStatus.OK);
    }

    public ResponseEntity<MyUser> getUser(Long id) {
        Optional<MyUser> byId = myUserRepository.findById(id);
        if(byId.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        MyUser myUser = byId.get();
        return new ResponseEntity<>(myUser, HttpStatus.OK);
    }

    public ResponseEntity<List<MyUser>> getAllUser() {
        List<MyUser> all = myUserRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
