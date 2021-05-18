package com.onssoftware.RelationalDbExercise.repository;

import com.onssoftware.RelationalDbExercise.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {
}
