package planner.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import planner.dto.TaskDto;
import planner.dto.TimerDto;
import planner.entity.Task;
import planner.entity.Timer;
import planner.entity.TimerDetailHistory;
import planner.service.TaskService;
import planner.service.TimerService;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	private final TimerService timerService;
	private final TaskService taskService;
	
	@Autowired
	public MainController(TimerService timerService, TaskService taskService) {
		super();
		this.timerService = timerService;
		this.taskService = taskService;
	}

	@PostMapping("/start")
	public ResponseEntity<Integer> start(@RequestBody @Nullable TaskDto task){
		logger.info("/start {} ", task);
		Integer taskId = task==null?null : task.getId();
		TimerDetailHistory detial = timerService.start(taskId );
		return ResponseEntity.ok(detial.getId());
	}
	
	@PutMapping("/pause/{id}")
	public ResponseEntity<Integer> pause(@PathVariable(value="id") int detailId){
		logger.info("/pause {}", detailId);
		
		Integer timerId = timerService.pause(detailId);
		return ResponseEntity.ok(timerId);
	}
	
	@PutMapping("/finish/{id}")
	public ResponseEntity<Integer> finish(@PathVariable(value = "id") int detailId) {
		logger.info("/finish {}", detailId);
		timerService.stop(detailId);
		return ResponseEntity.ok(null);
	}
	@PostMapping("/resume")
	public ResponseEntity<Integer> resume(@RequestBody TimerDto timer){
		logger.info("/resume {}", timer);
		
		TimerDetailHistory detail = timerService.resume(timer.getId());
		
		return ResponseEntity.ok(detail.getId());
	}

	@GetMapping("/taskList")
	public ResponseEntity<List<TaskDto>> taskList(){
		logger.info("/taskList");
		List<Task> temp = taskService.getTaskList();
		List<TaskDto> tasks = temp.stream()
				.map(TaskDto::new)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(tasks);
	}
	@GetMapping("/taskTimerList/{taskId}")
	public ResponseEntity<List<Timer>> taskTimerList(@PathVariable(value = "taskId")int taskId){
		logger.info("/taskTimerList {}", taskId);
		List<Timer> list = timerService.getTimerList(taskId);;
		
		return ResponseEntity.ok(list);
	}
	@GetMapping("/index")
	public String index() {
		return "index.html";
	}
	@GetMapping("/tasklist")
	public String tasklist() {
		return "tasklist.html";
	}
	@GetMapping("/taskdetail")
	public String taskDetail() {
		return "taskdetail.html";
	}
}

