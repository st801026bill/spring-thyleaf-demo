package com.bill.dao;

import com.bill.entity.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TodoListDao {
	
	@Autowired
	private TodoListRepository repository;
	
	public List<TodoList> findAll() {
			return repository.findAll();
	}
	
	public List<TodoList> findBySeqNo(int seqNo) {
		return repository.findBySeqNo(seqNo); 
	}
	
	public TodoList save(TodoList content) {
		if(content.getSeqNo() == null) content.setCreateDateTime(LocalDateTime.now());
//		content.setIsDone(content.getIsDone() == true? false: true);
		if(content.getCreateDateTime() != null)
			content.setCreateDateTime(LocalDateTime.now());
		content.setUpdateDateTime(LocalDateTime.now());
		return repository.save(content);
	}
	
	public void delete(TodoList content) {
		repository.delete(content);
	}
}
