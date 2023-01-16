package planner.service;

import java.util.List;

import planner.dto.TaskDto;
import planner.entity.Task;
import planner.enums.ProgressType;

public interface TaskService {

	
	public void addNewTask(TaskDto taskDto);
	public void editTask(int taskId, String name, ProgressType progressType);
	public List<Task> getTaskList();

	
}
