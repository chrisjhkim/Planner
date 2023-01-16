package planner.dto;

import java.time.LocalDateTime;

import planner.entity.Task;

public class TaskDto {

	private Integer id;
	private String name;
	
	private Integer percentage;
	private Integer page;
	private Integer chapter;
	private Boolean passOrFail;
	
	private LocalDateTime lastUpdateDate;
	
	public TaskDto() {
		super();
	}
	
	public TaskDto(Integer id) {
		super();
		this.id = id;
	}
	
	public TaskDto(Integer id, String name, Integer percentage) {
		super();
		this.id = id;	
		this.name = name;
		this.percentage = percentage;
	}

	public TaskDto(Task task) {
		super();
		this.id = task.getId();
		this.name = task.getName();
		this.percentage = task.getPercentage();
		this.page = task.getPage();
		this.chapter = task.getChapter();
		this.passOrFail = task.getPassOrFail();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
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

	@Override
	public String toString() {
		return "TaskDto [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
