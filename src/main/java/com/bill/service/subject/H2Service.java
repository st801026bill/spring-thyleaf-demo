package com.bill.service.subject;

import com.bill.dao.TodoListDao;
import com.bill.dto.TodoListCreateReqDto;
import com.bill.dto.TodoListDeleteReqDto;
import com.bill.dto.TodoListUpdateReqDto;
import com.bill.entity.TodoList;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class H2Service implements IH2Service {

    @Autowired
    private TodoListDao todoListDao;

    @Override
    public void createTodoList(TodoListCreateReqDto reqDto) {
        todoListDao.save(reqDto.toEntity());
    }

    @Override
    public TodoList updateTodoList(TodoListUpdateReqDto reqDto) {
        TodoList todo = null;
        if(reqDto.getSeqNo() == null) {
            todo = reqDto.toEntity();
            todo.setIsDone(false);
        } else {
            todo = todoListDao.findBySeqNo(reqDto.getSeqNo());
            todo.setTodo(reqDto.getTodo());
            todo.setIsDone(reqDto.getIsDone());
        }
        return todoListDao.save(todo);
    }

    @Override
    public void deleteTodoList(TodoList todo) {
        todoListDao.delete(todo);
    }

    @Override
    public Page<TodoList> queryTodoList(Pageable pageable) {

        return todoListDao.findAllByPage(pageable);
    }

    @Override
    public TodoList queryTodo(int seqNo) {
        return todoListDao.findBySeqNo(seqNo);
    }
}
