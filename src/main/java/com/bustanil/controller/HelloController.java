package com.bustanil.controller;

import com.bustanil.model.Todo;
import com.bustanil.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.util.List;

@Controller
@ManagedBean
@ViewScoped
public class HelloController {


    @Autowired
    private TodoRepository todoRepository;

    private long id;

    private String message;
    private List<Todo> todoList;

    private boolean checked;

    private int countLeft ;

    private int countDone ;

    public String getMessage() {
        return message;
    }

    public void doneEachTask(){
        Todo todo = todoRepository.findOne(id);
        todo.setCompleted(true);
        todoRepository.save(todo);
    }

    public void saveTask(){
        Todo todo = new Todo();
        todo.setTask(message);
        todoRepository.save(todo);
    }

    public void deleteTask(){
        Todo todo = todoRepository.findOne(id);
        todoRepository.delete(todo);
    }

    public void showActive(){
        todoList =   todoRepository.showActive();
    }

    public void showDone(){
        todoList =   todoRepository.showDone();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getCountLeft() {
        return todoRepository.countLeft();
    }

    public void setCountLeft(int countLeft) {
        this.countLeft = countLeft;
    }

    public int getCountDone() {
        return todoRepository.countDone();
    }

    public void setCountDone(int countDone) {
        this.countDone = countDone;
    }
}
