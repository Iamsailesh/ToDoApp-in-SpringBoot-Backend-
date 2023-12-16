package com.jp.myapp.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String  title;
	private String description;
	private boolean isCompleted;
	private LocalDate dueDate;
	public Task(int id, String title, String desc, boolean status, LocalDate dueDate) {
		super();
		this.id = id;
		this.title = title;
		description = desc;
		this.isCompleted = status;
		this.dueDate = dueDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		description = desc;
	}
	public boolean isStatus() {
		return isCompleted;
	}
	public void setStatus(boolean status) {
		this.isCompleted = status;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", Description=" + description + ", status=" + isCompleted
				+ ", dueDate=" + dueDate + "]";
	}
	

}
