package com.jp.myapp.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.myapp.entities.Task;
import com.jp.myapp.exception.TaskNotFoundException;
import com.jp.myapp.repository.*;

@Service
public class TaskServices {
	
	@Autowired
	private TaskRepository taskRepo;
	
	public List<Task> getAllTasks(){
		
		return taskRepo.findAll();
	}
	
	public Task getTaskById(int id) {
		return taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with ID: " + id));
	}
	
	public Task createTask(Task task) {
		return taskRepo.save(task);
	}
	
	public Task editTask(int id, Task newTask) {
		Task oldTask= taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with ID:"+ id));
			oldTask.setTitle(newTask.getTitle());
			oldTask.setDescription(newTask.getDescription());
			oldTask.setStatus(newTask.isStatus());
			oldTask.setDueDate(newTask.getDueDate());
			return taskRepo.save(oldTask);
		
		
	}
	
	public void deleteTask(int id) {
		taskRepo.deleteById(id);
	}

}
