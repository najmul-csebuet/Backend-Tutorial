package com.example.JpaAnnotationsDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaAnnotationsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaAnnotationsDemoApplication.class, args);
    }

    @Bean
    int initDb(ModelAService modelAService, ModelBService modelBService) {
        ModelA modelA = new ModelA("Najmul A");
        ModelB modelB = new ModelB("Hasan B");
        modelA.getList().add(modelB);
        modelB.setModelA(modelA);
        modelAService.save(modelA);
        modelBService.save(modelB);

        List<ModelB> all = modelBService.getAll();
        return 0;
    }
}
