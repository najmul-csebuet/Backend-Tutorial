package com.example.JpaAnnotationsDemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelBRepository extends JpaRepository<ModelB, Long> {
}
