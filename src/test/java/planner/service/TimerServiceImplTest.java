package planner.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import planner.entity.Task;
import planner.entity.Timer;
import planner.entity.TimerDetailHistory;
import planner.test.PlannerTestUtil;
import planners.common.persistence.MyPersistenceUtil;

@SpringBootTest
class TimerServiceImplTest {
	
	private static final Logger logger = LoggerFactory.getLogger(TimerServiceImplTest.class);

	@Autowired private TimerService timerService;
	
	@Test
//	@Transactional
	void testStart() {
		TimerDetailHistory detail = timerService.start(null);
		assertNotNull(detail);
		assertNotNull(detail.getId());
//		EntityManager em = MyPersistenceUtil.createEntityManager();
//		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
//		try {
//			tx.begin(); //트랜잭션 시작
//			List<TimerDetailHistory> tempList = em.createQuery("SELECT d FROM TimerDetailHistory d ").getResultList();
//			assertNotNull(tempList);
//			assertNotEquals(0, tempList.size());
//			detailId = tempList.get(0).getId();
//			tx.commit();//트랜잭션 커밋
//		} catch (Exception e) {
//			tx.rollback(); //트랜잭션 롤백
//			throw e;
//		} finally {
//			em.close(); //엔티티 매니저 종료
//		}

		
		PlannerTestUtil.saveDetailId(detail);
		
		
		timerService.pause(detail.getId());;
		logger.info("started detail id = {}",detail.getId());
		timerService.resume(detail.getTimer().getId());
		assertTrue(true);
	}
	
	@Test
	void testStop() {
		Integer detailId = PlannerTestUtil.getDetailIdFromFile();
		timerService.stop(detailId);
		assertTrue(true);
	}
	
//	@Test
	void testList() {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		int taskId;
		try {
			tx.begin(); //트랜잭션 시작
			List<Task> tempList = em.createQuery("SELECT t FROM Task t ").getResultList();
			assertNotNull(tempList);
			assertNotEquals(0, tempList.size());
			taskId  = tempList.get(0).getId();
			tx.commit();//트랜잭션 커밋
		} catch (Exception e) {
			tx.rollback(); //트랜잭션 롤백
			throw e;
		} finally {
			em.close(); //엔티티 매니저 종료
		}
		
		List<Timer> result = timerService.getTimerList(taskId);
		logger.info(result.toString());
	}
	
	@Test
	void testLocalDateTime() {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
			tx.begin(); //트랜잭션 시작

			TimerDetailHistory test = em.find(TimerDetailHistory.class, 10);
			System.out.println(test);
			
			
			tx.commit();//트랜잭션 커밋
		} catch (Exception e) {
			tx.rollback(); //트랜잭션 롤백
			throw e;
		} finally {
			em.close(); //엔티티 매니저 종료
		}

	}

	
	
}
