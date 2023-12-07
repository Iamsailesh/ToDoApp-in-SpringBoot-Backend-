package com.jp.myapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.myapp.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
