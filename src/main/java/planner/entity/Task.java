package planner.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import planner.enums.ProgressType;

@Entity
public class Task {

	@Id @Column(name = "TASK_ID")
	@GeneratedValue
	private int id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private ProgressType progressType;
	
	private int percentage;
	
	@OneToMany(mappedBy = "task")
	private List<Timer> timers = new ArrayList<>();
	
	@OneToMany(mappedBy = "task")
	private List<ProgressHistory> progressHistories = new ArrayList<>();

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProgressType getProgressType() {
		return progressType;
	}

	public void setProgressType(ProgressType progressType) {
		this.progressType = progressType;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public List<Timer> getTimers() {
		return timers;
	}

	public void setTimers(List<Timer> timers) {
		this.timers = timers;
	}

	public List<ProgressHistory> getProgressHistories() {
		return progressHistories;
	}

	public void setProgressHistories(List<ProgressHistory> progressHistories) {
		this.progressHistories = progressHistories;
	}
//	

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", progressType=" + progressType + ", percentage=" + percentage
				+ ", progressHistories=" + progressHistories.stream().map(ProgressHistory::getId).collect(Collectors.toList()).toString() + "]";
	}


	
	
}
