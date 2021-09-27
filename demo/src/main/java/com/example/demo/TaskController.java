package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor

public class TaskController {

    private final TaskRepository repositiry;
    @GetMapping("/")
    public List<Task> findAll(){
        return repositiry.findAll();

    }
    @GetMapping("/{id}")
        public Task findOne(@PathVariable("id")Long id){
        return repositiry.findById(id).orElse(null);
    }
    @PostMapping("/")
        public ResponseEntity<Task> create(@RequestBody Task task){
        //return ;
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repositiry.save(task));
    }
    @PutMapping("/{id}")
    public Task edit(@RequestBody Task task,@PathVariable Long id){
        Task antigua =repositiry.findById(id).orElse(task);
        antigua.setText(task.getText());
        antigua.setTitle(task.getTitle());

        return repositiry.save(antigua);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        repositiry.deleteById(id);
        return ResponseEntity.noContent().build();
        //return  ResponseEntity.status(204).build();
    }


}
