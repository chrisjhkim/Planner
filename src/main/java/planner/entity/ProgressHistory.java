package planner.entity;

import javax.persistence.Entity;

@Entity
public class ProgressHistory {

	private int id;
	private int taskId;
	private int percentage;
	
	// nullable
	private Integer page;
	private Integer chapter;
	private Boolean passOrFail;
	
}
