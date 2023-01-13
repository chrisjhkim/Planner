package planner.service;

import java.util.List;

import planner.dto.TaskDto;
import planner.entity.ProgressHistory;
import planner.entity.Task;
import planner.entity.Timer;
import planner.entity.TimerDetailHistory;

public interface TimerService {

	public TimerDetailHistory start(Integer taskId);
	public Integer pause(int detailId);
	public TimerDetailHistory resume(int timerId);
	public void stop(int detailId);
	
	public List<Timer> getTimerList(int taskId);
	public List<TimerDetailHistory> getTimerDetailHistory(Timer timer);
	
	public void editTimerTask(Timer timer, Task task);
	public void editProgressStatus(Task task, ProgressHistory progressHistory);
	
	
}
