package com.love.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.love.models.Task;
import com.love.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@GetMapping
	public String getTasks(Model model) {
		List<Task> tasks = service.getAllTasks();
		model.addAttribute("tasks", tasks);
		return "tasks";
	}
	
	@PostMapping
	public String createTask(@RequestParam String title) {
		service.createTask(title);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable Long id) {
		service.deleteTask(id);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable Long id) {
		service.toggleTask(id);
		return "redirect:/";
	}
}
