package planner.service;

import java.util.List;

import planner.entity.Task;
import planner.entity.Timer;
import planner.enums.ProgressType;

public interface TaskService {

	
	public void addNewTask(String name, ProgressType progressType);
	public void editTask(int taskId, String name, ProgressType progressType);
	public List<Task> getTaskList();

	
}
