package planner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import planner.entity.ProgressHistory;
import planner.entity.Task;
import planner.entity.Timer;
import planner.enums.ProgressType;

@SpringBootTest
class MainTest {
	@BeforeAll
	static void setUp() {
		emf = Persistence.createEntityManagerFactory("jpabook");
	}
	
	
	@Test
	void main() {
		
		//엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
		
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		
		try {
			
			tx.begin(); //트랜잭션 시작
			
			//TODO 비즈니스 로직
			tx.commit();//트랜잭션 커밋
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //트랜잭션 롤백
		} finally {
			em.close(); //엔티티 매니저 종료
		}
		
		emf.close(); //엔티티 매니저 팩토리 종료
		assertTrue(true);
	}
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

	
	
	@Test
	@Transactional
	void testPlanner() {
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
			
			tx.begin(); //트랜잭션 시작
			Task test = em.find(Task.class, 1);
			System.out.println(test);
			
			Task task1 = new Task();
//			100, "jpa", ProgressType.NONE, 3);
			task1.setName("Docker");
			task1.setProgressType(ProgressType.NONE);
			task1.setPercentage(0);
			em.persist(task1);
			
			tx.commit();//트랜잭션 커밋
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //트랜잭션 롤백
		} finally {
			em.close(); //엔티티 매니저 종료
		}
//		emf.close(); //엔티티 매니저 팩토리 종료
		assertTrue(true);
	}
	
	
	@Test
	void testTask() {
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
			
			tx.begin(); //트랜잭션 시작
			Task test = em.find(Task.class, 1);
			System.out.println(test);
			
			
			
			tx.commit();//트랜잭션 커밋
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //트랜잭션 롤백
			fail("exception");
		} finally {
			em.close(); //엔티티 매니저 종료
		}
//		emf.close(); //엔티티 매니저 팩토리 종료
		assertTrue(true);
	}
	
	
	@Test
	void testProgressHistory() {
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
			
			tx.begin(); //트랜잭션 시작
			
			Task task = em.find(Task.class, 1);
			System.out.println(task);
			
			ProgressHistory ph = new ProgressHistory();
//			ph.setPercentage(100);
//			ph.setTask(task );
//			ph.setChapter(13);
//			
//			em.persist(ph);
//			System.out.println(task);
			
			
			tx.commit();//트랜잭션 커밋
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //트랜잭션 롤백
			fail("exception");
		} finally {
			em.close(); //엔티티 매니저 종료
		}
//		emf.close(); //엔티티 매니저 팩토리 종료
		assertTrue(true);
		
	}
}
