package planner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import planner.enums.ProgressType;

@Entity
@Table(name = "TASK")
public class Task {

	@Id
	private int id;
	private String name;
	private ProgressType progressType;
	private int percentage;
	
	
	
}
