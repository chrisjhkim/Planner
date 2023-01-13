package planner.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import planner.enums.ProgressType;

@Entity
@SequenceGenerator(
		name="TASK_SEQ_GENERATOR"
		,  sequenceName = "TASK_SEQ"
		, initialValue = 1
		, allocationSize = 1	// 기본값 : 50
		)
public class Task {

	@Id @Column(name = "TASK_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_SEQ_GENERATOR")
	private int id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Nullable
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
