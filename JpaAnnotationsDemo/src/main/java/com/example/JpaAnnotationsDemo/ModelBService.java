package com.example.JpaAnnotationsDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelBService {

    @Autowired
    private ModelBRepository modelBRepository;

    public List<ModelB> getAll() {
        return modelBRepository.findAll();
    }

    public ModelB save(ModelB modelB) {
        return this.modelBRepository.save(modelB);
    }
}
