package com.example.JpaAnnotationsDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private ModelAService modelAService;

    @Autowired
    private ModelBService modelBService;

    @GetMapping("/modelA")
    public ResponseEntity<List<ModelA>> getAllModelA() {
        List<ModelA> list = modelAService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/modelB")
    public ResponseEntity<List<ModelB>> getAllModelB() {
        List<ModelB> list = modelBService.getAll();
        return ResponseEntity.ok(list);
    }
}
