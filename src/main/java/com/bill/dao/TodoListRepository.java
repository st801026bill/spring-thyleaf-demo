package com.bill.dao;

import com.bill.entity.TodoList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoListRepository extends JpaRepository<TodoList, Integer> {
		public TodoList findBySeqNo(int seqNo);

		Page<TodoList> findAll(Pageable pageable);
}
