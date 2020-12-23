package com.example.JpaAnnotationsDemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelARepository extends JpaRepository<ModelA, Long> {
}
