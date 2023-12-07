package com.jp.myapp.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.myapp.dao.*;
import com.jp.myapp.entities.Task;

@Service
public class TaskServices {
	
	@Autowired
	private TaskRepository taskRepo;
	
	public List<Task> getAllTasks(){
		
		return taskRepo.findAll();
	}
	
	public Task getTaskById(int id) {
		return taskRepo.findById(id).orElse(null);
	}
	
	public Task createTask(Task task) {
		return taskRepo.save(task);
	}
	
	public Task editTask(int id, Task newTask) {
		Task oldTask= taskRepo.findById(id).orElse(null);
		
		if(oldTask !=null) {
			oldTask.setTitle(newTask.getTitle());
			oldTask.setDescription(newTask.getDescription());
			oldTask.setStatus(newTask.isStatus());
			oldTask.setDueDate(newTask.getDueDate());
			return taskRepo.save(oldTask);
		}else return null;	
		
	}
	
	public void deleteTask(int id) {
		taskRepo.deleteById(id);
	}

}
