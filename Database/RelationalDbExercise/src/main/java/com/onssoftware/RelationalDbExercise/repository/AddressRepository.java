package com.onssoftware.RelationalDbExercise.repository;

import com.onssoftware.RelationalDbExercise.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
