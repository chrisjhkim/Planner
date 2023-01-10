package planner.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import planner.entity.TimerDetailHistory;
import planners.common.persistence.MyPersistenceUtil;

@SpringBootTest
class TimerServiceImplTest {
	@Autowired private TimerService timerService;
	
	@Test
//	@Transactional
	void testStart() {
		TimerDetailHistory detail = timerService.start();
		
		timerService.pause(detail);;
		
		System.out.println(detail);
		assertTrue(true);
		
		
		
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
