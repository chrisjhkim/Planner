package planner.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Timer {
	@Id @Column(name = "TIMER_ID")
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "TASK_ID")
	@JsonIgnore
	private Task task; 

	// nullable
	private Integer percentage;
	private Integer page;
	private Integer chapter;
	private Boolean passOrFail;
	

	
	// TODO ? mapped by 잘 모르겠음
	@OneToMany(mappedBy = "timer") 
	private List<TimerDetailHistory> timerDetailHistorys = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		if ( this.task != null ) {
			this.task.getTimers().remove(this);
		}
		this.task = task;
		this.task.getTimers().add(this);
	}

	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getChapter() {
		return chapter;
	}
	public void setChapter(Integer chapter) {
		this.chapter = chapter;
	}
	public Boolean getPassOrFail() {
		return passOrFail;
	}
	public void setPassOrFail(Boolean passOrFail) {
		this.passOrFail = passOrFail;
	}

	public List<TimerDetailHistory> getTimerDetailHistorys() {
		return timerDetailHistorys;
	}

	public void setTimerDetailHistorys(List<TimerDetailHistory> timerDetailHistorys) {
		this.timerDetailHistorys = timerDetailHistorys;
	}

	public List<TimerDetailHistory> getTimerDetailHistories() {
		return timerDetailHistorys;
	}

	public void setTimerDetailHistories(List<TimerDetailHistory> timerDetailHistorys) {
		this.timerDetailHistorys = timerDetailHistorys;
	}

	@Override
	public String toString() {
		return "Timer [id=" + id + ", task=" + task + ", timerDetailHistorys.size=" + this.timerDetailHistorys.size() + "]";
	}
	
	
}