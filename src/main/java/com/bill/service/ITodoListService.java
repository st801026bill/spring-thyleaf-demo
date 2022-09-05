package com.bill.service;

import com.bill.dto.*;
import com.bill.entity.TodoList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITodoListService {
    void createTodo(TodoListCreateReqDto reqDto);

    TodoList updateTodo(TodoListUpdateReqDto reqDto);

    void deleteTodo(Integer seqNo);

    Page<TodoList> queryTodoList(Pageable pageable);

    TodoListQueryResDto queryTodo(Integer seqNo);

}
