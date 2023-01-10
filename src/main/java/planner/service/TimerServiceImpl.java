package planner.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Service;

import planner.entity.ProgressHistory;
import planner.entity.Task;
import planner.entity.Timer;
import planner.entity.TimerDetailHistory;
import planners.common.persistence.MyPersistenceUtil;

@Service
public class TimerServiceImpl implements TimerService {

	@Override
	public TimerDetailHistory start() {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		TimerDetailHistory detail = new TimerDetailHistory();
		try {
			tx.begin(); //트랜잭션 시작
			
			Timer timer = new Timer();
			em.persist(timer);
			
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
	public void pause(TimerDetailHistory detail) {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
			tx.begin(); //트랜잭션 시작
			
			detail = em.find(TimerDetailHistory.class, detail.getId());
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
	public void resume(Timer timer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop(Timer timer) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TimerDetailHistory> getTimerDetailHistory(Timer timer) {
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

}
