package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitData {

    private final TaskRepository repository;

    @PostConstruct
    public void init(){
        repository.saveAll(
                Arrays.asList(
                        new Task("Rellenar","Llena de datos repositorio"),
                        new Task("Cerrar el proyecto","Antes de lanzar uno"),
                        new Task("Programar","programar y programar")
                )
        );
    }

}
