package com.love.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.love.models.Task;
import com.love.repository.TaskRepository;


@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repo;
	
	public List<Task> getAllTasks() {
		return repo.findAll();
	}
	
	public void createTask(String title) {
		Task t = new Task();
		t.setTitle(title);
		t.setCompleted(false);
		repo.save(t);
	}
	
	public void deleteTask(Long id) {
		repo.deleteById(id);
	}
	
	public void toggleTask(Long id) {
		Task task = repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Task Id"));
		
		task.setCompleted(!task.getCompleted());
		
		// After changing the status of completion of task save the updated task
		repo.save(task);
	}
}
