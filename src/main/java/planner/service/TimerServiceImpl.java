package planner.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import planner.entity.ProgressHistory;
import planner.entity.Task;
import planner.entity.Timer;
import planner.entity.TimerDetailHistory;
import planners.common.persistence.MyPersistenceUtil;

@Service
public class TimerServiceImpl implements TimerService {

	@Override
	public TimerDetailHistory start(Integer taskId) {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		TimerDetailHistory detail = new TimerDetailHistory();
		try {
			tx.begin(); //트랜잭션 시작
			
			Timer timer = new Timer();
			em.persist(timer);
			
			if ( taskId != null ) {
				Task task = em.find(Task.class, taskId);
				timer.setTask(task);
			}
			
			detail.setStartTime(LocalDateTime.now());
			detail.setTimer(timer);
			em.persist(detail);
			
			
			tx.commit();//트랜잭션 커밋
		} catch (Exception e) {
			tx.rollback(); //트랜잭션 롤백
			throw e;
		} finally {
			em.close(); //엔티티 매니저 종료
		}

		return detail;
	}

	@Override
	public Integer pause(int detailId) {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		Integer timerId;
		try {
			tx.begin(); //트랜잭션 시작
			
			TimerDetailHistory detail = em.find(TimerDetailHistory.class, detailId);
			detail.setEndTime(LocalDateTime.now());
			timerId = detail.getTimer().getId();
			tx.commit();//트랜잭션 커밋
		} catch (Exception e) {
			tx.rollback(); //트랜잭션 롤백
			throw e;
		} finally {
			em.close(); //엔티티 매니저 종료
		}
		return timerId;
	}

	@Override
	public TimerDetailHistory resume(int timerId) {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		TimerDetailHistory detail = new TimerDetailHistory();
		try {
			tx.begin(); //트랜잭션 시작

			Timer timer = em.find(Timer.class, timerId);
			
			detail.setStartTime(LocalDateTime.now());
			detail.setTimer(timer);
			em.persist(detail);
			
			
			tx.commit();//트랜잭션 커밋
		} catch (Exception e) {
			tx.rollback(); //트랜잭션 롤백
			throw e;
		} finally {
			em.close(); //엔티티 매니저 종료
		}

		return detail;

	}

	@Override
	public void stop(int detailId) {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
			tx.begin(); //트랜잭션 시작
			
			TimerDetailHistory detail = em.find(TimerDetailHistory.class, detailId);
			detail.setEndTime(LocalDateTime.now());
			
			tx.commit();//트랜잭션 커밋
		} catch (Exception e) {
			tx.rollback(); //트랜잭션 롤백
			throw e;
		} finally {
			em.close(); //엔티티 매니저 종료
		}
	}

	@Override
	public List<TimerDetailHistory> getTimerDetailHistory(Timer timer) {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
			tx.begin(); //트랜잭션 시작
			timer = em.find(Timer.class, timer.getId());
			TimerDetailHistory detail = em.find(TimerDetailHistory.class, timer.getId());
			detail.setEndTime(LocalDateTime.now());
			
			tx.commit();//트랜잭션 커밋
		} catch (Exception e) {
			tx.rollback(); //트랜잭션 롤백
			throw e;
		} finally {
			em.close(); //엔티티 매니저 종료
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editTimerTask(Timer timer, Task task) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editProgressStatus(Task task, ProgressHistory progressHistory) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Timer> getTimerList(int taskId) {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		List<Timer> result;
		try {
			tx.begin(); //트랜잭션 시작
			
			Task task = em.find(Task.class, taskId);
			
			result = task.getTimers();
			
			
			
			
		} catch (Exception e) {
			tx.rollback(); //트랜잭션 롤백
			throw e;
		} finally {
			em.close(); //엔티티 매니저 종료
		}
		return result;

	}


}
