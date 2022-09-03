package com.bill.controller.thyleaf;

import com.bill.dto.TodoListQueryResDto;
import com.bill.service.observe.ConcurrentMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoListThyleafController {

    @Autowired
    private ConcurrentMapService mapService;

    @GetMapping("/thyleaf/todoList")
    public String todoList() {
           return "todoList";
    }

    @GetMapping("/thyleaf/map/{id}")
    public String todo(@PathVariable Integer id, Model model) {
        TodoListQueryResDto todo = mapService.queryTodo(id);
        model.addAttribute("todo", todo);
        return "todo";
    }
}
