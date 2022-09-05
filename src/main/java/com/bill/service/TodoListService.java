package com.bill.service;

import com.bill.dto.*;

import com.bill.entity.TodoList;
import com.bill.service.subject.H2Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService implements ITodoListService {

    @Autowired
    private H2Service h2Service;

    @Override
    public void createTodo(TodoListCreateReqDto reqDto) { h2Service.createTodoList(reqDto); }

    @Override
    public TodoList updateTodo(TodoListUpdateReqDto reqDto) {
        return h2Service.updateTodoList(reqDto);
    }

    @Override
    public void deleteTodo(TodoListDeleteReqDto reqDto) {
        h2Service.deleteTodoList(reqDto);
    }

    @Override
    public Page<TodoList> queryTodoList(int page, int size) {
        return h2Service.queryTodoList(page, size);
    }

    @Override
    public TodoListQueryResDto queryTodo(Integer seqNo) {
        TodoList todo = h2Service.queryTodo(seqNo);
        TodoListQueryResDto result = new TodoListQueryResDto();
        BeanUtils.copyProperties(todo, result);
        return result;
    }


}
