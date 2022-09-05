package com.bill.service;

import com.bill.dto.*;
import com.bill.entity.TodoList;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ITodoListService {
    void createTodo(TodoListCreateReqDto reqDto);

    TodoList updateTodo(TodoListUpdateReqDto reqDto);

    void deleteTodo(TodoListDeleteReqDto reqDto);

    Page<TodoList> queryTodoList(int page, int size);

    TodoListQueryResDto queryTodo(Integer seqNo);

}
