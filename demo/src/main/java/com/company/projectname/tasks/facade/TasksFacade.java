package com.company.projectname.tasks.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.company.projectname.tasks.dto.TasksDTO;

@Service
public class TasksFacade {

    private static final Map<Long, TasksDTO> tasks = new HashMap<>();

    public TasksDTO postTasks(TasksDTO tasksDTO) {

        // imcrementando id
        Long nextId = tasks.keySet().size() + 1L;
        tasksDTO.setId(nextId);
        tasks.put(nextId, tasksDTO);

        return tasksDTO;
    }

    public TasksDTO putTasks(TasksDTO tasksDTO, long tasksId) {
        tasks.put(tasksId, tasksDTO);
        return tasksDTO;
    }

    public TasksDTO getTasks(long tasksId) {
        return tasks.get(tasksId);
    }

    public List<TasksDTO> getAll() {
        return new ArrayList<>(tasks.values());
    }

    public String deleteTasks(long tasksId) {
        tasks.remove(tasksId);
        return "DELETED";
    }

}
