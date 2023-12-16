package com.jp.myapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jp.myapp.entities.Task;
import com.jp.myapp.services.*;

@RestController
public class TaskController {
	
	@Autowired
	private TaskServices taskServices;
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTasks(){
		List<Task> task= taskServices.getAllTasks();
		return new ResponseEntity<>(task, HttpStatus.OK);
		
	}
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") int id){
		
		Task task= taskServices.getTaskById(id);
		
		if(task!=null) {
			return new ResponseEntity<>(task, HttpStatus.OK);
		}else return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<Task> postTask(@RequestBody Task task){
		Task newTask= taskServices.createTask(task);
		return new ResponseEntity<>(newTask, HttpStatus.CREATED);
	}
	
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") int id, @RequestBody Task updatedtask){
		Task updated= taskServices.editTask(id, updatedtask);
		if(updated!=null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		}else return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@DeleteMapping("tasks/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		taskServices.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	

}
