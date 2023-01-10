package planner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROGRESS_HISTORY")
public class ProgressHistory {

	@Id @Column
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name =  "TASK_ID")
	private Task task;
	private int percentage;
	
	// nullable
	private Integer page;
	private Integer chapter;
	private Boolean passOrFail;
	
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
			this.task.getProgressHistories().remove(this);
		}
		this.task = task;
		this.task.getProgressHistories().add(this);
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
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
	@Override
	public String toString() {
		return "ProgressHistory [id=" + id + ", task=" + task + ", percentage=" + percentage + ", page=" + page
				+ ", chapter=" + chapter + ", passOrFail=" + passOrFail + "]";
	}

	
}
