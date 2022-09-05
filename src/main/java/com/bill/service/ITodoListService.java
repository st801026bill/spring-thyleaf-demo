package com.bill.service;

import com.bill.dto.*;
import com.bill.entity.TodoList;

import java.util.List;

public interface ITodoListService {
    void createTodoList(TodoListCreateReqDto reqDto);

    TodoList updateTodoList(TodoListUpdateReqDto reqDto);

    void deleteTodoList(TodoListDeleteReqDto reqDto);
}
