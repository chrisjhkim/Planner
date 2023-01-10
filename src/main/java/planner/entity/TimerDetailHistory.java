package planner.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TIMER_DETAIL_HISTORY")
public class TimerDetailHistory {
	@Id @Column(name = "TIMER_DETAIL_HISTORY_ID")
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="TIMER_ID")
	private Timer timer;
	
	private LocalDateTime startTime;
	@Column(nullable = true)
	private LocalDateTime endTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		if ( this.timer != null ) {
			this.timer.getTimerDetailHistories().remove(this);
		}
		this.timer = timer;
		timer.getTimerDetailHistories().add(this);
	}
	
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "TimerDetailHistory [id=" + id + ", timer=" + timer + ", startTime=" + startTime + ", endTime=" + endTime
				+ "]";
	}

	
	
}
