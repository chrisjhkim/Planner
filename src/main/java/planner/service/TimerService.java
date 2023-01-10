package planner.service;

import java.util.List;

import planner.entity.ProgressHistory;
import planner.entity.Task;
import planner.entity.Timer;
import planner.entity.TimerDetailHistory;

public interface TimerService {

	public TimerDetailHistory start();
	public void pause(TimerDetailHistory timer);
	public void resume(Timer timer);
	public void stop(Timer timer);
	
	public List<TimerDetailHistory> getTimerDetailHistory(Timer timer);
	
	public void editTimerTask(Timer timer, Task task);
	public void editProgressStatus(Task task, ProgressHistory progressHistory);
	
	
}
