package com.love.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.love.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	// no-code here 
}
