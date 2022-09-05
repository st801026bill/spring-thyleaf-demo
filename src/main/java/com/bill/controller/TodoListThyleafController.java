package com.bill.controller;

import com.bill.dto.TodoListQueryResDto;
import com.bill.dto.TodoListUpdateReqDto;
import com.bill.entity.TodoList;
import com.bill.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TodoListThyleafController {

    @Autowired
    private TodoListService service;

    @GetMapping("/thyleaf/todoList")
    public String todoList(
            @PageableDefault(size = 5, sort = {"seqNo"}, direction = Sort.Direction.DESC) Pageable pageable,
            Model model) {
        Page<TodoList> todoList = service.queryTodoList(pageable);
        model.addAttribute("todoList", todoList);
        return "todoList";
    }

    @GetMapping("/thyleaf/todo/{id}")
    public String todo(@PathVariable Integer id, Model model) {
        TodoListQueryResDto todo = service.queryTodo(id);

        if(todo == null) todo = new TodoListQueryResDto();

        model.addAttribute("todo", todo);
        return "todo";
    }

    @GetMapping("/thyleaf/todo/input")
    public String inputPage(Model model) {
        model.addAttribute("todo", new TodoListQueryResDto());
        return "todo_input";
    }

    @GetMapping("/thyleaf/todo/input/{id}")
    public String editPage(@PathVariable Integer id, Model model) {
        TodoListQueryResDto todo = service.queryTodo(id);
        model.addAttribute("todo", todo);
        return "todo_input";
    }

    @PostMapping("/thyleaf/todo")
    public String saveTodo(TodoListUpdateReqDto reqDto, final RedirectAttributes attributes) {
        TodoList todo = service.updateTodo(reqDto);
        if(todo != null)
            attributes.addFlashAttribute("message", String.format("%s 新增成功", todo.getTodo()));
        return "redirect:/thyleaf/todoList";
    }

    @GetMapping("/thyleaf/todo/delete/{id}")
    public String deleteTodo(@PathVariable Integer id, final RedirectAttributes attributes) {
        service.deleteTodo(id);
        attributes.addFlashAttribute("message", "刪除成功");
        return "redirect:/thyleaf/todoList";
    }
}
