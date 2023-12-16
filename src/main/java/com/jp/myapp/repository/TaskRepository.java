package com.jp.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.myapp.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
