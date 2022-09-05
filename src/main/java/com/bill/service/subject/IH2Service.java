package com.bill.service.subject;

import com.bill.dto.TodoListCreateReqDto;
import com.bill.dto.TodoListDeleteReqDto;
import com.bill.dto.TodoListUpdateReqDto;
import com.bill.entity.TodoList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IH2Service {
    void createTodoList(TodoListCreateReqDto reqDto);
    TodoList updateTodoList(TodoListUpdateReqDto reqDto);
    void deleteTodoList(TodoList todo);
    Page<TodoList> queryTodoList(Pageable pageable);
    TodoList queryTodo(int seqNo);
}
