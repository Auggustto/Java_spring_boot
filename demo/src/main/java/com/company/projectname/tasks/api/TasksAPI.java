package com.company.projectname.tasks.api;

import org.springframework.http.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.projectname.tasks.dto.TasksDTO;
import com.company.projectname.tasks.facade.TasksFacade;

@Controller
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TasksAPI {

    // instanciando o facade
    @Autowired
    private TasksFacade tasksFacade;

    @PostMapping
    @ResponseBody
    public TasksDTO postTasks(@RequestBody TasksDTO tasksDTO) {
        return tasksFacade.postTasks(tasksDTO);
    }

    @PutMapping("/{taskId}")
    @ResponseBody
    public TasksDTO putTasks(@PathVariable("taskId") Long taskId, @RequestBody TasksDTO tasksDTO) {
        return tasksFacade.putTasks(tasksDTO, taskId);
    }

    @GetMapping
    @ResponseBody
    public List<TasksDTO> getAll() {
        return tasksFacade.getAll();
    }

    @DeleteMapping("/{taskId}")
    @ResponseBody
    public String deleteTask(@PathVariable("taskId") Long taskId){
        return tasksFacade.deleteTasks(taskId);
    }
}
