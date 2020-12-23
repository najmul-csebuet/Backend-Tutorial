package com.example.JpaAnnotationsDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelAService {

    @Autowired
    private ModelARepository modelARepository;

    public List<ModelA> getAll() {
        return modelARepository.findAll();
    }

    public ModelA save(ModelA modelA) {
        return modelARepository.save(modelA);
    }
}
