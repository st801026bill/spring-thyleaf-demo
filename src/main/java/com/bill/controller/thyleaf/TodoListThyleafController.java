package com.bill.controller.thyleaf;

import com.bill.dto.TodoListCreateReqDto;
import com.bill.dto.TodoListQueryResDto;
import com.bill.dto.TodoListUpdateReqDto;
import com.bill.entity.TodoList;
import com.bill.service.TodoListService;
import com.bill.service.observe.ConcurrentMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TodoListThyleafController {

    @Autowired
    private ConcurrentMapService mapService;
    @Autowired
    private TodoListService todoListService;

    @GetMapping("/thyleaf/todoList")
    public String todoList(Model model) {
        List<TodoListQueryResDto> list = mapService.queryTodoList();
        model.addAttribute("todoList", list);
        return "todoList";
    }

    @GetMapping("/thyleaf/todo/{id}")
    public String todo(@PathVariable Integer id, Model model) {
        TodoListQueryResDto todo = mapService.queryTodo(id);

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
        TodoListQueryResDto todo = mapService.queryTodo(id);
        model.addAttribute("todo", todo);
        return "todo_input";
    }

    @PostMapping("/thyleaf/todo")
    public String saveTodo(TodoListUpdateReqDto reqDto, final RedirectAttributes attributes) {
        TodoList todo = todoListService.updateTodoList(reqDto);
        if(todo != null)
            attributes.addFlashAttribute("message", String.format("%s 新增成功", todo.getTodo()));
        return "redirect:/thyleaf/todoList";
    }
}
